/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Lot;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Танюся
 */
@Stateless
public class LotFacade extends AbstractFacade<Lot> implements LotFacadeLocal {
    @PersistenceContext(unitName = "Auction_Narubina-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public LotFacade() {
        super(Lot.class);
    }
    
}
