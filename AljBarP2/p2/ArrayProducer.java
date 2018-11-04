package p2;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * 
 * @author Barry Al-Jawari
 *
 *	OBS. Samma javadoc finns på p1.
 */


public class ArrayProducer implements IconProducer {
	
	private ArrayList<Icon> list = new ArrayList<Icon>();
	private int waits = 0;
	private int Timers = 0;
	private Icon[] image;
	private int streamIcon = -1;
	
	public ArrayProducer(Icon[] image, int waits, int Timers){
		this.waits = waits;
		this.Timers = Timers;
		this.image = image;
		appendIcon();
	}
	
	
	private void appendIcon() {
		for(int i = 0; i<image.length;i ++){
			list.add(image[i]);
		}
	}

	public Icon followIcon() {
		if(list.size()==0)
			return null;
		streamIcon = (streamIcon+1) % list.size();
		return list.get(streamIcon);
	
	}
	public int waits() {
	
		return waits;
	}


	public int Timers() {
		
		return Timers;
	}

	
	public int size() {
		
		return list.size();
	}

	
}
