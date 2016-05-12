/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nelson
 */
@Local
public interface rolFacadeLocal {

    void create(rol rol);

    void edit(rol rol);

    void remove(rol rol);

    rol find(Object id);

    List<rol> findAll();

    List<rol> findRange(int[] range);

    int count();
    
}
