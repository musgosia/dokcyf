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
 * <p>Java class for typUbezpieczenie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typUbezpieczenie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ubezpieczony_status" type="{}typTStatus"/>
 *         &lt;element name="nieubezpieczony_status" type="{}typNStatus"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typUbezpieczenie", propOrder = {
    "ubezpieczonyStatus",
    "nieubezpieczonyStatus"
})
public class TypUbezpieczenie {

    @XmlElement(name = "ubezpieczony_status")
    protected TypTStatus ubezpieczonyStatus;
    @XmlElement(name = "nieubezpieczony_status")
    protected String nieubezpieczonyStatus;

    /**
     * Gets the value of the ubezpieczonyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TypTStatus }
     *     
     */
    public TypTStatus getUbezpieczonyStatus() {
        return ubezpieczonyStatus;
    }

    /**
     * Sets the value of the ubezpieczonyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypTStatus }
     *     
     */
    public void setUbezpieczonyStatus(TypTStatus value) {
        this.ubezpieczonyStatus = value;
    }

    /**
     * Gets the value of the nieubezpieczonyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNieubezpieczonyStatus() {
        return nieubezpieczonyStatus;
    }

    /**
     * Sets the value of the nieubezpieczonyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNieubezpieczonyStatus(String value) {
        this.nieubezpieczonyStatus = value;
    }

}