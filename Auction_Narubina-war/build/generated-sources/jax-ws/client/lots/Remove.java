
package client.lots;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for remove complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="remove">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lot" type="{http://lots.ws/}lot" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remove", propOrder = {
    "lot"
})
public class Remove {

    protected Lot lot;

    /**
     * Gets the value of the lot property.
     * 
     * @return
     *     possible object is
     *     {@link Lot }
     *     
     */
    public Lot getLot() {
        return lot;
    }

    /**
     * Sets the value of the lot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lot }
     *     
     */
    public void setLot(Lot value) {
        this.lot = value;
    }

}
