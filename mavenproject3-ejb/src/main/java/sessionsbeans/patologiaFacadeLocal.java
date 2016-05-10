/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.patologia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface patologiaFacadeLocal {

    void create(patologia patologia);

    void edit(patologia patologia);

    void remove(patologia patologia);

    patologia find(Object id);

    List<patologia> findAll();

    List<patologia> findRange(int[] range);

    int count();
    
}
