package p1;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class MainDS1 {
	public static void main(String[] args) throws InterruptedException {
		Buffer<IconProducer> producerBuffer	= new Buffer<IconProducer>();	
		IconProducerManager ipManager = new IconProducerManager(producerBuffer);		
		ipManager.appendIconProd(new FileProducer(getFilenameArray(),500,2));
		ipManager.appendIconProd(new FileProducer("C:/Users/Barry/Desktop/Eclipse Bilder/yeah.txt"));
		ipManager.appendIconProd(new ArrayProducer(getIconArray(),500,2));
		
		TestDS1 testDs1 = new TestDS1(producerBuffer);
		testDs1.start();
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
	private static Icon[] getIconArray() {
		Icon[] res = {new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new1.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new2.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new3.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new4.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new5.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new6.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new7.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new8.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new9.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new10.jpg")};
		return res;
	}
}
