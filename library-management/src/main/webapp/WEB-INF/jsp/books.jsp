<%@ page import="java.util.*,com.library.model.Book" %>
<html>
<head><title>Books</title></head>
<body>
<h2>Books List</h2>
<table border="1">
<tr><th>ID</th><th>Title</th><th>Author</th><th>Available</th></tr>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
    if(books != null){
        for(Book b : books){
%>
<tr>
    <td><%= b.getId() %></td>
    <td><%= b.getTitle() %></td>
    <td><%= b.getAuthor() %></td>
    <td><%= b.isAvailable() ? "Yes" : "No" %></td>
</tr>
<%
        }
    }
%>
</table>
</body>
</html>
