/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface HelloWorldLocal {

    public String getMessage();
    
     
}
