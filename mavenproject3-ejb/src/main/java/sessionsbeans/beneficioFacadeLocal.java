/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.beneficio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface beneficioFacadeLocal {

    void create(beneficio beneficio);

    void edit(beneficio beneficio);

    void remove(beneficio beneficio);

    beneficio find(Object id);

    List<beneficio> findAll();

    List<beneficio> findRange(int[] range);

    int count();
    
}
