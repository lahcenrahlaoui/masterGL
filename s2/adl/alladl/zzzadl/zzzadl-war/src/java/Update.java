/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import demo.Std;
import demo.StdFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */

@WebServlet(urlPatterns = {"/Update"})

public class Update extends HttpServlet {

    @EJB
    private StdFacadeLocal stdFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException, ClassNotFoundException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet2</title>");     
                
                   
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n"
                    +   "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" 
            );
            out.println("<style> body{margin-top:20px;color: #1a202c;text-align: left;background-color: #e2e8f0;    }.main-body {padding: 15px;}.card {box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);}.card {position: relative;display: flex;flex-direction: column;min-width: 0;word-wrap: break-word;background-color: #fff;background-clip: border-box;border: 0 solid rgba(0,0,0,.125);border-radius: .25rem;}.card-body{flex: 1 1 auto;min-height: 1px;padding: 1rem;}.gutters-sm {margin-right: -8px;margin-left: -8px;}.gutters-sm>.col, .gutters-sm>[class*=col-] {padding-right: 8px;padding-left: 8px;}.mb-3, .my-3 {margin-bottom: 1rem!important;}.bg-gray-300 {background-color: #e2e8f0;}.h-100 {height: 100%!important;}.shadow-none {box-shadow: none!important;}"      
                    +".login-form{width:340px;margin:50pxauto;font-size:15px;}.login-formform{margin-bottom:15px;background:#f7f7f7;box-shadow:0px2px2pxrgba(0,0,0,0.3);padding:30px;}.login-formh2{margin:0015px;}.form-control,.btn{min-height:38px;border-radius:2px;}.btn{font-size:15px;font-weight:bold;}.parent{display:grid;grid-template-columns:50% 50% }"
                    +   ".login-form {\n" +
                        "    width: 340px;\n" +
                        "    margin: 50px auto;\n" +
                        "  	font-size: 15px;\n" +
                        "}\n" +
                        ".login-form form {\n" +
                        "    margin-bottom: 15px;\n" +
                        "    background: #f7f7f7;\n" +
                        "    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\n" +
                        "    padding: 30px;\n" +
                        "}\n" +
                        ".login-form h2 {\n" +
                        "    margin: 0 0 15px;\n" +
                        "}\n" +
                        ".form-control, .btn {\n" +
                        "    min-height: 38px;\n" +
                        "    border-radius: 2px;\n" +
                        "}\n" +
                        ".btn {        \n" +
                        "    font-size: 15px;\n" +
                        "    font-weight: bold;\n" +
                        "}\n" +
                        "\n" +
                        ".clearfix{\n" +
                        "    display: flex;\n" +
                        "    justify-content: center;\n" +
                        "    align-items: center;\n" +
                        "}\n" +
                        ".radio-class{\n" +
                        "    margin: 10px;\n" +
                        "} </style>"
                    );
            
            
            
                out.println("</head>");
                out.println("<body>");
                
                    out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
                    String id = request.getParameter("id");
                    String firstName   = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    String average = request.getParameter("average");

                    
                    
                    
                    Integer idIntger = (Integer.parseInt(id)); 

                    Std student = new Std();
                    student = stdFacade.find(idIntger);
                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    student.setAverage(Float.parseFloat(average));
                    
                       String degree = request.getParameter("degree");
            String year = request.getParameter("year");

                student.setDegree(degree);
            student.setYear(year);
          
                    
                    
                    stdFacade.edit(student);

                
    out.println("<div class=\"login-form\">\n" +
                "      <form action=\"/examples/actions/confirmation.php\" method=\"post\">" +
                "        <h6 class=\"text-center\">You have Updated a persone</h6>       \n" +
                "        <div class=\"form-group parent\">\n" +
                "            <div class=\"item\">ID</div><div class=\"item\">"+id+"</div>\n" +
                "        </div>\n" +
                "      \n" +
                "         <div class=\"form-group parent\">\n" +
                "            <div class=\"item\">First Name : </div><div class=\"item\">"+student.getFirstName()+"</div>\n" +
                "        </div>\n" +
                "       <div class=\"form-group parent\">\n" +
                "             <div class=\"item\">Last Name : </div><div class=\"item\">"+student.getLastName()+"</div>\n" +
                "        </div>\n" +
                "       <div class=\"form-group parent\">\n" +
                "             <div class=\"item\">Average : </div><div class=\"item\">"+student.getAverage()+"</div>\n" +
                "        </div>\n" +
                "       <div class=\"form-group parent\">\n" +
                "             <div class=\"item\">Degree : </div><div class=\"item\">"+student.getDegree()+"</div>\n" +
                "        </div>\n" +
                "       <div class=\"form-group parent\">\n" +
                "             <div class=\"item\">Year : </div><div class=\"item\">"+student.getYear()+"</div>\n" +
                "        </div>\n" +
                "        <div class=\"form-group \">\n" +
                "            <a href=\"update.jsp\">Update An Other student</a>\n" +
                "             <a href=\"index.html\"><button type=\"submit\" class=\"btn btn-primary btn-block\">Go to The First Page</button></a>\n" +
                "        </div>\n" +
                "    </form>\n" +
                " </div>\n" );



                out.println("</body>");
                out.println("</html>");   
            }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
