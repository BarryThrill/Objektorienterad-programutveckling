
package p1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */
public class FileProducer implements IconProducer {
	private ArrayList<Icon> list = new ArrayList<Icon>();
	private int waits=0;
	private int Timers=0;
	private int streamIcon = -1;

	/**
	 * 
	 * @param filnamn String - matris f�r det tredje alternativet i huvudsakliga metoden
	 * @param f�rdr�jnings h�ller reda p� den aktuella f�rdr�jningen
	 * @param G�nger h�ller koll p� den aktuella tiden
	 * Kallar p� methoden addIcond() med parametrar filnamn
	 * 
	 */
	public FileProducer(String[] filenames, int waits, int Timers) {
		if(filenames!=null) {
			this.waits = waits;
			this.Timers = Timers;
			addIcons(filenames);
		}
	}

	/**
	 * 
	 * @param filnamn kommer in via parentes
	 * Skapar en BufferedReader att l�sa filnamn - array
	 * Skapar en variabel att l�sa BufferedReader
	 * Tolkar heltal g�nger och f�rseningar till r�rlig linje och l�ser f�r x g�nger / x f�rdr�jning .
	 * N�r linje inte �r tom , l�sa BufferedReader & String Array ( addIcon ( linje ) metoden )
	 * F�ngster IOExceptions och skriver ut dem .
	 */
	public FileProducer(String filename){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String line = br.readLine();
			this.Timers = Integer.parseInt(line);
			line = br.readLine();
			this.waits = Integer.parseInt(line);
			line = br.readLine();
			while(line != null){
				addIcon(line);
				line = br.readLine();

			}
		}catch (IOException e){
			System.out.println(e);
		}	
	}
	/**
	 * 
	 * @param filnamn String - matris
	 * Startar en ikon objekt med parametern filnamn .
	 * Om ikonen inte �r tom , till ikonen till listan .
	 */
	private void addIcon(String filename) {
		Icon icon = new ImageIcon(filename);
		if(icon!=null) {
			list.add(icon);
		}
	}

	/**
	 * 
	 * @param ilnamn String - matris
	 * Enchanced for- slinga f�r att g� igenom String - 
	 * array filnamn och lagrar den i filnamn
	 */
	private void addIcons(String[] filenames) {
		for(String filename : filenames) {
			addIcon(filename);
		}
	}


	/** 
	 * returnerar waits.
	 */
	public int waits() {
		return waits;
	}
	/**
	 * returnerar Timers.
	 */

	public int Timers() {
		return Timers;
	}
	/**
	 * returnerar size.
	 */

	public int size() {
		return list.size();
	}

	/**
	 * Identisk med nextIcon ( ) metoden i ArrayProducer
	 * Ger inget om de �r tomma
	 * G�r igenom listan och skickar en ikon objekt f�r varje index fram till slutet av listan , �terv�nder sedan listan .
	 */

	public Icon followIcon() {
		if(list.size()==0)
			return null;
		streamIcon = (streamIcon+1) % list.size();
		return list.get(streamIcon);
	}

}
