package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jdbc_db?useSSL=false&allowPublicKeyRetrieval=true", "root",
				"sukku@imunni");

		PreparedStatement ps = con.prepareStatement("select * from register");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

//			String name1 = rs.getString("name");
//			System.out.println(name1);

			System.out.println("Name : " + rs.getString("name"));
			System.out.println("Email : " + rs.getString("email"));
			System.out.println("Password: " + rs.getString("password"));
			System.out.println("Gender : " + rs.getString("gender"));
			System.out.println("City: " + rs.getString("city"));
		}

	}

}
