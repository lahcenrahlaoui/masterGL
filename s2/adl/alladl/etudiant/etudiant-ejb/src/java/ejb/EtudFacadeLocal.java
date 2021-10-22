/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface EtudFacadeLocal {

    void create(Etud etud);

    void edit(Etud etud);

    void remove(Etud etud);

    Etud find(Object id);

    List<Etud> findAll();

    List<Etud> findRange(int[] range);

    int count();
    
}
