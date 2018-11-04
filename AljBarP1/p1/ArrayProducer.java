
package p1;

import java.util.ArrayList;

import javax.swing.Icon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */
public class ArrayProducer implements IconProducer {

	private ArrayList<Icon> list = new ArrayList<Icon>();
	private int waits = 0;
	private int Timers = 0;
	private Icon[] image;
	private int streamIcon = -1;

	/**
	 * 
	 * @param ikoner hålla reda på aktuella ikoner
	 * @param fördröjningen hålla reda på den aktuella förseningen
	 * @param tider hålla reda på den aktuella tiden
	 * Kallar även på metoden appendIcon()
	 */
	public ArrayProducer(Icon[] image, int waits, int Timers){
		this.waits = waits;
		this.Timers = Timers;
		this.image = image;
		appendIcon();
	}

	/** 
	 * For-loop för att gå igenom ikonerna - array , tillägger sedan ikoner -index till en lista
	 */
	private void appendIcon() {
		for(int i = 0; i<image.length;i ++){
			list.add(image[i]);
		}
	}
	/**
	 * Returer notera om listan är tom .
	 * Går igenom listan och skickar en ikon objekt för varje index fram till slutet av listan , återvänder sedan listan .
	 */
	public Icon followIcon() {
		if(list.size()==0)
			return null;
		streamIcon = (streamIcon+1) % list.size();
		return list.get(streamIcon);

	}

	/**
	 * Retur storlek (storleken på listan )
	 */
	public int size() {

		return list.size();
	}

	/**
	 * Returer gånger ( hur många gånger bilden ska hoppa )
	 */

	public int Timers() {

		return Timers;
	}


	/**
	 * Returer fördröjning ( hur lång tid mellan varje hopp )
	 */

	public int waits() {

		return waits;
	}

}

