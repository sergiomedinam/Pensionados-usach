/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.tipo_prestamo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface tipo_prestamoFacadeLocal {

    void create(tipo_prestamo tipo_prestamo);

    void edit(tipo_prestamo tipo_prestamo);

    void remove(tipo_prestamo tipo_prestamo);

    tipo_prestamo find(Object id);

    List<tipo_prestamo> findAll();

    List<tipo_prestamo> findRange(int[] range);

    int count();
    
}
