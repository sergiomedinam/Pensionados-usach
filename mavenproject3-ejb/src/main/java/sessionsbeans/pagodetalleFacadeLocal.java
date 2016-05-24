/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pagodetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface pagodetalleFacadeLocal {

    void create(pagodetalle pagodetalle);

    void edit(pagodetalle pagodetalle);

    void remove(pagodetalle pagodetalle);

    pagodetalle find(Object id);

    List<pagodetalle> findAll();

    List<pagodetalle> findRange(int[] range);

    int count();
    
}
