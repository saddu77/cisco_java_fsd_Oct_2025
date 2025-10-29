package javaexceptions;

public class Sample5 {
	static void calculate() throws IllegalAccessException{
		System.out.println("Performing calculation...");
		throw new IllegalAccessException("calculate()...");
	}
	public static void main(String[] args) {
		try {
			calculate();
		}catch(IllegalAccessException ex) {
			System.out.println("Caught in main()...");
		}
	}
}
