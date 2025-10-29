package javaexceptions;

public class Sample4 {
	static void validate() {
		try {
			throw new NullPointerException("exception...");
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println(e);
			throw e;
		}
	}
	public static void main(String[] args) {
		try {
			validate();
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Caught in main()...");
		}
	}
}
