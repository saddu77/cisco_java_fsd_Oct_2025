package javaexceptions;

public class Sample3 {
	public static void main(String[] args) {
		
		int[] numbers = {10,20,30,40,50};
		System.out.println("Start...");
		try {
			System.out.println(numbers[3]);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			System.out.println("finally block executed..");
		}		
		System.out.println("End...");
	}
}
