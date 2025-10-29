package javaoops.polymorphism;

class Vehicle{
	int speed = 60;
	void getSpeed() {
		System.out.println("Vehicle is running at speed "  + speed + " kms/hr");
	}
}

class Bike extends Vehicle{	
	int speed = 80;
	void getSpeed() {
		System.out.println("Bike is running at speed "  + speed + " kms/hr");
	}
}
public class Sample3 {
	public static void main(String[] args) {
		Bike obj = new Bike();
		obj.getSpeed();
	}
}
