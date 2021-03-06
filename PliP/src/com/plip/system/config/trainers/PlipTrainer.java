package com.plip.system.config.trainers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.opencv.core.Mat;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.FeatureDetector;
import org.opencv.highgui.Highgui;

import com.plip.exceptions.persistence.ImageNotFoundException;
import com.plip.exceptions.persistence.NullModelAttributesException;
import com.plip.exceptions.persistence.PositionNotFoundException;
import com.plip.exceptions.persistence.ProductNotFoundException;
import com.plip.imageprocessing.processors.ImageDescriptorExtractor;
import com.plip.persistence.daos.impls.ImageDaoImpl;
import com.plip.persistence.daos.impls.PositionDaoImpl;
import com.plip.persistence.daos.impls.ProductDaoImpl;
import com.plip.persistence.daos.interfaces.ImageDao;
import com.plip.persistence.managers.DataTypeManager;
import com.plip.persistence.managers.FileSystemManager;
import com.plip.persistence.managers.images.HashImageManager;
import com.plip.persistence.managers.images.ImageManager;
import com.plip.persistence.model.Image;
import com.plip.persistence.model.Position;
import com.plip.persistence.model.Product;

public class PlipTrainer {
	
	public static String imagesPath; 

	public void initializeSystem() {
		File productImageFolder = new File(imagesPath);
		ImageDescriptorExtractor extractor = new ImageDescriptorExtractor(
				FeatureDetector.ORB, DescriptorExtractor.BRISK);
		ImageManager imageManager = new HashImageManager();
		File[] productImageListOfFiles = productImageFolder.listFiles();
		ProductDaoImpl pDao = new ProductDaoImpl();
		ImageDaoImpl iDao = new ImageDaoImpl();

		for (int i = 0; i < productImageListOfFiles.length; i++) {
			if (productImageListOfFiles[i].isFile()
					&& !((productImageListOfFiles[i].getName())
							.equals(".DS_Store"))) {
				String imagePath = productImageListOfFiles[i].getPath();
				Mat productImage = Highgui.imread(imagePath);
				Mat descriptors = extractor.extractDescriptor(productImage);
				String filename = FileSystemManager
						.stripExtension(productImageListOfFiles[i].getName());
				String[] split = filename.split("_");
				String productName = "";
				Position pos = new Position();
				if (split.length > 0) {
					productName = split[0];
				}
				if (split.length > 1) {
					pos = getCodePosition(split[1]);
				} else {
					pos = getCodePosition(null);
				}
				Product product = new Product();
				try {
					product = pDao.getProductByName(productName);
					if(product.getImageNumber()!=null){
					product.setImageNumber(product.getImageNumber() +1);
					}else{
				    product.setImageNumber(0);	
					}
					pDao.updateProduct(product);
				} catch (ProductNotFoundException e) {
					product.setName(productName);
					product.setEnabled(true);
					product.setLaboratory("");
					product.setDescription(productName);
					product.setCode(i+1);
					product.setImageNumber(1);
					try {
						pDao.addProduct(product);
					} catch (NullModelAttributesException e1) {
						e1.printStackTrace();
					}
				}
				Set images = product.getImages();
				if (images == null) {
					images = new HashSet<Image>();
				}
				Image image = new Image();

				try {
					image = iDao.getImageByProductIdAndPositio(
							product.getIdProduct(), pos.getIdPosition());
					if(descriptors != null && descriptors.rows() != 0){
						image.setDescriptor(DataTypeManager
								.convertMatToBlob(descriptors));
						image.setTrained(true);
					}
					String path = imageManager.getImagesPath(filename);
					FileSystemManager.checkDirectoryExists(path);
					Highgui.imwrite(path + filename +".jpg", productImage);
					image.setPath(path + filename +".jpg");
					
					iDao.updateImage(image);

				} catch (ImageNotFoundException e) {
					image.setPosition(pos);
					image.setProduct(product);
					if(descriptors != null && descriptors.rows() != 0){
					image.setDescriptor(DataTypeManager
							.convertMatToBlob(descriptors));
					image.setTrained(true);
					}else{
					image.setTrained(false);
					}
					
					String path = imageManager.getImagesPath(filename);
					FileSystemManager.checkDirectoryExists(path);
					Highgui.imwrite(path + filename +".jpg", productImage);
					image.setPath(path + filename +".jpg");
					
					try {
						iDao.addImage(image);
					} catch (NullModelAttributesException e1) {
						e1.printStackTrace();
					}
				}
				images.add(image);
				product.setImages(images);
			}
		}
	}

	public Position getCodePosition(String code) {
		PositionDaoImpl positionDao = new PositionDaoImpl();
		Position position = new Position();
		try {
			position = positionDao.getPosition(1);
			;
			if (code != null) {
				switch (code) {
				case "U":
					position = positionDao.getPosition(1);
					break;
				case "R":
					position = positionDao.getPosition(2);
					break;
				case "D":
					position = positionDao.getPosition(3);
					break;
				case "L":
					position = positionDao.getPosition(4);
					break;
				default:
					break;
				}
			}
		} catch (PositionNotFoundException e) {
			e.printStackTrace();
		}
		return position;
	}

	public void train() throws ImageNotFoundException {
		ImageDao imageDao = new ImageDaoImpl();
		List<Image> images = new ArrayList<Image>();
		ImageDescriptorExtractor extractor = new ImageDescriptorExtractor(
				FeatureDetector.ORB, DescriptorExtractor.BRISK);
		
    	images = imageDao.getNotTrainedImages();

		for (Image image : images) {
			String path = image.getPath();
			Mat imageMat = Highgui.imread(path);
			Mat descriptor = extractor.extractDescriptor(imageMat);
			if (descriptor != null && descriptor.rows()!=0) {
				image.setDescriptor(DataTypeManager
						.convertMatToBlob(descriptor));
				image.setTrained(true);
				try {
					imageDao.updateImage(image);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
