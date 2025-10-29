package javaoops.inheritance;
//Base class
class Company{
	String c_name;
	
	//default constructor
	Company(){
		System.out.println("Default constructor executed !!! - Company");
	}
	
	//parameterized constructor
	Company(String c_name){
		this.c_name = c_name;
	}
}

//Derivied class
class Employee extends Company{	
	String emp_name;	
	Employee(){
		System.out.println("Default Employee contsructor !!!");
	}
	Employee(String emp_name,String c_name){
		super(c_name);
		this.emp_name = emp_name;
	}
	void getEmplDetails(){
		System.out.println(emp_name + " " + c_name);
	}
}

public class Sample1 {
	public static void main(String[] args) {
		Employee eObj = new Employee("Alex","IBM");
		Employee eObj1 = new Employee("Bob","Apple");
		Employee eObj2 = new Employee("Clare", "IBM");	

		new Employee();
	
		eObj.getEmplDetails();
		eObj1.getEmplDetails();
		eObj2.getEmplDetails();
	}
}
