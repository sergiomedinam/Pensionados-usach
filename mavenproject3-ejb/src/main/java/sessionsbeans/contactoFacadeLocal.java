/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.contacto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface contactoFacadeLocal {

    void create(contacto contacto);

    void edit(contacto contacto);

    void remove(contacto contacto);

    contacto find(Object id);

    List<contacto> findAll();

    List<contacto> findRange(int[] range);

    int count();
    
}
