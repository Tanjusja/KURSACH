
package client.rate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for rate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amountRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dateRate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="IDLot" type="{http://rate.ws/}lot" minOccurs="0"/>
 *         &lt;element name="IDRate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IDUser" type="{http://rate.ws/}users" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rate", propOrder = {
    "amountRate",
    "dateRate",
    "idLot",
    "idRate",
    "idUser"
})
public class Rate {

    protected int amountRate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateRate;
    @XmlElement(name = "IDLot")
    protected Lot idLot;
    @XmlElement(name = "IDRate")
    protected Integer idRate;
    @XmlElement(name = "IDUser")
    protected Users idUser;

    /**
     * Gets the value of the amountRate property.
     * 
     */
    public int getAmountRate() {
        return amountRate;
    }

    /**
     * Sets the value of the amountRate property.
     * 
     */
    public void setAmountRate(int value) {
        this.amountRate = value;
    }

    /**
     * Gets the value of the dateRate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateRate() {
        return dateRate;
    }

    /**
     * Sets the value of the dateRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateRate(XMLGregorianCalendar value) {
        this.dateRate = value;
    }

    /**
     * Gets the value of the idLot property.
     * 
     * @return
     *     possible object is
     *     {@link Lot }
     *     
     */
    public Lot getIDLot() {
        return idLot;
    }

    /**
     * Sets the value of the idLot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lot }
     *     
     */
    public void setIDLot(Lot value) {
        this.idLot = value;
    }

    /**
     * Gets the value of the idRate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDRate() {
        return idRate;
    }

    /**
     * Sets the value of the idRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDRate(Integer value) {
        this.idRate = value;
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

}
