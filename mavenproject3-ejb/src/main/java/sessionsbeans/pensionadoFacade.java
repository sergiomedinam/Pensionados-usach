/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pensionado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author seerg
 */
@Stateless
public class pensionadoFacade extends AbstractFacade<pensionado> implements pensionadoFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_mavenproject3-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public pensionadoFacade() {
        super(pensionado.class);
    }
    
}
