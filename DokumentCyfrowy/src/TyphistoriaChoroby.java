//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:24:20 PM CET 
//



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typhistoria_choroby complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typhistoria_choroby">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pacjent" type="{}typPacjent"/>
 *         &lt;element name="historia" type="{}typHistoria"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numer_karty" use="required" type="{}typNumer_karty" />
 *       &lt;attribute name="poradnia" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typhistoria_choroby", propOrder = {
    "pacjent",
    "historia"
})
public class TyphistoriaChoroby {

    @XmlElement(required = true)
    protected TypPacjent pacjent;
    @XmlElement(required = true)
    protected TypHistoria historia;
    @XmlAttribute(name = "numer_karty", required = true)
    protected int numerKarty;
    @XmlAttribute(name = "poradnia", required = true)
    protected String poradnia;

    /**
     * Gets the value of the pacjent property.
     * 
     * @return
     *     possible object is
     *     {@link TypPacjent }
     *     
     */
    public TypPacjent getPacjent() {
        return pacjent;
    }

    /**
     * Sets the value of the pacjent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypPacjent }
     *     
     */
    public void setPacjent(TypPacjent value) {
        this.pacjent = value;
    }

    /**
     * Gets the value of the historia property.
     * 
     * @return
     *     possible object is
     *     {@link TypHistoria }
     *     
     */
    public TypHistoria getHistoria() {
        return historia;
    }

    /**
     * Sets the value of the historia property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypHistoria }
     *     
     */
    public void setHistoria(TypHistoria value) {
        this.historia = value;
    }

    /**
     * Gets the value of the numerKarty property.
     * 
     */
    public int getNumerKarty() {
        return numerKarty;
    }

    /**
     * Sets the value of the numerKarty property.
     * 
     */
    public void setNumerKarty(int value) {
        this.numerKarty = value;
    }

    /**
     * Gets the value of the poradnia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoradnia() {
        return poradnia;
    }

    /**
     * Sets the value of the poradnia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoradnia(String value) {
        this.poradnia = value;
    }

}