package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {
	public static void main(String[] args) throws Exception {

//		String name1="Kamal";
//		String email="kamal@gmail.com";

		//when we asked values from users
		String name1 = "Kamallaaa";
		String email = "kamala@gmail.com";
		String pass = "kam123";
		String gender = "female";
		String city1 = "mumbai";

		Class.forName("com.mysql.cj.jdbc.Driver");
		// System.out.println("Driver class loaded successfully");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "sukku@imunni");
//		System.out.println("database connected successfully");

//		PreparedStatement ps = con.prepareStatement(
//				"insert into register values('deepika','deep@gmail.com','deepak123','female','chandigarh')");

//		PreparedStatement ps = con.prepareStatement(
//				"insert into register values('"+name1+"','"+email+"','kamal123','male','chandigarh')");

		PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, name1);
		ps.setString(2, email);
		ps.setString(3, pass);
		ps.setString(4, gender);
		ps.setString(5, city1);

		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
		ps.close();
		con.close();
	}
}
