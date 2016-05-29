/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borrar;

import entities.auditoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author seerg
 */
@Stateless
public class auditoriaFacade extends AbstractFacade<auditoria> {

    @PersistenceContext(unitName = "com.mycompany_mavenproject3-web_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public auditoriaFacade() {
        super(auditoria.class);
    }
    
}
