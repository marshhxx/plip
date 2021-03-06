package com.plip.persistence.model;

// Generated Jan 25, 2014 5:33:45 PM by Hibernate Tools 4.0.0

/**
 * Image generated by hbm2java
 */
public class Image implements java.io.Serializable {

	private Long idImage;
	private Product product;
	private Position position;
	private String path;
	private String name;
	private byte[] descriptor;
	private boolean trained;

	public Image() {
	}

	public Image(Product product, Position position, String path,
			boolean trained) {
		this.product = product;
		this.position = position;
		this.path = path;
		this.trained = trained;
	}

	public Image(Product product, Position position, String path, String name,
			byte[] descriptor, boolean trained) {
		this.product = product;
		this.position = position;
		this.path = path;
		this.name = name;
		this.descriptor = descriptor;
		this.trained = trained;
	}

	public Long getIdImage() {
		return this.idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getDescriptor() {
		return this.descriptor;
	}

	public void setDescriptor(byte[] descriptor) {
		this.descriptor = descriptor;
	}

	public boolean isTrained() {
		return this.trained;
	}

	public void setTrained(boolean trained) {
		this.trained = trained;
	}
	
	public boolean validate(){
		if( product!=null && position!=null && path!=null){
			return true;
		}else return false;
	}


}
