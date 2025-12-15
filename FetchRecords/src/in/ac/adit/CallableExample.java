
package in.ac.adit;

import java.sql.*;

public class CallableExample {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/jdbc_db?useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "sukku@imunni";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            
            CallableStatement cstmt = con.prepareCall("{call getStudentName(?, ?)}");

            // Set input parameter (IN studentId)
            cstmt.setInt(1, 101); // You can use Scanner for dynamic input

            // Register output parameter (OUT studentName)
            cstmt.registerOutParameter(2, Types.VARCHAR);

            // Execute the stored procedure
            cstmt.execute();

            // Retrieve and print output
            String name = cstmt.getString(2);
            System.out.println("Student name: " + name);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
