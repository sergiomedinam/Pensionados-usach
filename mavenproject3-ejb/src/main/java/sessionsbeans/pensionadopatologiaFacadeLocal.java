/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pensionadopatologia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author seerg
 */
@Local
public interface pensionadopatologiaFacadeLocal {

    void create(pensionadopatologia pensionadopatologia);

    void edit(pensionadopatologia pensionadopatologia);

    void remove(pensionadopatologia pensionadopatologia);

    pensionadopatologia find(Object id);

    List<pensionadopatologia> findAll();

    List<pensionadopatologia> findRange(int[] range);

    int count();
    
}
