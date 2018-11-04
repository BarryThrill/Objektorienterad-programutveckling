package p1;

import javax.swing.Icon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class MainDS2 {
	public static void main(String[] args) {
		Buffer<IconProducer> producerBuffer	= new Buffer<IconProducer>();
		Buffer<Icon> iconBuffer	= new Buffer<Icon>();
				
		IconProducerManager ipManager = new IconProducerManager(producerBuffer);		
		ipManager.appendIconProd(new FileProducer(getFilenameArray(),500,2));
		
		Producer producer = new Producer(producerBuffer,iconBuffer);
		producer.start();
		
		TestDS2 testDs2 = new TestDS2(iconBuffer);
		testDs2.start();
	}
	
	private static String[] getFilenameArray() {
	       String[] res = {"/Users/Barry/Desktop/Eclipse Bilder/new1.jpg",
	    		   "/Users/Barry/Desktop/Eclipse Bilder/new2.jpg",
	    		   "/Users/Barry/Desktop/Eclipse Bilder/new3.jpg",
	        		"/Users/Barry/Desktop/Eclipse Bilder/new4.jpg",
	        		"/Users/Barry/Desktop/Eclipse Bilder/new5.jpg",
	        		"/Users/Barry/Desktop/Eclipse Bilder/new6.jpg",
	        		"/Users/Barry/Desktop/Eclipse Bilder/new7.jpg",
	        		"/Users/Barry/Desktop/Eclipse Bilder/new8.jpg",
	        		"/Users/Barry/Desktop/Eclipse Bilder/new9.jpg",
	        		"/Users/Barry/Desktop/Eclipse Bilder/new10.jpg"};
			return res;
	}
}
