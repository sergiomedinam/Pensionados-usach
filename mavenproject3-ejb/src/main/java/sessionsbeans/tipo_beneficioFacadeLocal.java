/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.tipo_beneficio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface tipo_beneficioFacadeLocal {

    void create(tipo_beneficio tipo_beneficio);

    void edit(tipo_beneficio tipo_beneficio);

    void remove(tipo_beneficio tipo_beneficio);

    tipo_beneficio find(Object id);

    List<tipo_beneficio> findAll();

    List<tipo_beneficio> findRange(int[] range);

    int count();
    
}
