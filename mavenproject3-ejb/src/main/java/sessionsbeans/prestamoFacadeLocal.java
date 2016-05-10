/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.prestamo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface prestamoFacadeLocal {

    void create(prestamo prestamo);

    void edit(prestamo prestamo);

    void remove(prestamo prestamo);

    prestamo find(Object id);

    List<prestamo> findAll();

    List<prestamo> findRange(int[] range);

    int count();
    
}
