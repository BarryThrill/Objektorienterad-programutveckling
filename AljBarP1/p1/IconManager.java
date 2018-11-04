package p1;

import java.util.Observable;


import javax.swing.Icon;

public class IconManager extends Observable{

	private Buffer<Icon> iconBuffer;
	private Thread thread;
	
	
	/**
	 * 
	 * @param initizierar iconBuffer
	 */
	public IconManager(Buffer<Icon> iconBuffer) {
		this.iconBuffer = iconBuffer;
		
	}
	/**
	 * @param iniziterar server när det startas
	 */
	public void start() {
		if (thread == null) {
			thread = new ThreadHappend();
			thread.start();
		}
	}
	
	/**
	 * 
	 * @param När det startas ska "ThreadHappend" hända. 
	 *
	 */
	private class ThreadHappend extends Thread {
		public void run() {
			while (!Thread.interrupted()) {
				while(iconBuffer!= null){
				try {	
						
						setChanged();
						notifyObservers(iconBuffer.get());
					
					
				}catch (InterruptedException e) {
					System.out.println(e);
					break;
				}
			}
		}
		}
	}
			
}
