package javaoops.intrfce;


interface I1{
	void display();	
}

public class Sample1 implements I1{
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Hello from Display method()");
	}
	public static void main(String[] args) {
		Sample1 obj = new Sample1();
		obj.display();
	}	
}
