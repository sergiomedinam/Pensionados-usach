/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pensionado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author seerg
 */
@Local
public interface pensionadoFacadeLocal {

    void create(pensionado pensionado);

    void edit(pensionado pensionado);

    void remove(pensionado pensionado);

    pensionado find(Object id);

    List<pensionado> findAll();

    List<pensionado> findRange(int[] range);

    int count();
    
}
