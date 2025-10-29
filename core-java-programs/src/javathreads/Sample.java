package javathreads;

public class Sample extends Thread {
	public void run() {
		System.out.println("Thread is running...");
	}
	public static void main(String[] args) {
		Sample tObj = new Sample();
		tObj.start();
	}
}
