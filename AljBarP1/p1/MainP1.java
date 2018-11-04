package p1;

import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class MainP1 {
	public static void main(String[] args) throws IOException {
		Buffer<Icon> iconBuffer = new Buffer<Icon>();
		Buffer<IconProducer> producerBuffer	= new Buffer<IconProducer>();
		IconManager iconManager = new IconManager(iconBuffer);
		new ViewerWindow( new Viewer(iconManager,640,480) ); 
		new ViewerWindow( new Viewer(iconManager,320,320) ); 
		iconManager.start();

		Producer producer = new Producer(producerBuffer,iconBuffer);
		producer.start();

		IconProducerManager ipManager = new IconProducerManager(producerBuffer);		


		//	 ipManager.appendIconProd(new ArrayProducer(getIconArray(),50,10));



		//	ipManager.appendIconProd(new FileProducer("/Users/Barry/Desktop/Eclipse Bilder/yeah.txt"));


		ipManager.appendIconProd(new FileProducer(getFilenameArray(),50, Integer.MAX_VALUE)); //Integer.MAX_value anger att det är unlimited hopp.
	}

	private static String[] getFilenameArray() {
		String[] res = {
				"/Users/Barry/Desktop/Eclipse Bilder/new1.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new2.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new3.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new4.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new5.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new6.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new7.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new8.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new9.jpg",
				"/Users/Barry/Desktop/Eclipse Bilder/new10.jpg"
		};
		return res;
	}

	private static Icon[] getIconArray() {
		Icon[] res = {
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new1.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new2.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new3.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new4.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new5.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new6.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new7.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new8.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new9.jpg"),
				new ImageIcon("/Users/Barry/Desktop/Eclipse Bilder/new10.jpg")
		};
		return res;
	}
}
