package p1;

import javax.swing.Icon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class Producer {
	
	private Buffer<IconProducer> producerBuffer;
	private Buffer<Icon> iconBuffer;
	private Thread thread;

	public Producer(Buffer<IconProducer> producerBuffer, Buffer<Icon> iconBuffer) {
		this.producerBuffer = producerBuffer;
		this.iconBuffer = iconBuffer;
		
	}
		
	public void start() {
		if (thread == null) {
			thread = new ThreadHappend();
			thread.start();
		}
	}
	private class ThreadHappend extends Thread {
		public void run() {
			while (!Thread.interrupted()) {
				try {
					
					IconProducer producer = producerBuffer.get();
					for(int Timerss = 0; Timerss < producer.Timers(); Timerss++){
						for (int i = 0; i < producer.size(); i++){
							iconBuffer.put(producer.followIcon());
							Thread.sleep(producer.waits());
						}
					}
				} catch (InterruptedException e) {
					System.out.println(e);
					break;
				}
			}
		}
	}
}


