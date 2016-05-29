/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.auditoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author seerg
 */
@Local
public interface auditoriaFacadeLocal {

    void create(auditoria auditoria);

    void edit(auditoria auditoria);

    void remove(auditoria auditoria);

    auditoria find(Object id);

    List<auditoria> findAll();

    List<auditoria> findRange(int[] range);

    int count();
    
}
