//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:24:20 PM CET 
//



import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for typPacjent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typPacjent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nazwisko" type="{}typNazwisko"/>
 *         &lt;element name="imie" type="{}typImie"/>
 *         &lt;element name="plec" type="{}typPlec"/>
 *         &lt;element name="data_urodzenia" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="adres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="data_rejestracji" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="nr_ksiazeczki_zdrowia" type="{}typNr_ksiazeczki_zdrowia"/>
 *         &lt;element name="ubezpieczenie" type="{}typUbezpieczenie"/>
 *         &lt;element name="krew" type="{}typKrew" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pesel" use="required" type="{}typPesel" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typPacjent", propOrder = {
    "nazwisko",
    "imie",
    "plec",
    "dataUrodzenia",
    "adres",
    "dataRejestracji",
    "nrKsiazeczkiZdrowia",
    "ubezpieczenie",
    "krew"
})
public class TypPacjent {

    @XmlElement(required = true)
    protected String nazwisko;
    @XmlElement(required = true)
    protected String imie;
    @XmlElement(required = true)
    protected String plec;
    @XmlElement(name = "data_urodzenia", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataUrodzenia;
    @XmlElement(required = true)
    protected String adres;
    @XmlElement(name = "data_rejestracji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataRejestracji;
    @XmlElement(name = "nr_ksiazeczki_zdrowia", required = true)
    protected String nrKsiazeczkiZdrowia;
    @XmlElement(required = true)
    protected TypUbezpieczenie ubezpieczenie;
    protected TypKrew krew;
    @XmlAttribute(name = "pesel", required = true)
    protected BigInteger pesel;

    /**
     * Gets the value of the nazwisko property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Sets the value of the nazwisko property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazwisko(String value) {
        this.nazwisko = value;
    }

    /**
     * Gets the value of the imie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets the value of the imie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImie(String value) {
        this.imie = value;
    }

    /**
     * Gets the value of the plec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlec() {
        return plec;
    }

    /**
     * Sets the value of the plec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlec(String value) {
        this.plec = value;
    }

    /**
     * Gets the value of the dataUrodzenia property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataUrodzenia() {
        return dataUrodzenia;
    }

    /**
     * Sets the value of the dataUrodzenia property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataUrodzenia(XMLGregorianCalendar value) {
        this.dataUrodzenia = value;
    }

    /**
     * Gets the value of the adres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdres() {
        return adres;
    }

    /**
     * Sets the value of the adres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdres(String value) {
        this.adres = value;
    }

    /**
     * Gets the value of the dataRejestracji property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRejestracji() {
        return dataRejestracji;
    }

    /**
     * Sets the value of the dataRejestracji property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRejestracji(XMLGregorianCalendar value) {
        this.dataRejestracji = value;
    }

    /**
     * Gets the value of the nrKsiazeczkiZdrowia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrKsiazeczkiZdrowia() {
        return nrKsiazeczkiZdrowia;
    }

    /**
     * Sets the value of the nrKsiazeczkiZdrowia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrKsiazeczkiZdrowia(String value) {
        this.nrKsiazeczkiZdrowia = value;
    }

    /**
     * Gets the value of the ubezpieczenie property.
     * 
     * @return
     *     possible object is
     *     {@link TypUbezpieczenie }
     *     
     */
    public TypUbezpieczenie getUbezpieczenie() {
        return ubezpieczenie;
    }

    /**
     * Sets the value of the ubezpieczenie property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypUbezpieczenie }
     *     
     */
    public void setUbezpieczenie(TypUbezpieczenie value) {
        this.ubezpieczenie = value;
    }

    /**
     * Gets the value of the krew property.
     * 
     * @return
     *     possible object is
     *     {@link TypKrew }
     *     
     */
    public TypKrew getKrew() {
        return krew;
    }

    /**
     * Sets the value of the krew property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypKrew }
     *     
     */
    public void setKrew(TypKrew value) {
        this.krew = value;
    }

    /**
     * Gets the value of the pesel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPesel() {
        return pesel;
    }

    /**
     * Sets the value of the pesel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPesel(BigInteger value) {
        this.pesel = value;
    }

}
