package javaoops.polymorphism;

class Calculation{
	int res;
	
	void addition(int x,int y) {
		res = x + y;
		System.out.println("Result is: " + res);
	}
	
	void addition(int x,int y, int z) {
		res = x + y + z;
		System.out.println("Result is: " + res);
	}
}

public class Sample1 {
	public static void main(String[] args) {
		Calculation obj = new Calculation();
		obj.addition(10, 20, 30);
		obj.addition(20, 20);
	}
}
