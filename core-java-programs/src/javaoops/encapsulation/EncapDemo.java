package javaoops.encapsulation;

public class EncapDemo {
	public static void main(String[] args) {
		Users user1 = new Users();
		user1.setId(101);
		user1.setUsername("alex");
		user1.setPassword("123456");
		
		System.out.println(user1.getId());
		System.out.println(user1.getUsername());
		System.out.println(user1.getPassword());
		System.out.println(user1);
	}
}
