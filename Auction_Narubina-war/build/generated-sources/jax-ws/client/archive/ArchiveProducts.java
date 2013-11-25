
package client.archive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for archiveProducts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="archiveProducts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="buyedOfUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDProduct" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IDUser" type="{http://archive.ws/}users" minOccurs="0"/>
 *         &lt;element name="lastDateRate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nameLot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "archiveProducts", propOrder = {
    "addedDate",
    "buyedOfUser",
    "idProduct",
    "idUser",
    "lastDateRate",
    "nameLot",
    "startCost"
})
public class ArchiveProducts {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar addedDate;
    protected String buyedOfUser;
    @XmlElement(name = "IDProduct")
    protected Integer idProduct;
    @XmlElement(name = "IDUser")
    protected Users idUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastDateRate;
    protected String nameLot;
    protected int startCost;

    /**
     * Gets the value of the addedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAddedDate() {
        return addedDate;
    }

    /**
     * Sets the value of the addedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAddedDate(XMLGregorianCalendar value) {
        this.addedDate = value;
    }

    /**
     * Gets the value of the buyedOfUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyedOfUser() {
        return buyedOfUser;
    }

    /**
     * Sets the value of the buyedOfUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyedOfUser(String value) {
        this.buyedOfUser = value;
    }

    /**
     * Gets the value of the idProduct property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDProduct() {
        return idProduct;
    }

    /**
     * Sets the value of the idProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDProduct(Integer value) {
        this.idProduct = value;
    }

    /**
     * Gets the value of the idUser property.
     * 
     * @return
     *     possible object is
     *     {@link Users }
     *     
     */
    public Users getIDUser() {
        return idUser;
    }

    /**
     * Sets the value of the idUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Users }
     *     
     */
    public void setIDUser(Users value) {
        this.idUser = value;
    }

    /**
     * Gets the value of the lastDateRate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastDateRate() {
        return lastDateRate;
    }

    /**
     * Sets the value of the lastDateRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastDateRate(XMLGregorianCalendar value) {
        this.lastDateRate = value;
    }

    /**
     * Gets the value of the nameLot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameLot() {
        return nameLot;
    }

    /**
     * Sets the value of the nameLot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameLot(String value) {
        this.nameLot = value;
    }

    /**
     * Gets the value of the startCost property.
     * 
     */
    public int getStartCost() {
        return startCost;
    }

    /**
     * Sets the value of the startCost property.
     * 
     */
    public void setStartCost(int value) {
        this.startCost = value;
    }

}
