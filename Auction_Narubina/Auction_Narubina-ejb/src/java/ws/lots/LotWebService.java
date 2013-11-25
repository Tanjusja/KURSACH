/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.lots;

import entity.Lot;
import facade.LotFacadeLocal;
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
@WebService(serviceName = "LotWebService")
@Stateless()
public class LotWebService {
    @EJB
    private LotFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "lot") Lot lot) {
        ejbRef.create(lot);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "lot") Lot lot) {
        ejbRef.edit(lot);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "lot") Lot lot) {
        ejbRef.remove(lot);
    }

    @WebMethod(operationName = "find")
    public Lot find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Lot> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Lot> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
