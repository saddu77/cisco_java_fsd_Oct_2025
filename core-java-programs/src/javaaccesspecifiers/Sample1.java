package javaaccesspecifiers;

public class Sample1 {
	
	public static int number = 200;
	private static String pwd = "123456";	
	protected static String email = "alex@gmail.com";
	static int age = 21;
	
	public static void main(String[] args) {
		System.out.println("Number is : " + number);
		System.out.println("Password is: " + pwd);
		System.out.println("Email is: " + email);
		System.out.println("Age is: " + age);
	}
}
