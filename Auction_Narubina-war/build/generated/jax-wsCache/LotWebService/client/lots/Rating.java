
package client.lots;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rating complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rating">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amountLikes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="amountLots" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="amountOwnLikes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="amountSales" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IDUser" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="mark" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="users" type="{http://lots.ws/}users" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rating", propOrder = {
    "amountLikes",
    "amountLots",
    "amountOwnLikes",
    "amountSales",
    "idUser",
    "mark",
    "users"
})
public class Rating {

    protected int amountLikes;
    protected int amountLots;
    protected int amountOwnLikes;
    protected int amountSales;
    @XmlElement(name = "IDUser")
    protected Integer idUser;
    protected int mark;
    protected Users users;

    /**
     * Gets the value of the amountLikes property.
     * 
     */
    public int getAmountLikes() {
        return amountLikes;
    }

    /**
     * Sets the value of the amountLikes property.
     * 
     */
    public void setAmountLikes(int value) {
        this.amountLikes = value;
    }

    /**
     * Gets the value of the amountLots property.
     * 
     */
    public int getAmountLots() {
        return amountLots;
    }

    /**
     * Sets the value of the amountLots property.
     * 
     */
    public void setAmountLots(int value) {
        this.amountLots = value;
    }

    /**
     * Gets the value of the amountOwnLikes property.
     * 
     */
    public int getAmountOwnLikes() {
        return amountOwnLikes;
    }

    /**
     * Sets the value of the amountOwnLikes property.
     * 
     */
    public void setAmountOwnLikes(int value) {
        this.amountOwnLikes = value;
    }

    /**
     * Gets the value of the amountSales property.
     * 
     */
    public int getAmountSales() {
        return amountSales;
    }

    /**
     * Sets the value of the amountSales property.
     * 
     */
    public void setAmountSales(int value) {
        this.amountSales = value;
    }

    /**
     * Gets the value of the idUser property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDUser() {
        return idUser;
    }

    /**
     * Sets the value of the idUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDUser(Integer value) {
        this.idUser = value;
    }

    /**
     * Gets the value of the mark property.
     * 
     */
    public int getMark() {
        return mark;
    }

    /**
     * Sets the value of the mark property.
     * 
     */
    public void setMark(int value) {
        this.mark = value;
    }

    /**
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link Users }
     *     
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link Users }
     *     
     */
    public void setUsers(Users value) {
        this.users = value;
    }

}
