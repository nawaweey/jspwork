package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<style>\n");
      out.write("body {\n");
      out.write("  font-family: Arial, Helvetica, sans-serif;\n");
      out.write("  background-color: rgb(0, 0, 0);\n");
      out.write("}\n");
      out.write("\n");
      out.write("* {\n");
      out.write("  box-sizing: border-box;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Add padding to containers */\n");
      out.write(".container {\n");
      out.write("  padding: 16px;\n");
      out.write("  background-color: #FFD700;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Full-width input fields */\n");
      out.write("input[type=text], input[type=password] {\n");
      out.write("  width: 100%;\n");
      out.write("  padding: 15px;\n");
      out.write("  margin: 5px 0 22px 0;\n");
      out.write("  display: inline-block;\n");
      out.write("  border: 1px solid #FFA07A;\n");
      out.write("  background: #f1f1f1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=text]:focus, input[type=password]:focus {\n");
      out.write("  background-color: #ddd;\n");
      out.write("  outline: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Overwrite default styles of hr */\n");
      out.write("hr {\n");
      out.write("  border: 1px solid #f1f1f1;\n");
      out.write("  margin-bottom: 25px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Set a style for the submit button */\n");
      out.write(".registerbtn {\n");
      out.write("  background-color: rgb(168, 113, 9);\n");
      out.write("  color: white;\n");
      out.write("  padding: 16px 20px;\n");
      out.write("  margin: 8px 0;\n");
      out.write("  border: 1px solid #FFA07A;\n");
      out.write("  cursor: pointer;\n");
      out.write("  width: 50%;\n");
      out.write("  opacity: 0.9;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".registerbtn:hover {\n");
      out.write("  opacity: 1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Add a blue text color to links */\n");
      out.write("a {\n");
      out.write("  color: dodgerblue;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Set a grey background color and center the text of the \"sign in\" section */\n");
      out.write(".signin {\n");
      out.write("  background-color: #f1f1f1;\n");
      out.write("  text-align: center;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form action=\"register.jsp\" method=\"post\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <h1>สมัครผู้ใช้ใหม่</h1>\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("    <label for=\"email\"><b>ชื่อผู้ใช้</b></label>\n");
      out.write("    <input type=\"text\" placeholder=\"ชื่อผู้ใช้\" name=\"username\" value=\"");
 if (request.getParameter("username") != null) { out.print(request.getParameter("username")); } 
      out.write("\" required autofobus>\n");
      out.write("\n");
      out.write("    <label for=\"email\"><b>อีเมล</b></label>\n");
      out.write("    <input type=\"text\" placeholder=\"อีเมล\" name=\"email\" value=\"");
 if (request.getParameter("email") != null) { out.print(request.getParameter("email")); } 
      out.write("\" required>\n");
      out.write("\n");
      out.write("    <label for=\"email\"><b>ชื่อ-นามสกุล</b></label>\n");
      out.write("    <input type=\"text\" placeholder=\"ชื่อ-นามสกุล\" name=\"name\" value=\"");
 if (request.getParameter("name") != null) { out.print(request.getParameter("name")); } 
      out.write("\" required>\n");
      out.write("\n");
      out.write("    <label for=\"password\"><b>รหัสผ่าน</b></label>\n");
      out.write("    <input type=\"password\" placeholder=\"รหัสผ่าน\" name=\"password\" required>\n");
      out.write("\n");
      out.write("    <label for=\"password-repeat\"><b>ยืนยันรหัสผ่าน</b></label>\n");
      out.write("    <input type=\"password\" placeholder=\"ยืนยันรหัสผ่าน\" name=\"password\" required>\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("    <button type=\"submit\" class=\"registerbtn\" >สมัครผู้ใช้ใหม่</button>\n");
      out.write("    </div>\n");
      out.write("  \n");
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
