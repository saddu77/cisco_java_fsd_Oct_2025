package javaoops.abstraction;

abstract class Employee {
	int emp_id=101;
	String emp_name="Alex";
	String emp_sal;
	
	abstract void calculate_Salary();
	
	void getEmpDetails() {
		System.out.println(emp_id + " " + emp_name);
	}
}
public class Sample1 extends Employee{

	@Override
	void calculate_Salary() {
		// TODO Auto-generated method stub
		double basic_sal = 77000;
		double bonus = 10000;
		double total_sal = basic_sal  + bonus;
		System.out.println("Salary is: " + total_sal);
	}

	public static void main(String[] args) {
		Sample1 obj = new Sample1();
		obj.getEmpDetails();
		obj.calculate_Salary();		
	}
}
