/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author seerg
 */
@Stateless
public class usuarioFacade extends AbstractFacade<usuario> implements usuarioFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_mavenproject3-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public usuarioFacade() {
        super(usuario.class);
    }
    
}
