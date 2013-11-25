/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.category;

import entity.Category;
import facade.CategoryFacadeLocal;
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
@WebService(serviceName = "CategoryWebService")
@Stateless()
public class CategoryWebService {
    @EJB
    private CategoryFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "category") Category category) {
        ejbRef.create(category);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "category") Category category) {
        ejbRef.edit(category);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "category") Category category) {
        ejbRef.remove(category);
    }

    @WebMethod(operationName = "find")
    public Category find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Category> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Category> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
