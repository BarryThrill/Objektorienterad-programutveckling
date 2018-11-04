package p2;


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
	
	public FileProducer(String[] filenames, int waits, int Timers) {
		if(filenames!=null) {
			this.waits = waits;
			this.Timers = Timers;
			addIcons(filenames);
		}
	}
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
	
	private void addIcons(String[] filenames) {
		for(String filename : filenames) {
			addIcon(filename);
		}
	}
	
	private void addIcon(String filename) {
		Icon icon = new ImageIcon(filename);
		if(icon!=null) {
			list.add(icon);
		}
	}
	
	public int waits() {
		return waits;
	}

	@Override
	public int Timers() {
		return Timers;
	}

	@Override
	public int size() {
		return list.size();
	}


	@Override
	public Icon followIcon() {
		if(list.size()==0)
			return null;
		streamIcon = (streamIcon+1) % list.size();
		return list.get(streamIcon);
	}
	
}
