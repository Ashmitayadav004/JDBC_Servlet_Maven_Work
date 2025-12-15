package in.ac.adit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/bank_db";
		String user = "root";
		String password = "sukku@imunni";

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);

			String insertSql1 = "Insert into accounts(id,name,balance) values(?,?,?)";
			String updateSql1 = "Update accounts set balance=balance-? where id=?";

			PreparedStatement insertps1 = con.prepareStatement(insertSql1);
			PreparedStatement updateps1 = con.prepareStatement(updateSql1);

			insertps1.setInt(1, 5);
			insertps1.setString(2, "Hari");
			insertps1.setDouble(3, 3000.0);
			insertps1.executeUpdate();

			updateps1.setDouble(1, 2300);
			updateps1.setInt(2, 1);
			updateps1.executeUpdate();
			con.commit();
			System.out.println("Transaction committed successfully.");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			if (con != null) {
				con.rollback();
				System.out.println("Transaction rolled back due to error: " + e.getMessage());
			}
			e.printStackTrace();
		}

	}

}
