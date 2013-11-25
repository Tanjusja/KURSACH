
package client.archive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for edit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="edit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="archiveProducts" type="{http://archive.ws/}archiveProducts" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edit", propOrder = {
    "archiveProducts"
})
public class Edit {

    protected ArchiveProducts archiveProducts;

    /**
     * Gets the value of the archiveProducts property.
     * 
     * @return
     *     possible object is
     *     {@link ArchiveProducts }
     *     
     */
    public ArchiveProducts getArchiveProducts() {
        return archiveProducts;
    }

    /**
     * Sets the value of the archiveProducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchiveProducts }
     *     
     */
    public void setArchiveProducts(ArchiveProducts value) {
        this.archiveProducts = value;
    }

}
