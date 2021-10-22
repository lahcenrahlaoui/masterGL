/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */

@WebServlet(urlPatterns = {"/Servlet6"})

public class Servlet6 extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");  
            
            
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
                    + "     display: flex;"
                    + "     justify-content: center;"
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

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            
            String sql = null;
            String item = null;
            while(item == null){
                item = request.getParameter("item");
            }
               
          
            int a = 0 ;
            Float f = 0f ;
            String s =null;
             String value = null;
             value = request.getParameter("inp");

          if(value.length()>0){
   
             
               if("id".equals(item) ){
                        a = Integer.parseInt(value) ; 
                        sql="select * from std where id= "+a+"";
                }else if("lastName".equals(item) || "firstName".equals(item)){
                    s = value ; 
                    sql="select * from std where "+item+"='"+s+"'";
                }else {
                   f = Float.parseFloat(value) ; 
                    sql="select * from std where average="+f+"";
                }
          }else{
               sql="select * from std";
          }
           
                Class.forName("com.mysql.jdbc.Driver");
                con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/std", "superuser", "0000");

                ps = con.prepareStatement(sql);
                resultSet = ps.executeQuery();
             
                
                
                
        out.println("<div class=\"big-parent\">");
            out.println("<div>");

                out.println("<center><h2> The Search result is : </h2></center>");

                out.println("<div class=\"parent\">");

                    out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
                    out.println("<tr>");
                    out.println("<td><b>ID</b></td>");
                    out.println("<td><b>First Name</b></td>");
                    out.println("<td><b>Last Name</b></td>");
                    out.println("<td><b>Average </b></td>");
                    out.println("</tr>");

                    while(resultSet.next()) {
                        out.println("<tr>");
                        out.println("<td>"+resultSet.getString(1) + "</td>");
                        out.println("<td>"+resultSet.getString(2) + "</td>");
                        out.println("<td>"+resultSet.getString(3) + "</td>");                   
                        out.println("<td>"+resultSet.getString(4) + "</td>");
                        out.println("</tr>");
                    }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servlet2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Servlet4.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Servlet2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servlet2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Servlet4.class.getName()).log(Level.SEVERE, null, ex);
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
