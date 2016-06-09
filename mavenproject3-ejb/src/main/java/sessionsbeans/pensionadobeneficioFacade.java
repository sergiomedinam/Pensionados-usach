/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionsbeans;

import entities.pensionadobeneficio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author seerg
 */
@Stateless
public class pensionadobeneficioFacade extends AbstractFacade<pensionadobeneficio> implements pensionadobeneficioFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_mavenproject3-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public pensionadobeneficioFacade() {
        super(pensionadobeneficio.class);
    }
    
}
