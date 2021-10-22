/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adlproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ConnectClass {
      private Connection cnx;
    
    public ConnectClass()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver: OK");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/student","root","0000");
            System.out.println("ConnectClass: OK");
          
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Driver: erreur");
        }
        catch(SQLException e)
        {
            System.err.println("ConnectClass: erreur = " + e);
        }
    }
    public Connection getCon()
    {
        return cnx;
    }
    
}
