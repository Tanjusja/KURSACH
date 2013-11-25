/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ArchiveProducts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Танюся
 */
@Local
public interface ArchiveProductsFacadeLocal {

    void create(ArchiveProducts archiveProducts);

    void edit(ArchiveProducts archiveProducts);

    void remove(ArchiveProducts archiveProducts);

    ArchiveProducts find(Object id);

    List<ArchiveProducts> findAll();

    List<ArchiveProducts> findRange(int[] range);

    int count();
    
}
