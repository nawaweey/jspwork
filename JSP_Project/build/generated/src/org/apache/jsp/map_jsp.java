package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class map_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/process_login.jsp");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!-- \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");

String mysql_host = "localhost";
String mysql_username = "root";
String mysql_password = "";
String mysql_db = "jsp_final";

      out.write('\n');

Object user_id = session.getAttribute("user_id");
if (user_id == null) {
	response.sendRedirect("login.jsp");
}
Connection connect = null;
Statement statement = null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	connect =  DriverManager.getConnection("jdbc:mysql://" + mysql_host + "/" + mysql_db + "" +"?user=" + mysql_username + "&password=" + mysql_password);
	statement = connect.createStatement();
	ResultSet user_data = statement.executeQuery("SELECT * FROM `users` WHERE `id` = '" + user_id.toString() + "';");
	if (!user_data.next()) {
		session.removeAttribute("user_id");
		response.sendRedirect("login.jsp");
	}
}  catch (Exception e) {
	out.println(e.getMessage());
	e.printStackTrace();
}
try {
	if (statement != null){
		statement.close();
		connect.close();
	}
} catch (SQLException e) {
}

      out.write(" -->\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>แผนที่</title>\n");
      out.write("\t<link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"assets/css/offcanvas.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"assets/css/style.css\" rel=\"stylesheet\">\n");
      out.write("\t<script defer src=\"assets/js/all.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\t<main role=\"main\" class=\"container\">\n");
      out.write("\t\t<h2 class=\"pt-1 pb-2\"><i class=\"fas fa-map-marked-alt\"></i>&nbsp; วิทยาลัยการอาชีพปัตตานี</h2>\n");
      out.write("\t\t<div class=\"bg-white rounded shadow map-container\" style=\"height: 550px\">\n");
      out.write("\t\t\t<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3961.2026723153367!2d101.24047231540527!3d6.866299995038143!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31b30405a304a121%3A0x7b7a2c64604e80ef!2z4Lin4Li04LiX4Lii4Liy4Lil4Lix4Lii4LiB4Liy4Lij4Lit4Liy4LiK4Li14Lie4Lib4Lix4LiV4LiV4Liy4LiZ4Li1!5e0!3m2!1sth!2sth!4v1568300327456!5m2!1sth!2sth\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>\n");
      out.write("\t\t</div>\n");
      out.write("\t</main>\n");
      out.write("\t<p class=\"mt-4 small text-muted text-center\">&copy; 2019 Likecyber</p>\n");
      out.write("\t<script defer src=\"assets/js/jquery-3.4.1.min.js\"></script>\n");
      out.write("\t<script defer src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
