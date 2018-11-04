package p1;

import java.util.ArrayList;

import javax.swing.Icon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */
public class IconProducerManager implements IconProducer{
	
	private Buffer<IconProducer> producerBuffer;
	private ArrayList<Icon> list = new ArrayList<Icon>();
	private int Timers =0;
	private int waits =0;
	private int streamIcon =-1;

	
	/**
	 * 
	 * @param inizitzerar producerBuffer
	 */
	public IconProducerManager(Buffer<IconProducer> producerBuffer) {
		this.producerBuffer = producerBuffer;
		
	}
	
	/**
	 * 
	 * @param inizitzerar iconProducer
	 */
	public void appendIconProd(IconProducer iconProducer) {
		producerBuffer.put(iconProducer);
		
	}

	
	/**
	 * @return returnerar waits
	 */
	public int waits() {
		return waits;
	}
	/**
	 * @return retunerar Timers
	 */
	public int Timers() {
		return Timers;
	}

	/**
	 * @return reutrnerar size
	 */
	public int size() {
		return list.size();
	}

	/**
	 * @param iniziterar nextIcon()
	 */
	public Icon nextIcon() {
		if(list.size()==0)
			return null;
		streamIcon = (streamIcon+1) % list.size();
		return list.get(streamIcon);
	
	}

	@Override
	public Icon followIcon() {
		return null;
	}
}
