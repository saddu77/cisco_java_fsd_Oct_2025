package javaoops.intrfce;

interface Addition{
	int add(int x,int y);
}

interface Subtraction {
	int sub(int x,int y);
}
class Calculation implements Addition,Subtraction{
	@Override
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x - y;
	}
	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}	
}


public class Sample3 {
	public static void main(String[] args) {
		Calculation obj = new Calculation();
		int res;
		res = obj.add(40, 40);
		System.out.println("Result of sum is : " + res);
		res = obj.sub(40, 20);
		System.out.println("Result of sub is : " + res);
	}
}
