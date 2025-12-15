package in.ac.adit;

// Your import statements...

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FetchRecord {

	public static void main(String[] args) {
		
		final String URL = "jdbc:mysql://localhost:3306/jdbc_db?useSSL=false";
		final String USERNAME = "root";
		final String PASSWORD = "sukku@imunni";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement pstm = con.prepareStatement("INSERT INTO student_tbl(id, name) VALUES (?, ?)");

			BufferedReader bis = new BufferedReader(
					new FileReader("C:\\Users\\anshu\\OneDrive\\Documents\\MOCK_DATA.csv"));
			
			String data;
			
			bis.readLine();
			
			while ((data = bis.readLine()) != null) {
				
				String[] msg = data.split(",");
				pstm.setInt(1, Integer.parseInt(msg[0].trim())); // ID
				pstm.setString(2, msg[1].trim()); // Name
				pstm.addBatch();
			}
			
			pstm.executeBatch(); // execute all insertions
			System.out.println("Data inserted successfully.");
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
