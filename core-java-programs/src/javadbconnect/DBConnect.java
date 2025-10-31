package javadbconnect;

import java.sql.*;

public class DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/cisco_db"; // DB URL 
		String uname = "root"; 
		String pwd = "Simplilearn";
		Connection conn = null;
		
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver 
			conn = DriverManager.getConnection(url, uname,pwd); 
			System.out.println("Connected to DB!"); 
			//conn.close(); 
			} catch (Exception e) { 
			e.printStackTrace(); 
			}
//		try {
//			String sql = "INSERT INTO users(username,password) VALUES (?,?)";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "julie");
//			stmt.setString(2, "123456");
//			stmt.executeUpdate();
//			System.out.println("Record Inserted Successfully !!!");
//		}catch(SQLException ex) {
//			ex.printStackTrace();
//		}
		//Select Query
		try {
			String sql = "SELECT * FROM users";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(id + " " + username + " " + password);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		//Update Query
		try {
			String sql = "UPDATE users SET username= ?,password = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "kim");
			stmt.setString(2, "888888");
			stmt.setInt(3, 5);
			stmt.executeUpdate();
			System.out.println("Record Updated Successfully !!!");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
	}

	

}
