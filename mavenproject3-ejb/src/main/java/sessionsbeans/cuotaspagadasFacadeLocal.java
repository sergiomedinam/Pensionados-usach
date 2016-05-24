/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.cuotaspagadas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface cuotaspagadasFacadeLocal {

    void create(cuotaspagadas cuotaspagadas);

    void edit(cuotaspagadas cuotaspagadas);

    void remove(cuotaspagadas cuotaspagadas);

    cuotaspagadas find(Object id);

    List<cuotaspagadas> findAll();

    List<cuotaspagadas> findRange(int[] range);

    int count();
    
}
