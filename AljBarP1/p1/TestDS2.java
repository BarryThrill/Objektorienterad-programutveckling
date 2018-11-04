package p1;

import javax.swing.Icon;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class TestDS2 {
	private Buffer<Icon> buffer;
	private Thread thread;
	
	public TestDS2(Buffer<Icon> buffer) {
		this.buffer = buffer;
	}
	
	public void start() {
		if(thread==null) {
			thread = new Worker();
			thread.start();
		}
	}
	
	

	private class Worker extends Thread {
		public void run() {
			Icon icon;
			while(!Thread.interrupted()) {
				try {
					icon = buffer.get();
					System.out.println(icon.toString());
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
}
