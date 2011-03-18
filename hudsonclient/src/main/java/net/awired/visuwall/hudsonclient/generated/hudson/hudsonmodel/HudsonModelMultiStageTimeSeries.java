//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.21 at 12:25:24 PM CET 
//


package net.awired.visuwall.hudsonclient.generated.hudson.hudsonmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hudson.model.MultiStageTimeSeries complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hudson.model.MultiStageTimeSeries">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hour" type="{}hudson.model.TimeSeries" minOccurs="0"/>
 *         &lt;element name="min" type="{}hudson.model.TimeSeries" minOccurs="0"/>
 *         &lt;element name="sec10" type="{}hudson.model.TimeSeries" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hudson.model.MultiStageTimeSeries", propOrder = {
    "hour",
    "min",
    "sec10"
})
public class HudsonModelMultiStageTimeSeries {

    protected HudsonModelTimeSeries hour;
    protected HudsonModelTimeSeries min;
    protected HudsonModelTimeSeries sec10;

    /**
     * Gets the value of the hour property.
     * 
     * @return
     *     possible object is
     *     {@link HudsonModelTimeSeries }
     *     
     */
    public HudsonModelTimeSeries getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     * 
     * @param value
     *     allowed object is
     *     {@link HudsonModelTimeSeries }
     *     
     */
    public void setHour(HudsonModelTimeSeries value) {
        this.hour = value;
    }

    /**
     * Gets the value of the min property.
     * 
     * @return
     *     possible object is
     *     {@link HudsonModelTimeSeries }
     *     
     */
    public HudsonModelTimeSeries getMin() {
        return min;
    }

    /**
     * Sets the value of the min property.
     * 
     * @param value
     *     allowed object is
     *     {@link HudsonModelTimeSeries }
     *     
     */
    public void setMin(HudsonModelTimeSeries value) {
        this.min = value;
    }

    /**
     * Gets the value of the sec10 property.
     * 
     * @return
     *     possible object is
     *     {@link HudsonModelTimeSeries }
     *     
     */
    public HudsonModelTimeSeries getSec10() {
        return sec10;
    }

    /**
     * Sets the value of the sec10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link HudsonModelTimeSeries }
     *     
     */
    public void setSec10(HudsonModelTimeSeries value) {
        this.sec10 = value;
    }

}
