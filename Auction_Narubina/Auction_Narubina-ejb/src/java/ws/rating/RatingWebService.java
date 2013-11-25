/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.rating;

import entity.Rating;
import facade.RatingFacadeLocal;
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
@WebService(serviceName = "RatingWebService")
@Stateless()
public class RatingWebService {
    @EJB
    private RatingFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "rating") Rating rating) {
        ejbRef.create(rating);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "rating") Rating rating) {
        ejbRef.edit(rating);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "rating") Rating rating) {
        ejbRef.remove(rating);
    }

    @WebMethod(operationName = "find")
    public Rating find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Rating> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Rating> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
