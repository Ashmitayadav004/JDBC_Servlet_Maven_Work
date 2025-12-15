<%@ page import="java.sql.*, in.sp.dbcon.DbConnection" %>
<%@ include file="header.jsp" %>

<%
    
    int totalUsers = 0;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        con = DbConnection.getConnection();

       
        PreparedStatement psCount = con.prepareStatement("SELECT COUNT(*) FROM register");
        ResultSet rsCount = psCount.executeQuery();
        if(rsCount.next()) {
            totalUsers = rsCount.getInt(1);
        }
        rsCount.close();
        psCount.close();

        
        ps = con.prepareStatement("SELECT * FROM register");
        rs = ps.executeQuery();

    } catch(Exception e) {
        e.printStackTrace();
    }
%>

<div class="container mt-5">
    <h2 class="text-center text-primary mb-4">Admin Dashboard</h2>
    <h4>Total Users: <%= totalUsers %></h4>

    <table class="table table-bordered table-striped mt-3">
        <thead class="table-dark">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>City</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <%
            try {
                while(rs.next()) {
        %>
            <tr>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("email") %></td>
                <td><%= rs.getString("password") %></td>
                <td><%= rs.getString("city") %></td>
                <td>
                    <form action="deleteUser" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
                        <input type="hidden" name="email" value="<%= rs.getString("email") %>">
                        <input type="submit" class="btn btn-danger btn-sm" value="Delete">
                    </form>
                </td>
            </tr>
        <%
                }
                rs.close();
                ps.close();
                con.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        %>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>
