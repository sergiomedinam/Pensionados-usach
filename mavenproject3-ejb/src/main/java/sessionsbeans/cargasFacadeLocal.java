/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.cargas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author seerg
 */
@Local
public interface cargasFacadeLocal {

    void create(cargas cargas);

    void edit(cargas cargas);

    void remove(cargas cargas);

    cargas find(Object id);

    List<cargas> findAll();

    List<cargas> findRange(int[] range);

    int count();
    
}
