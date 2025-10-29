package javathreads;

class Counter{
	private int count = 0;
	synchronized void inc(){
		count++;
	}
	
	synchronized int getCount() {
		return count;
	}
}
public class Sample2 {
	public static void main(String[] args) {
		Counter cObj = new Counter();
		Thread t1 = new Thread(()->{
			for(int i=0;i < 1000;i++) {
				cObj.inc();
			}
		});
		Thread t2 = new Thread(()->{
			for(int i=0;i < 1000;i++) {
				cObj.inc();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Counter: " + cObj.getCount());
	}
}
