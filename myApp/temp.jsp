<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%@ page import="java.sql.*" %>
    <% Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app","root","1234");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select * from users");
    while(rs.next()){ %>
    <h3><%=rs.getObject(1).toString() %></h3>
    <% } %>
</body>
</html>