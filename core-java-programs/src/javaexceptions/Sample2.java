package javaexceptions;

public class Sample2 {
	public static void main(String[] args) {
		int number = 10;
		String name = null;
		System.out.println("Start...");
		
		try {
			System.out.println(name.length());
			System.out.println(number /0);
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println(e);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		System.out.println("End...");
	}
}
