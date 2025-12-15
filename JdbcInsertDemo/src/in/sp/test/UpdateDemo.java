package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDemo {
	public static void main(String[] args) throws Exception {

		String city = "pune";
		String email = "deep@gmail.com";

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded successfully");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db?useSSL=false&allowPublicKeyRetrieval=true", "root", "sukku@imunni");

		PreparedStatement ps = con.prepareStatement("update register set city=? where email=?");

		ps.setString(1, city);
		ps.setString(2, email);

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("success");
		} else {
			System.out.println("Fail");
		}
		con.close();
	}
}
