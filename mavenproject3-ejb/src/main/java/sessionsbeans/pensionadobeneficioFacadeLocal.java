/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pensionadobeneficio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author seerg
 */
@Local
public interface pensionadobeneficioFacadeLocal {

    void create(pensionadobeneficio pensionadobeneficio);

    void edit(pensionadobeneficio pensionadobeneficio);

    void remove(pensionadobeneficio pensionadobeneficio);

    pensionadobeneficio find(Object id);

    List<pensionadobeneficio> findAll();

    List<pensionadobeneficio> findRange(int[] range);

    int count();
    
}
