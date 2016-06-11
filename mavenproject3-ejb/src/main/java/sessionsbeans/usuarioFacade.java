/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public List<usuario> findbyEstado() {
        Query query;
        query = em.createNamedQuery("usuario.findByEstado")
                .setParameter("estado", "Deshabilitado");
        return query.getResultList();  
                
    }
    
}
