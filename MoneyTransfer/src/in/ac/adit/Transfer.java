package in.ac.adit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transfer {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/bank_db?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "sukku@imunni";

		Connection con = null;

		int fromAccount = 1;
		int toAccount = 2;
		double transferAmount = 200;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);

			PreparedStatement selectBalance = con.prepareStatement("Select balance from accounts where id=?");
			selectBalance.setInt(1, fromAccount);
			ResultSet rs = selectBalance.executeQuery();

			if (!rs.next()) {
				throw new SQLException("Sender account not found!");
			}

			double senderBalance = rs.getDouble("balance");
			if (senderBalance < transferAmount) {
				throw new SQLException("Insufficient balance in sender account!");
			}

			PreparedStatement update1 = con.prepareStatement("Update accounts set balance= balance-? where id=?");
			update1.setDouble(1, transferAmount);
			update1.setInt(2, fromAccount);
			update1.executeUpdate();
			System.out.println("Amount deducted from sender.");

			PreparedStatement update2 = con.prepareStatement("Update accounts set balance=balance+? where id=?");
			update2.setDouble(1, transferAmount);
			update2.setInt(2,toAccount);
			update2.executeUpdate();
			System.out.println("Amount added to receiver.");

           
            con.commit();
            System.out.println("Transaction committed successfully.");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (con != null) {
				con.rollback();
				System.out.println("Transaction rolled back due to: " + e.getMessage());
			}
			e.printStackTrace();
		}

	}

}
