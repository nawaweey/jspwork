package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/config.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

String mysql_host = "localhost";
String mysql_username = "root";
String mysql_password = "";
String mysql_db = "jsp_final";

      out.write('\n');

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<style>\n");
      out.write("  .bk{\n");
      out.write("    background-image: url(assets/img/rr.jpg);\n");
      out.write("    background-size: 100%;\n");
      out.write("  }\n");
      out.write("  img {\n");
      out.write("    width: 50%;\n");
      out.write("    height: 50%;\n");
      out.write("  }\n");
      out.write("  body{\n");
      out.write("  margin: 0;\n");
      out.write("  padding: 0;\n");
      out.write("  font-family: sans-serif;\n");
      out.write("  background: #34495e;\n");
      out.write("}\n");
      out.write(".box{\n");
      out.write("  width: 300px;\n");
      out.write("  padding: 40px;\n");
      out.write("  position: absolute;\n");
      out.write("  top: 50%;\n");
      out.write("  left: 50%;\n");
      out.write("  transform: translate(-50%,-50%);\n");
      out.write("  background: -webkit-gradient(linear, 50.00% 0.00%, 50.00% 100.00%, color-stop( 0% , rgba(17,117,189,1.00)),color-stop( 100% , rgba(255,255,255,1.00)));\n");
      out.write("  background: -webkit-linear-gradient(270deg,rgba(17,117,189,1.00) 0%,rgba(255,255,255,1.00) 100%);\n");
      out.write("  background: linear-gradient(180deg,rgba(17,117,189,1.00) 0%,rgba(255,255,255,1.00) 100%);\n");
      out.write("  text-align: center;\n");
      out.write("}\n");
      out.write(".box h1{\n");
      out.write("  color: white;\n");
      out.write("  text-transform: uppercase;\n");
      out.write("  font-weight: 500;\n");
      out.write("}\n");
      out.write(".box input[type = \"text\"],.box input[type = \"password\"]{\n");
      out.write("  border:0;\n");
      out.write("  background: none;\n");
      out.write("  display: block;\n");
      out.write("  margin: 20px auto;\n");
      out.write("  text-align: center;\n");
      out.write("  border: 2px solid #3498db;\n");
      out.write("  padding: 14px 10px;\n");
      out.write("  width: 200px;\n");
      out.write("  outline: none;\n");
      out.write("  color: white;\n");
      out.write("  border-radius: 24px;\n");
      out.write("  transition: 0.25s;\n");
      out.write("}\n");
      out.write(".box input[type = \"text\"]:focus,.box input[type = \"password\"]:focus{\n");
      out.write("  width: 280px;\n");
      out.write("  border-color: #2ecc71;\n");
      out.write("}\n");
      out.write(".box input[type = \"submit\"]{\n");
      out.write("  border:0;\n");
      out.write("  background: none;\n");
      out.write("  display: block;\n");
      out.write("  margin: 20px auto;\n");
      out.write("  text-align: center;\n");
      out.write("  border: 2px solid #2ecc71;\n");
      out.write("  padding: 14px 40px;\n");
      out.write("  outline: none;\n");
      out.write("  color: white;\n");
      out.write("  border-radius: 24px;\n");
      out.write("  transition: 0.25s;\n");
      out.write("  cursor: pointer;\n");
      out.write("}\n");
      out.write(".box input[type = \"submit\"]:hover{\n");
      out.write("  background: #2ecc71;\n");
      out.write("}\n");
      out.write(".tt{\n");
      out.write("  color: rgb(131, 130, 130);\n");
      out.write("}\n");
      out.write(".tr{\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body class=\"bk\">\n");
      out.write("<form class=\"box\" action=\"login.jsp\" method=\"post\">\n");
      out.write("  <div class=\"imgcontainer\">\n");
      out.write("    <img src=\"img/avatar.png\" alt=\"Avatar\" class=\"avatar\">\n");
      out.write("  </div>\n");
      out.write("  <h1 align=\"center\">ยินดีต้อนรับ</h1>\n");
      out.write("<p class=\"tr\" align=\"center\"><b>โปรดลงชื่อเข้าใช้ เพื่อดำเนินการต่อ</b></p>\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <label class=\"tt\" for=\"uname\"><b></b></label>\n");
      out.write("    <input type=\"text\" placeholder=\"ชื่อผู้ใช้\" name=\"username\" id=\"username\" value=\"");
 if (username != null) { out.print(username); } 
      out.write("\" required ");
 if (request.getParameter("registered") == null) { out.print("autofocus"); } 
      out.write(">\n");
      out.write("\n");
      out.write("    <label class=\"tt\" for=\"psw\"><b></b></label>\n");
      out.write("    <input type=\"password\" placeholder=\"รหัสผ่าน\" name=\"password\" id=\"password\" required ");
 if (request.getParameter("registered") != null) { out.print("autofocus"); } 
      out.write(">\n");
      out.write("        \n");
      out.write("    <input type=\"submit\" name=\"\" value=\"เข้าสู่ระบบ\">\n");
      out.write("    <p class=\"tt\">ไม่มีบัญชีผู้ใช้? <a href=\"register.jsp\">สมัครผู้ใช้ใหม่</a></p>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
