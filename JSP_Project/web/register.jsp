<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ include file="config.jsp" %>
<%
Object user_id = session.getAttribute("user_id");
if (user_id != null) {
	response.sendRedirect("login.jsp");
}
Connection connect = null;
Statement statement = null;
String error_text = null;
if ("POST".equalsIgnoreCase(request.getMethod())) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connect =  DriverManager.getConnection("jdbc:mysql://" + mysql_host + "/" + mysql_db + "" +"?user=" + mysql_username + "&password=" + mysql_password);
		statement = connect.createStatement();
		if (!statement.executeQuery("SELECT * FROM `users` WHERE `username` = '" + request.getParameter("username") + "';").next()) {
			if (request.getParameter("password").equals(request.getParameter("confirm_password"))) {
				statement.execute("INSERT INTO `users` (`id`, `username`, `password`, `email`, `name`) VALUES (NULL, '" + request.getParameter("username") + "', '" + request.getParameter("password") + "', '" + request.getParameter("email") + "', '" + request.getParameter("name") + "');");
				response.sendRedirect("login.jsp?registered=" + request.getParameter("username"));
			} else {
				error_text = "รหัสผ่านทั้งสองช่องไม่ตรงกัน";
			}
		} else {
			error_text = "มีชื่อผู้ใช้นี้อยู่ในระบบอยู่แล้ว";
		}
	}  catch (Exception e) {
		error_text = e.getMessage();
	}
	try {
		if (statement != null){
			statement.close();
			connect.close();
		}
	} catch (SQLException e) {
	}
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
  .bk{
    background-image: url(assets/img/rr.jpg);
    background-size: 100%;
  }
  img {
    width: 50%;
    height: 50%;
  }
body{
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background: #34495e;
}
.box{
  width: 300px;
  padding: 40px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background: -webkit-gradient(linear, 50.00% 0.00%, 50.00% 100.00%, color-stop( 0% , rgba(17,117,189,1.00)),color-stop( 100% , rgba(255,255,255,1.00)));
  background: -webkit-linear-gradient(270deg,rgba(17,117,189,1.00) 0%,rgba(255,255,255,1.00) 100%);
  background: linear-gradient(180deg,rgba(17,117,189,1.00) 0%,rgba(255,255,255,1.00) 100%);
  text-align: center;
}
.box h1{
  color: white;
  text-transform: uppercase;
  font-weight: 500;
}
.box input[type = "text"],.box input[type = "password"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
}
.box input[type = "text"]:focus,.box input[type = "password"]:focus{
  width: 280px;
  border-color: #2ecc71;
}
.box input[type = "submit"]{
  border:0;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #2ecc71;
  padding: 14px 40px;
  outline: none;
  color: white;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}
.box input[type = "submit"]:hover{
  background: #2ecc71;
}
.tt{
  color: rgb(131, 130, 130);
}
.tr{
  color: white;
}
</style>
</head>
<body class="bk">

<form action="register.jsp" method="post">
  <div class="box"><br><br><br><br><br>
      <div class="imgcontainer">
          <img src="assets/img/bb.png" alt="Avatar" class="avatar">
      </div>
    <h1>สมัครผู้ใช้ใหม่</h1>
    <label for="username"><b></b></label>
    <input type="text" placeholder="ชื่อผู้ใช้" name="username" value="<% if (request.getParameter("username") != null) { out.print(request.getParameter("username")); } %>" required autofobus>

    <label for="email"><b></b></label>
    <input type="text" placeholder="อีเมล" name="email" value="<% if (request.getParameter("email") != null) { out.print(request.getParameter("email")); } %>" required>

    <label for="name"><b></b></label>
    <input type="text" placeholder="ชื่อ-นามสกุล" name="name" value="<% if (request.getParameter("name") != null) { out.print(request.getParameter("name")); } %>" required>

    <label for="password"><b></b></label>
    <input type="password" placeholder="รหัสผ่าน" name="password" required>

    <label for="confirm_password"><b></b></label>
    <input type="password" placeholder="ยืนยันรหัสผ่าน" name="confirm_password" required>
    <hr>

    <input type="submit" name="" value="สมัครผู้ใช้ใหม่">
    </div>
  
</form>

</body>
</html>
