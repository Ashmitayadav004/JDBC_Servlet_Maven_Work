<%@ page import="java.util.*,com.library.model.IssueLog" %>
<html>
<head><title>Issue Logs</title></head>
<body>
<h2>All Issue Logs</h2>
<table border="1">
<tr><th>ID</th><th>Book ID</th><th>User ID</th><th>Issue Date</th><th>Return Date</th><th>Penalty</th></tr>
<%
    List<IssueLog> logs = (List<IssueLog>) request.getAttribute("logs");
    if(logs != null){
        for(IssueLog l : logs){
%>
<tr>
    <td><%= l.getId() %></td>
    <td><%= l.getBookId() %></td>
    <td><%= l.getUserId() %></td>
    <td><%= l.getIssueDate() %></td>
    <td><%= l.getReturnDate() != null ? l.getReturnDate() : "" %></td>
    <td><%= l.getPenalty() %></td>
</tr>
<%
        }
    }
%>
</table>
</body>
</html>
