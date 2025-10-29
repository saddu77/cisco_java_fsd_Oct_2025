package javaoops;

class Person{
	int p_id = 101;
	String p_name = "Alex";
	static String p_company = "Cisco";
	
	void getInfo(){
		System.out.println(p_id + " " + p_name + " " + p_company);
	}	
}
public class Sample1 {
	public static void main(String[] args) {
	  //ClassName obj = new ClassName();
		Person pObj = new Person();
		pObj.getInfo();		
	}
}
