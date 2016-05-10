/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.otros_datos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface otros_datosFacadeLocal {

    void create(otros_datos otros_datos);

    void edit(otros_datos otros_datos);

    void remove(otros_datos otros_datos);

    otros_datos find(Object id);

    List<otros_datos> findAll();

    List<otros_datos> findRange(int[] range);

    int count();
    
}
