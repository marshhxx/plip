package com.plip.systemmonitor;


import java.util.ArrayList;
import java.util.EventObject;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import com.plip.eventhandlers.events.FinishCounterEvent;
import com.plip.eventhandlers.events.StartCounterEvent;
import com.plip.eventhandlers.events.TrayArrivalEvent;
import com.plip.eventhandlers.events.TrayDepartureEvent;
import com.plip.eventhandlers.handlers.CounterEventHandler;
import com.plip.eventhandlers.handlers.TrayEventHandler;
import com.plip.eventhandlers.listeners.GenericEventListener;
import com.plip.imageprocessing.processors.ObjectCounter;
import com.plip.imageprocessing.processors.TrayProcessor;
import com.plip.imageprocessing.processors.Exceptions.NoImageException;
import com.plip.uinterfaces.MainMenuFrame;


// Queda pendiente organizar handlers para todos los eventos 

public class MainSystemMonitor implements GenericEventListener {
	private VideoCapture vcapture;
	private TrayProcessor tprocessor;
	private ObjectCounter ocounter;
	private TrayEventHandler tehandler;
	private CounterEventHandler cehandler;
	private MainMenuFrame mmf;
	

	public MainSystemMonitor() {
		super();
		mmf = new MainMenuFrame(this);
		mmf.setVisible(true);
	}

	public static void main(String arg[]) {
		System.loadLibrary("opencv_java246");
//		MainSystemMonitor msm = new MainSystemMonitor();
//		msm.initializeCapture();
		
//		PlipTrainer trainer = new PlipTrainer();
//		trainer.processProductImages();
//		PlipRoleDao roleDao = new PlipRoleDaoImpl();
		
//		//PlipRole role = new PlipRole("administrador", "Aministra y monitorea el sistema y sus productos"); 
//		try {
//			roleDao.getRole(5);
//		} catch (PlipRoleNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ProductDaoImpl pDao = new ProductDaoImpl();
//		Product product = pDao.getProduct(1);
//		Set images =  product.getImages();
//		Iterator it = images.iterator();
//		while(it.hasNext()){
//			Image img = (Image) it.next();
//			System.out.println(img.getPath());
//		}
//		ObjectCounter counter = new ObjectCounter();
//		Mat image = Highgui.imread(MainSystemMonitor.class.getResource("/49.jpg").getPath());
//		try{
//		ArrayList<Mat> foundObjects = counter.count(image);
//		PageDao pageDao = new PageDaoImpl();
//		Page page = new Page();
//		try {
//			page = pageDao.getPage(1);
//		} catch (PageNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		OrbBriskDetector orbBriskDetector = new OrbBriskDetector();
//		orbBriskDetector.recognize(page, foundObjects);
//		}catch(NoImageException e){
//			e.printStackTrace();
//		}
}

	/*CvCapture *cap;
	int n = 0;
	while(1)
	{
	   cap = cvCreateCameraCapture(n++);
	   if (cap == NULL) break;
	   cvReleaseCapture(&cap);
	}

	cvReleaseCapture(&cap);
	return n-1;
	*/
	public void initializeCapture() {

		vcapture = new VideoCapture(0);
		vcapture.set(Highgui.CV_CAP_PROP_FRAME_WIDTH, 640);
		vcapture.set(Highgui.CV_CAP_PROP_FRAME_HEIGHT, 480);
		tprocessor = new TrayProcessor();
		ocounter = new ObjectCounter();
		tehandler = new TrayEventHandler();
		cehandler = new CounterEventHandler();
		tehandler.addEventListener(mmf);
		tehandler.addEventListener(this);
		cehandler.addEventListener(this);
	}

	public Mat captureVideoFrame() {
		Mat capturedFrame = new Mat();
		if (vcapture.isOpened()) {
			vcapture.read(capturedFrame);
			if (!capturedFrame.empty()) {
				capturedFrame = tprocessor.findRectangleInImage(capturedFrame);
				Mat possibleTray = tprocessor.getPossibleTray();
				tehandler.addTray(possibleTray);
				tprocessor.clearPossibleTray();
			} else {
				capturedFrame = null;
			}
		}
		return capturedFrame;
	}

	@Override
	public void handleEvent(EventObject event) {
		if (event instanceof TrayArrivalEvent) {
			System.out.println("Arrival");
			//1620 X 1080			
			vcapture.set(Highgui.CV_CAP_PROP_FRAME_WIDTH, 1620);
			vcapture.set(Highgui.CV_CAP_PROP_FRAME_HEIGHT, 1080);
			
			try {
			    Thread.sleep(400);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			Mat screenshot = new Mat(); 
			vcapture.read(screenshot);
			
			Highgui.imwrite("Tray.jpg", screenshot);
			
			vcapture.set(Highgui.CV_CAP_PROP_FRAME_WIDTH, 640);
			vcapture.set(Highgui.CV_CAP_PROP_FRAME_HEIGHT, 480);
			
			TrayArrivalEvent temp = (TrayArrivalEvent) event;
			ArrayList<Mat> images = new ArrayList<Mat>();
			try{
				images = ocounter.count(screenshot);
				}catch(NoImageException e){
				e.printStackTrace();
			}
			cehandler.addCountedObjects(images);
		} else if (event instanceof TrayDepartureEvent) {
			System.out.println("Departure");
		} else if (event instanceof StartCounterEvent) {
			System.out.println("StartedCount");
		} else if (event instanceof FinishCounterEvent) {
			System.out.println("FinishedCount");
		}
	}
}
