package javaexceptions;

class InvalidAgeException extends Exception{
	InvalidAgeException(String msg){
		super(msg);
	}
}
public class Sample6 {
	static void validateAge(int age) throws InvalidAgeException{
		if (age < 18) {
			throw new InvalidAgeException("Age must be 18 or above..");
		}
		System.out.println("Valid Age: " + age);
	}
	public static void main(String[] args) {
		try {
			validateAge(17);
		}catch(InvalidAgeException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
