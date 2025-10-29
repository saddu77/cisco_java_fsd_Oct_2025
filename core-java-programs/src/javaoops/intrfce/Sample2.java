package javaoops.intrfce;

interface Vehicle{
	void changeGear(int n);
	void speedUp(int speed);
	void applyBrakes(int brk);
}

class Bike implements Vehicle{
	int speed;
	int gear;
	
	@Override
	public void changeGear(int n) {
		// TODO Auto-generated method stub
		gear = n;
	}

	@Override
	public void speedUp(int n) {
		// TODO Auto-generated method stub
		speed = speed + n;
	}

	@Override
	public void applyBrakes(int brk) {
		// TODO Auto-generated method stub
		speed = speed - brk;
	}
	
	void getInfo(){
		System.out.println("Speed : " + speed +"kms/hr at gear: " + gear);
	}
	
}

public class Sample2 {
	public static void main(String[] args) {
		Bike bObj = new Bike();
		bObj.changeGear(1);
		bObj.speedUp(10);
		bObj.applyBrakes(5);
		
		System.out.println("Bike status:");
		bObj.getInfo();
	}
}
