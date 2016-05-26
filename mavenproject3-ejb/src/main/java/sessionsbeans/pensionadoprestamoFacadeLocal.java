/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pensionadoprestamo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author seerg
 */
@Local
public interface pensionadoprestamoFacadeLocal {

    void create(pensionadoprestamo pensionadoprestamo);

    void edit(pensionadoprestamo pensionadoprestamo);

    void remove(pensionadoprestamo pensionadoprestamo);

    pensionadoprestamo find(Object id);

    List<pensionadoprestamo> findAll();

    List<pensionadoprestamo> findRange(int[] range);

    int count();
    
}
