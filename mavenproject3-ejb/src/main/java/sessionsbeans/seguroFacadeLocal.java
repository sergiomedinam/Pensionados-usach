/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.seguro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface seguroFacadeLocal {

    void create(seguro seguro);

    void edit(seguro seguro);

    void remove(seguro seguro);

    seguro find(Object id);

    List<seguro> findAll();

    List<seguro> findRange(int[] range);

    int count();
    
}
