package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jsp1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <form method=\"POST\" action=\"Servlet\">\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Inscription</legend>\n");
      out.write("                <p>Vous pouvez vous inscrire via ce formulaire.</p>\n");
      out.write("                <label for=\"Id\">Id  </label>\n");
      out.write("                <input type=\"text\" id=\"Id\" name=\"Id\" value=\"\" size=\"20\" maxlength=\"60\" />\n");
      out.write("                <br />                 \n");
      out.write("                <br />\n");
      out.write("                <label for=\"Nom\">Nom </label>\n");
      out.write("                <input type=\"text\" id=\"Nom\" name=\"Nom\" value=\"\" size=\"20\" maxlength=\"20\" />\n");
      out.write("                <br />               \n");
      out.write("                <br />\n");
      out.write("                <label for=\"Prenom\">Prenom </label>\n");
      out.write("                <input type=\"text\" id=\"Prenom\" name=\"Prenom\" value=\"\" size=\"20\" maxlength=\"20\" />\n");
      out.write("                <br />                \n");
      out.write("                <br />\n");
      out.write("                <label for=\"note\">note </label>\n");
      out.write("                <input type=\"text\" id=\"note\" name=\"note\" value=\"\" size=\"20\" maxlength=\"20\" />\n");
      out.write("                <br />                \n");
      out.write("                <br />\n");
      out.write("                 <input type=\"submit\" value=\"Ajouté\" class=\"sansLabel\" />\n");
      out.write("                <br />\n");
      out.write("    </body>\n");
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
