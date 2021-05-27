/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface StdFacadeLocal {

    void create(Std std);

    void edit(Std std);

    void remove(Std std);

    Std find(Object id);

    List<Std> findAll();

    List<Std> findRange(int[] range);

    int count();
    
}
