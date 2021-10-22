/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class HelloWorld implements HelloWorldLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     *
     * @return
     */
    
    public String getMessage() {   
        System.out.println("Hello World qui va s'afficher dans la console du serveur, pour trace");   
        return "Hello World";   
    }  

    
    
    
    
    
}
