
package client.rate;

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
@WebService(name = "RateWebService", targetNamespace = "http://rate.ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RateWebService {


    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://rate.ws/", className = "client.rate.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://rate.ws/", className = "client.rate.CountResponse")
    @Action(input = "http://rate.ws/RateWebService/countRequest", output = "http://rate.ws/RateWebService/countResponse")
    public int count();

    /**
     * 
     * @param id
     * @return
     *     returns client.rate.Rate
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "find", targetNamespace = "http://rate.ws/", className = "client.rate.Find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://rate.ws/", className = "client.rate.FindResponse")
    @Action(input = "http://rate.ws/RateWebService/findRequest", output = "http://rate.ws/RateWebService/findResponse")
    public Rate find(
        @WebParam(name = "id", targetNamespace = "")
        Object id);

    /**
     * 
     * @param rate
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "remove", targetNamespace = "http://rate.ws/", className = "client.rate.Remove")
    @Action(input = "http://rate.ws/RateWebService/remove")
    public void remove(
        @WebParam(name = "rate", targetNamespace = "")
        Rate rate);

    /**
     * 
     * @param rate
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "create", targetNamespace = "http://rate.ws/", className = "client.rate.Create")
    @Action(input = "http://rate.ws/RateWebService/create")
    public void create(
        @WebParam(name = "rate", targetNamespace = "")
        Rate rate);

    /**
     * 
     * @return
     *     returns java.util.List<client.rate.Rate>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://rate.ws/", className = "client.rate.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://rate.ws/", className = "client.rate.FindAllResponse")
    @Action(input = "http://rate.ws/RateWebService/findAllRequest", output = "http://rate.ws/RateWebService/findAllResponse")
    public List<Rate> findAll();

    /**
     * 
     * @param rate
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "edit", targetNamespace = "http://rate.ws/", className = "client.rate.Edit")
    @Action(input = "http://rate.ws/RateWebService/edit")
    public void edit(
        @WebParam(name = "rate", targetNamespace = "")
        Rate rate);

    /**
     * 
     * @param range
     * @return
     *     returns java.util.List<client.rate.Rate>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findRange", targetNamespace = "http://rate.ws/", className = "client.rate.FindRange")
    @ResponseWrapper(localName = "findRangeResponse", targetNamespace = "http://rate.ws/", className = "client.rate.FindRangeResponse")
    @Action(input = "http://rate.ws/RateWebService/findRangeRequest", output = "http://rate.ws/RateWebService/findRangeResponse")
    public List<Rate> findRange(
        @WebParam(name = "range", targetNamespace = "")
        List<Integer> range);

}