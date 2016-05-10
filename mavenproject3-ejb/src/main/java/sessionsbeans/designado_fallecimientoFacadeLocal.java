/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.designado_fallecimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sergio
 */
@Local
public interface designado_fallecimientoFacadeLocal {

    void create(designado_fallecimiento designado_fallecimiento);

    void edit(designado_fallecimiento designado_fallecimiento);

    void remove(designado_fallecimiento designado_fallecimiento);

    designado_fallecimiento find(Object id);

    List<designado_fallecimiento> findAll();

    List<designado_fallecimiento> findRange(int[] range);

    int count();
    
}
