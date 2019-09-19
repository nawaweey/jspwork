<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ include file="config.jsp" %>
<%
Object user_id = session.getAttribute("user_id");
if (user_id != null) {
	response.sendRedirect("home.jsp");
}
String username = null;
if (request.getParameter("register") != null) {
	username = request.getParameter("register");
}
if (request.getParameter("username") != null) {
	username = request.getParameter("username");
}
Connection connect = null;
Statement statement = null;
String error_text = null;
if ("POST".equalsIgnoreCase(request.getMethod())) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connect =  DriverManager.getConnection("jdbc:mysql://" + mysql_host + "/" + mysql_db + "" +"?user=" + mysql_username + "&password=" + mysql_password);
		statement = connect.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM `users` WHERE `username` = '" + request.getParameter("username") + "' AND `password` = '" + request.getParameter("password") + "';");
		if (result.next()) {
			session.setAttribute("user_id", result.getString("id"));
			if (request.getParameter("remember_me") != null) {
				session.setMaxInactiveInterval(86400);
			} else {
				session.setMaxInactiveInterval(900);
			}
			response.sendRedirect("home.jsp");
		} else {
			error_text = "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง";
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
<form class="box" action="login.jsp" method="post">
  <div class="imgcontainer">
    <img src="img/avatar.png" alt="Avatar" class="avatar">
  </div>
  <h1 align="center">ยินดีต้อนรับ</h1>
<p class="tr" align="center"><b>โปรดลงชื่อเข้าใช้ เพื่อดำเนินการต่อ</b></p>
  <div class="container">
    <label class="tt" for="uname"><b></b></label>
    <input type="text" placeholder="ชื่อผู้ใช้" name="username" id="username" value="<% if (username != null) { out.print(username); } %>" required <% if (request.getParameter("registered") == null) { out.print("autofocus"); } %>>

    <label class="tt" for="psw"><b></b></label>
    <input type="password" placeholder="รหัสผ่าน" name="password" id="password" required <% if (request.getParameter("registered") != null) { out.print("autofocus"); } %>>
        
    <input type="submit" name="" value="เข้าสู่ระบบ">
    <p class="tt">ไม่มีบัญชีผู้ใช้? <a href="register.jsp">สมัครผู้ใช้ใหม่</a></p>

</form>

</body>
</html>
