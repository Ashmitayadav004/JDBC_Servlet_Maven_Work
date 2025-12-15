package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class deleteDemo {
	public static void main(String[] args) throws Exception {

		String email = "kamal@gmail.com";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jdbc_db?useSSL=false&allowPublicKeyRetrieval=true", "root",
				"sukku@imunni");

		PreparedStatement ps = con.prepareStatement("delete from register where email=?");

		ps.setString(1, email);

		int count = ps.executeUpdate();

		if (count > 0) {
			System.out.println("success");
		} else {
			System.out.println("Fail");
		}
		con.close();
	}
}
