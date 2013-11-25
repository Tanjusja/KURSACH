
package client.lots;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for lot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDCategory" type="{http://lots.ws/}category" minOccurs="0"/>
 *         &lt;element name="IDLot" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IDUser" type="{http://lots.ws/}users" minOccurs="0"/>
 *         &lt;element name="minRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nameLot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tradingHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lot", propOrder = {
    "addedDate",
    "description",
    "idCategory",
    "idLot",
    "idUser",
    "minRate",
    "nameLot",
    "startCost",
    "tradingHours"
})
public class Lot {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar addedDate;
    protected String description;
    @XmlElement(name = "IDCategory")
    protected Category idCategory;
    @XmlElement(name = "IDLot")
    protected Integer idLot;
    @XmlElement(name = "IDUser")
    protected Users idUser;
    protected int minRate;
    protected String nameLot;
    protected int startCost;
    protected int tradingHours;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the idCategory property.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getIDCategory() {
        return idCategory;
    }

    /**
     * Sets the value of the idCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setIDCategory(Category value) {
        this.idCategory = value;
    }

    /**
     * Gets the value of the idLot property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDLot() {
        return idLot;
    }

    /**
     * Sets the value of the idLot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDLot(Integer value) {
        this.idLot = value;
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
     * Gets the value of the minRate property.
     * 
     */
    public int getMinRate() {
        return minRate;
    }

    /**
     * Sets the value of the minRate property.
     * 
     */
    public void setMinRate(int value) {
        this.minRate = value;
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

    /**
     * Gets the value of the tradingHours property.
     * 
     */
    public int getTradingHours() {
        return tradingHours;
    }

    /**
     * Sets the value of the tradingHours property.
     * 
     */
    public void setTradingHours(int value) {
        this.tradingHours = value;
    }

}
