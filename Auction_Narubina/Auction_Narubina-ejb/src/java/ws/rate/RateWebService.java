/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.rate;

import entity.Rate;
import facade.RateFacadeLocal;
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
@WebService(serviceName = "RateWebService")
@Stateless()
public class RateWebService {
    @EJB
    private RateFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "rate") Rate rate) {
        ejbRef.create(rate);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "rate") Rate rate) {
        ejbRef.edit(rate);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "rate") Rate rate) {
        ejbRef.remove(rate);
    }

    @WebMethod(operationName = "find")
    public Rate find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Rate> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Rate> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
