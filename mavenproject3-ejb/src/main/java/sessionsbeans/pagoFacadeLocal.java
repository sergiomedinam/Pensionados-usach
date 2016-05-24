/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface pagoFacadeLocal {

    void create(pago pago);

    void edit(pago pago);

    void remove(pago pago);

    pago find(Object id);

    List<pago> findAll();

    List<pago> findRange(int[] range);

    int count();
    
}
