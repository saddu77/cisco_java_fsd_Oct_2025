package javaoops.inheritance;

class A{
	int x = 20;
}

class B extends A{
	int y = 30;
}

class C extends B{
	int z = 40;
	int res;
	void sum() {
		res = x + y + z;
		System.out.println("Res is: " + res);
	}
}
public class Sample2 {
	public static void main(String[] args) {
		C obj = new C();
		obj.sum();
	}
}
