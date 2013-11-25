
package client.archive;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.5-b04 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ArchiveWebService", targetNamespace = "http://archive.ws/", wsdlLocation = "http://localhost:8080/ArchiveWebService/ArchiveWebService?wsdl")
public class ArchiveWebService_Service
    extends Service
{

    private final static URL ARCHIVEWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException ARCHIVEWEBSERVICE_EXCEPTION;
    private final static QName ARCHIVEWEBSERVICE_QNAME = new QName("http://archive.ws/", "ArchiveWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ArchiveWebService/ArchiveWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ARCHIVEWEBSERVICE_WSDL_LOCATION = url;
        ARCHIVEWEBSERVICE_EXCEPTION = e;
    }

    public ArchiveWebService_Service() {
        super(__getWsdlLocation(), ARCHIVEWEBSERVICE_QNAME);
    }

    public ArchiveWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ARCHIVEWEBSERVICE_QNAME, features);
    }

    public ArchiveWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, ARCHIVEWEBSERVICE_QNAME);
    }

    public ArchiveWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ARCHIVEWEBSERVICE_QNAME, features);
    }

    public ArchiveWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ArchiveWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ArchiveWebService
     */
    @WebEndpoint(name = "ArchiveWebServicePort")
    public ArchiveWebService getArchiveWebServicePort() {
        return super.getPort(new QName("http://archive.ws/", "ArchiveWebServicePort"), ArchiveWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ArchiveWebService
     */
    @WebEndpoint(name = "ArchiveWebServicePort")
    public ArchiveWebService getArchiveWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://archive.ws/", "ArchiveWebServicePort"), ArchiveWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ARCHIVEWEBSERVICE_EXCEPTION!= null) {
            throw ARCHIVEWEBSERVICE_EXCEPTION;
        }
        return ARCHIVEWEBSERVICE_WSDL_LOCATION;
    }

}
