/**
 * Copyright (C) 2010 Julien SMADJA <julien.smadja@gmail.com> - Arnaud LEMAIRE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.20 at 04:00:50 PM CET 
//


package net.awired.visuwall.hudsonclient.generated.hudson.surefireaggregatedreport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jsmadja.wall.projectwall.generated.hudson.surefireaggregatedreport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SurefireAggregatedReport_QNAME = new QName("", "SurefireAggregatedReport");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jsmadja.wall.projectwall.generated.hudson.surefireaggregatedreport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HudsonTasksTestAggregatedTestResultAction }
     * 
     */
    public HudsonTasksTestAggregatedTestResultAction createHudsonTasksTestAggregatedTestResultAction() {
        return new HudsonTasksTestAggregatedTestResultAction();
    }

    /**
     * Create an instance of {@link HudsonTasksTestAbstractTestResultAction }
     * 
     */
    public HudsonTasksTestAbstractTestResultAction createHudsonTasksTestAbstractTestResultAction() {
        return new HudsonTasksTestAbstractTestResultAction();
    }

    /**
     * Create an instance of {@link HudsonModelActionable }
     * 
     */
    public HudsonModelActionable createHudsonModelActionable() {
        return new HudsonModelActionable();
    }

    /**
     * Create an instance of {@link HudsonScmChangeLogSet }
     * 
     */
    public HudsonScmChangeLogSet createHudsonScmChangeLogSet() {
        return new HudsonScmChangeLogSet();
    }

    /**
     * Create an instance of {@link HudsonMavenReportersSurefireAggregatedReport }
     * 
     */
    public HudsonMavenReportersSurefireAggregatedReport createHudsonMavenReportersSurefireAggregatedReport() {
        return new HudsonMavenReportersSurefireAggregatedReport();
    }

    /**
     * Create an instance of {@link HudsonModelRun }
     * 
     */
    public HudsonModelRun createHudsonModelRun() {
        return new HudsonModelRun();
    }

    /**
     * Create an instance of {@link HudsonModelUserProperty }
     * 
     */
    public HudsonModelUserProperty createHudsonModelUserProperty() {
        return new HudsonModelUserProperty();
    }

    /**
     * Create an instance of {@link HudsonModelUser }
     * 
     */
    public HudsonModelUser createHudsonModelUser() {
        return new HudsonModelUser();
    }

    /**
     * Create an instance of {@link HudsonTasksTestAggregatedTestResultActionChildReport }
     * 
     */
    public HudsonTasksTestAggregatedTestResultActionChildReport createHudsonTasksTestAggregatedTestResultActionChildReport() {
        return new HudsonTasksTestAggregatedTestResultActionChildReport();
    }

    /**
     * Create an instance of {@link HudsonModelAbstractBuild }
     * 
     */
    public HudsonModelAbstractBuild createHudsonModelAbstractBuild() {
        return new HudsonModelAbstractBuild();
    }

    /**
     * Create an instance of {@link HudsonModelRunArtifact }
     * 
     */
    public HudsonModelRunArtifact createHudsonModelRunArtifact() {
        return new HudsonModelRunArtifact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HudsonMavenReportersSurefireAggregatedReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SurefireAggregatedReport")
    public JAXBElement<HudsonMavenReportersSurefireAggregatedReport> createSurefireAggregatedReport(HudsonMavenReportersSurefireAggregatedReport value) {
        return new JAXBElement<HudsonMavenReportersSurefireAggregatedReport>(_SurefireAggregatedReport_QNAME, HudsonMavenReportersSurefireAggregatedReport.class, null, value);
    }

}
