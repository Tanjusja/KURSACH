/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Rate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Танюся
 */
@Local
public interface RateFacadeLocal {

    void create(Rate rate);

    void edit(Rate rate);

    void remove(Rate rate);

    Rate find(Object id);

    List<Rate> findAll();

    List<Rate> findRange(int[] range);

    int count();
    
}
