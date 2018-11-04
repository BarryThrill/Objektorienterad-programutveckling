package p1;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class TestDS1 extends Thread {
	private Buffer<IconProducer> buffer;
	
	public TestDS1(Buffer<IconProducer> buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		IconProducer producer;
		while(!Thread.interrupted()) {
			try {
				producer = buffer.get();
				populateProducerToConsole(producer);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	private void populateProducerToConsole(IconProducer producer) throws InterruptedException {
	    for(int times=0; times<producer.Timers(); times++) {
	    	for(int index = 0; index<producer.size(); index++) {
	    		System.out.println(producer.followIcon().toString());
	    		Thread.sleep(producer.waits());
	    	}
	    }
	}
}
