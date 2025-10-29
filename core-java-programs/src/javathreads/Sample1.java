package javathreads;

public class Sample1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread is running...");
	}
	
	public static void main(String[] args) {
		Sample1 obj = new Sample1();
		Thread tObj = new Thread(obj);
		tObj.start();
		
	}

	
}
