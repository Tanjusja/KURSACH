
package client.archive;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b04 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ArchiveWebService", targetNamespace = "http://archive.ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ArchiveWebService {


    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://archive.ws/", className = "client.archive.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://archive.ws/", className = "client.archive.CountResponse")
    @Action(input = "http://archive.ws/ArchiveWebService/countRequest", output = "http://archive.ws/ArchiveWebService/countResponse")
    public int count();

    /**
     * 
     * @param id
     * @return
     *     returns client.archive.ArchiveProducts
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "find", targetNamespace = "http://archive.ws/", className = "client.archive.Find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://archive.ws/", className = "client.archive.FindResponse")
    @Action(input = "http://archive.ws/ArchiveWebService/findRequest", output = "http://archive.ws/ArchiveWebService/findResponse")
    public ArchiveProducts find(
        @WebParam(name = "id", targetNamespace = "")
        Object id);

    /**
     * 
     * @param archiveProducts
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "remove", targetNamespace = "http://archive.ws/", className = "client.archive.Remove")
    @Action(input = "http://archive.ws/ArchiveWebService/remove")
    public void remove(
        @WebParam(name = "archiveProducts", targetNamespace = "")
        ArchiveProducts archiveProducts);

    /**
     * 
     * @param archiveProducts
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "create", targetNamespace = "http://archive.ws/", className = "client.archive.Create")
    @Action(input = "http://archive.ws/ArchiveWebService/create")
    public void create(
        @WebParam(name = "archiveProducts", targetNamespace = "")
        ArchiveProducts archiveProducts);

    /**
     * 
     * @return
     *     returns java.util.List<client.archive.ArchiveProducts>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://archive.ws/", className = "client.archive.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://archive.ws/", className = "client.archive.FindAllResponse")
    @Action(input = "http://archive.ws/ArchiveWebService/findAllRequest", output = "http://archive.ws/ArchiveWebService/findAllResponse")
    public List<ArchiveProducts> findAll();

    /**
     * 
     * @param archiveProducts
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "edit", targetNamespace = "http://archive.ws/", className = "client.archive.Edit")
    @Action(input = "http://archive.ws/ArchiveWebService/edit")
    public void edit(
        @WebParam(name = "archiveProducts", targetNamespace = "")
        ArchiveProducts archiveProducts);

    /**
     * 
     * @param range
     * @return
     *     returns java.util.List<client.archive.ArchiveProducts>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findRange", targetNamespace = "http://archive.ws/", className = "client.archive.FindRange")
    @ResponseWrapper(localName = "findRangeResponse", targetNamespace = "http://archive.ws/", className = "client.archive.FindRangeResponse")
    @Action(input = "http://archive.ws/ArchiveWebService/findRangeRequest", output = "http://archive.ws/ArchiveWebService/findRangeResponse")
    public List<ArchiveProducts> findRange(
        @WebParam(name = "range", targetNamespace = "")
        List<Integer> range);

}
