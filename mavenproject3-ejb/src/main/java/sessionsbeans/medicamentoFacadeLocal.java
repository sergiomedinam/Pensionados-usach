/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.medicamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface medicamentoFacadeLocal {

    void create(medicamento medicamento);

    void edit(medicamento medicamento);

    void remove(medicamento medicamento);

    medicamento find(Object id);

    List<medicamento> findAll();

    List<medicamento> findRange(int[] range);

    int count();
    
}
