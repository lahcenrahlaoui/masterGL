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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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

@WebServlet(urlPatterns = {"/Search"})

public class Search extends HttpServlet {

    @EJB
    private StdFacadeLocal stdFacade;

    Std student = null;
    List <Std> allStudent = null;
            

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
                   +"* {\n" +
                      ".table-headers{"
                      + "background:red;}"
                      
                    +"  box-sizing: border-box;\n" +
                    "}\n" +
                    "table {\n" +
                    "  width: 100%;\n" +
                    "  border-collapse: collapse;\n" +
                    "  text-align: left;\n" +
                    "  overflow: hidden;\n" +
                    "}\n" +
                    "td, th {\n" +
                    "  border-top: 1px solid #ECF0F1;\n" +
                    "  padding: 10px;\n" +
                    "}\n" +
                    "td {\n" +
                    "  border-left: 1px solid #ECF0F1;\n" +
                    "  border-right: 1px solid #ECF0F1;\n" +
                    "}\n" +
                    "th {\n" +
                    "  background-color: #4ECDC4;\n" +
                    "}\n" +
                    "tr:nth-of-type(even) td {\n" +
                    "  background-color: #d9f4f2;\n" +
                    "}"
                      + ".bigtext{"
                      + "font-size:30px;"
                      + "color:#333"
                      + "}"
                      
                      
                    + "</style>");
            
           
            
            out.println("</head>");
            out.println("<body>");

            
            int allStudentCount = stdFacade.count();
            int count = 0 ; 

            String item = null;
            while(item == null){
                item = request.getParameter("item");
            }
               
            int id = 0 ;
            Float average = 0f ;
            String firstNameOrLastName =null;
            String value = null;
            value = request.getParameter("inp");
            String degree = null ;
            String year = null ; 
            int i = 0 ; 
            if(value.length() > 0 ){
                 if("id".equals(item) ){
                          id = Integer.parseInt(value) ; 
                          student = stdFacade.find(id);
                          i = 1 ;
                  }else{
                        allStudent = stdFacade.findAll();
                        if("firstName".equals(item)){
                            firstNameOrLastName = value ; 
                            i = 2 ; 
                        }else if("lastName".equals(item)){
                            firstNameOrLastName = value ; 
                            i = 3 ; 
                        }else if("average".equals(item)) {
                            average = Float.parseFloat(value) ;
                            i = 4 ;
                        }else if("degree".equals(item)) {
                            degree = value ;
                            i = 5 ;
                        }else {
                            year = value ;
                            i = 6 ;
                        }
                    }
            }else{
                 allStudent = stdFacade.findAll();
            }
             
            int ss = 0 ; 
            try{
                        out.println("<div>"+student.getFirstName()+"</div>");
            }catch(Exception e){
                ss = 1 ;
            }
            
            
            if(ss == 1 && allStudent== null){

                   out.println("<div class=\"big-parent\">");
                            out.println("<div>");
                                out.println("<center><h2> The Search result is : </h2></center>");
                                out.println("<div class=\"parent\">");
                                    out.println("<div class=\"bigtext\">This Person Does Not Exist</div>");
                                out.println("</div>");
                          out.println("</div>");
                       out.println("</div>");
            }
            else{

                   out.println("<div class=\"big-parent\">");
                            out.println("<div>");
                                out.println("<center><h2> The Search result is : </h2></center>");
                                out.println("<div class=\"parent\">");
                                    out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
                                    out.println("<tr class=\"table-headers\">");
                                    out.println("<td><b>ID</b></td>");
                                    out.println("<td><b>First Name</b></td>");
                                    out.println("<td><b>Last Name</b></td>");
                                    out.println("<td><b>Average </b></td>");
                                     out.println("<td><b>Degree</b></td>");
                                    out.println("<td><b>Year </b></td>");
                                    out.println("</tr>");
                                        out.println("<tr>");
                                        if(i == 1 ){
                                            out.println("<tr>");
                                                out.println("<td>"+student.getId() + "</td>");
                                                out.println("<td>"+student.getFirstName() + "</td>");
                                                out.println("<td>"+student.getLastName() + "</td>");                   
                                                out.println("<td>"+student.getAverage() + "</td>");
                                                out.println("<td>"+student.getDegree()+ "</td>");                   
                                                out.println("<td>"+student.getYear()+ "</td>");
                                            out.println("</tr>");
                                        }else if(i == 2 ){
                                            for (Std s : allStudent){
                                                if(firstNameOrLastName.equals(s.getFirstName())){
                                                    count++;
                                                    out.println("<tr>");
                                                        out.println("<td>"+s.getId() + "</td>");
                                                        out.println("<td>"+s.getFirstName() + "</td>");
                                                        out.println("<td>"+s.getLastName() + "</td>");                   
                                                        out.println("<td>"+s.getAverage() + "</td>");
                                                        out.println("<td>"+s.getDegree()+ "</td>");                   
                                                        out.println("<td>"+s.getYear()+ "</td>");
                                                    out.println("</tr>");  
                                                }
                                            }  
                                        }else if(i == 3 ){
                                            for (Std s : allStudent){
                                                if(firstNameOrLastName.equals(s.getLastName())){
                                                    count++;
                                                    out.println("<tr>");
                                                        out.println("<td>"+s.getId() + "</td>");
                                                        out.println("<td>"+s.getFirstName() + "</td>");
                                                        out.println("<td>"+s.getLastName() + "</td>");                   
                                                        out.println("<td>"+s.getAverage() + "</td>");
                                                        out.println("<td>"+s.getDegree()+ "</td>");                   
                                                        out.println("<td>"+s.getYear()+ "</td>");
                                                    out.println("</tr>");  
                                                }
                                            }  
                                        }else if(i == 4 ){
                                              for (Std s : allStudent){
                                                if(average.equals(s.getAverage())){
                                                    count++;
                                                    out.println("<tr>");
                                                        out.println("<td>"+s.getId() + "</td>");
                                                        out.println("<td>"+s.getFirstName() + "</td>");
                                                        out.println("<td>"+s.getLastName() + "</td>");                   
                                                        out.println("<td>"+s.getAverage() + "</td>");
                                                        out.println("<td>"+s.getDegree()+ "</td>");                   
                                                        out.println("<td>"+s.getYear()+ "</td>");
                                                    out.println("</tr>");  
                                                }
                                            }  
                                        }else if(i == 5 ){
                                              for (Std s : allStudent){
                                                if(degree.equals(s.getDegree())){
                                                    count++;
                                                    out.println("<tr>");
                                                        out.println("<td>"+s.getId() + "</td>");
                                                        out.println("<td>"+s.getFirstName() + "</td>");
                                                        out.println("<td>"+s.getLastName() + "</td>");                   
                                                        out.println("<td>"+s.getAverage() + "</td>");
                                                        out.println("<td>"+s.getDegree()+ "</td>");                   
                                                        out.println("<td>"+s.getYear()+ "</td>");
                                                    out.println("</tr>");  
                                                }
                                            }  
                                        }else if(i == 6 ){
                                              for (Std s : allStudent){
                                                 
                                                if(year.equals(s.getYear())){
                                                     count++;
                                                    out.println("<tr>");
                                                        out.println("<td>"+s.getId() + "</td>");
                                                        out.println("<td>"+s.getFirstName() + "</td>");
                                                        out.println("<td>"+s.getLastName() + "</td>");                   
                                                        out.println("<td>"+s.getAverage() + "</td>");
                                                        out.println("<td>"+s.getDegree()+ "</td>");                   
                                                        out.println("<td>"+s.getYear()+ "</td>");
                                                    out.println("</tr>");  
                                                }
                                            }
                                     out.println();
                                           
                                              
                                        }else {
                                                
                                              for (Std s : allStudent){
                                                out.println("<tr>");
                                                    out.println("<td>"+s.getId() + "</td>");
                                                    out.println("<td>"+s.getFirstName() + "</td>");
                                                    out.println("<td>"+s.getLastName() + "</td>");                   
                                                    out.println("<td>"+s.getAverage() + "</td>");
                                                    out.println("<td>"+s.getDegree()+ "</td>");                   
                                                    out.println("<td>"+s.getYear()+ "</td>");
                                                out.println("</tr>");  
                                            }  
                                        }
                                        
                                           out.println("</table>" );
                    
                                        
                                out.println("</div>");
                          out.println("</div>");
                       out.println("</div>");
                    }
                       out.println("<center><div style=\"margin:30px 0; font-size:22px; color :red\"> display "+count+" from "+allStudentCount+"</div></center>");

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
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InterruptedException ex) {
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
