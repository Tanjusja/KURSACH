/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ArchiveProducts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Танюся
 */
@Stateless
public class ArchiveProductsFacade extends AbstractFacade<ArchiveProducts> implements ArchiveProductsFacadeLocal {
    @PersistenceContext(unitName = "Auction_Narubina-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ArchiveProductsFacade() {
        super(ArchiveProducts.class);
    }
    
}
