
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
	 * @param ikoner h�lla reda p� aktuella ikoner
	 * @param f�rdr�jningen h�lla reda p� den aktuella f�rseningen
	 * @param tider h�lla reda p� den aktuella tiden
	 * Kallar �ven p� metoden appendIcon()
	 */
	public ArrayProducer(Icon[] image, int waits, int Timers){
		this.waits = waits;
		this.Timers = Timers;
		this.image = image;
		appendIcon();
	}

	/** 
	 * For-loop f�r att g� igenom ikonerna - array , till�gger sedan ikoner -index till en lista
	 */
	private void appendIcon() {
		for(int i = 0; i<image.length;i ++){
			list.add(image[i]);
		}
	}
	/**
	 * Returer notera om listan �r tom .
	 * G�r igenom listan och skickar en ikon objekt f�r varje index fram till slutet av listan , �terv�nder sedan listan .
	 */
	public Icon followIcon() {
		if(list.size()==0)
			return null;
		streamIcon = (streamIcon+1) % list.size();
		return list.get(streamIcon);

	}

	/**
	 * Retur storlek (storleken p� listan )
	 */
	public int size() {

		return list.size();
	}

	/**
	 * Returer g�nger ( hur m�nga g�nger bilden ska hoppa )
	 */

	public int Timers() {

		return Timers;
	}


	/**
	 * Returer f�rdr�jning ( hur l�ng tid mellan varje hopp )
	 */

	public int waits() {

		return waits;
	}

}

