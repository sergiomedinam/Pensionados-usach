/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author seerg
 */
@Local
public interface usuarioFacadeLocal {

    void create(usuario usuario);

    void edit(usuario usuario);

    void remove(usuario usuario);

    usuario find(Object id);

    List<usuario> findAll();

    List<usuario> findRange(int[] range);

    int count();
    
}
