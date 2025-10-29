package javaconditions;
import java.util.Scanner;
public class Sample1 {	
	public static void main(String[] args) {
//		int age = 16;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Age: ");
		int age = sc.nextInt();		
		if(age >= 18) {
			System.out.println("Eligible to vote");
		} else {
			System.out.println("Not Eligible to vote");
		}
		sc.close();
	}
}
