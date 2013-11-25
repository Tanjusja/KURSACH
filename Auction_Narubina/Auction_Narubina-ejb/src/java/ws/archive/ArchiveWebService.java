/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.archive;

import entity.ArchiveProducts;
import facade.ArchiveProductsFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author Танюся
 */
@WebService(serviceName = "ArchiveWebService")
@Stateless()
public class ArchiveWebService {
    @EJB
    private ArchiveProductsFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "archiveProducts") ArchiveProducts archiveProducts) {
        ejbRef.create(archiveProducts);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "archiveProducts") ArchiveProducts archiveProducts) {
        ejbRef.edit(archiveProducts);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "archiveProducts") ArchiveProducts archiveProducts) {
        ejbRef.remove(archiveProducts);
    }

    @WebMethod(operationName = "find")
    public ArchiveProducts find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<ArchiveProducts> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<ArchiveProducts> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
