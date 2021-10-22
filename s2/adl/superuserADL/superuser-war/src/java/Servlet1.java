/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import demo.Std;
import demo.StdFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");  
            
            
            out.println("<style> "
                    + ".big-parent{"
                    + "     display: flex;"
                    + "     justify-content: center;"
                    + "     align-items: center;"
                    + "}"
                    + ".center-row{"
                    + "     display:flex;"
                    + "     justify-content:center;"
                    + "     align-items:center;"
                    + "}"
                    + ".parent{"
                    +"      width:500px;"
                    + "     border: 2px solid black;"
                    + "     padding: 30px;"
                    + "     margin-top: 90px "
                    + "}"
                    + ".row{"
                    +"      width : 200px ; "
                    + "     display:grid;"
                    + "     grid-template-columns: 125px 400px;"
                    + "}"
                    + ".fields{"
                    + "     margin: 10px;"
                    + "     padding: 10px;"
                    + "     text-transform: capitalize;"
                    + "}"
                    + ".submitbtn{"
                    + "     width: 130px;"
                    + "     height: 35px;"
                    + "     margin-left: 190px;"
                    + "     padding: 7px;"
                    + "     background: skyblue;"
                    + "     border:none;"
                    + "     margin-top: 30px;"
                    + "} "
                   
                    + "</style>");
            
            
            
            out.println("</head>");
            out.println("<body>");
           
            
            String id = request.getParameter("id");
            String firstName   = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String average = request.getParameter("average");
 
            Std std = new Std();

            std.setId(Integer.parseInt(id));  
            std.setFirstName(firstName);
            std.setLastName(lastName);
            std.setAverage(Float.parseFloat(average));
           

            stdFacade.create(std);
            
                out.println("<div class=\"big-parent\">");
                    out.println("<div>");

                        out.println("<center><h2> You Have Added A New Record</h2></center>");

                        out.println("<div class=\"parent\">");
                            out.println("<div class=\"center-row\">");

                                out.println("<div class=\"row\">");
                                    out.println("<div class=\"fields\"> id         </div><div class=\"fields\">"+id+       "</div>");
                                    out.println("<div class=\"fields\"> first name </div><div class=\"fields\">"+firstName+"</div>");
                                    out.println("<div class=\"fields\"> last name  </div><div class=\"fields\">"+lastName+ "</div>");
                                    out.println("<div class=\"fields\"> average    </div><div class=\"fields\">"+average+  "</div>");
                                out.println("</div>");
                            out.println("</div>");
                            out.println("<Button class=\"submitbtn\"><a href=\"jsp1.jsp\">Add Another User</a></Button>");
                        out.println("</div>");
                    out.println("</div>");
                out.println("</div>");


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
        processRequest(request, response);
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
        processRequest(request, response);
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
