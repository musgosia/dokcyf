//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:24:20 PM CET 
//




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typKrew complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typKrew">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grupa" type="{}typGrupa"/>
 *         &lt;element name="rh" type="{}typRh"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typKrew", propOrder = {
    "grupa",
    "rh"
})
public class TypKrew {

    @XmlElement(required = true)
    protected String grupa;
    @XmlElement(required = true)
    protected String rh;

    /**
     * Gets the value of the grupa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrupa() {
        return grupa;
    }

    /**
     * Sets the value of the grupa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrupa(String value) {
        this.grupa = value;
    }

    /**
     * Gets the value of the rh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRh() {
        return rh;
    }

    /**
     * Sets the value of the rh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRh(String value) {
        this.rh = value;
    }

}