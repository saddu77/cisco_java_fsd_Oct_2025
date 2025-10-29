package javathreads;

class Task{
	void printNumbers() {
		try {
			for(int i = 5; i >0; i--) {
				System.out.println("Counter --- " + i);
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
}

class MyThread extends Thread{
	private Thread t;
	private String tName;
	Task task;
	
	MyThread(String name,Task t){
		tName = name;
		task = t;
	}
	
	public void run() {
		synchronized (task) {
			task.printNumbers();
		}
		
		System.out.println("Thread : " + tName +" exiting...");
	}
	
	public void start() {
		System.out.println("Starting : " + tName);
		t = new Thread(this,tName);
		t.start();
	}
	
}
public class Sample3 {
	public static void main(String[] args) {
		
		Task task = new Task();
		MyThread  t1 = new MyThread("Thread-1", task);
		MyThread  t2 = new MyThread("Thread-2", task);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
