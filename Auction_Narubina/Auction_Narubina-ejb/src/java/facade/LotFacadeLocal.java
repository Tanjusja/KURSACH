/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Lot;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Танюся
 */
@Local
public interface LotFacadeLocal {

    void create(Lot lot);

    void edit(Lot lot);

    void remove(Lot lot);

    Lot find(Object id);

    List<Lot> findAll();

    List<Lot> findRange(int[] range);

    int count();
    
}
