/**
 *     Copyright (C) 2010 Julien SMADJA <julien dot smadja at gmail dot com> - Arnaud LEMAIRE <alemaire at norad dot fr>
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package net.awired.visuwall.plugin.sonar.tck;

import static net.awired.visuwall.IntegrationTestData.SONAR_URL;
import static net.awired.visuwall.IntegrationTestData.STRUTS_ARTIFACT_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Map.Entry;
import java.util.Set;
import net.awired.visuwall.api.domain.SoftwareProjectId;
import net.awired.visuwall.api.domain.TestResult;
import net.awired.visuwall.api.domain.quality.QualityMeasure;
import net.awired.visuwall.api.domain.quality.QualityResult;
import net.awired.visuwall.api.exception.ConnectionException;
import net.awired.visuwall.api.plugin.capability.MetricCapability;
import net.awired.visuwall.api.plugin.tck.MetricCapabilityTCK;
import net.awired.visuwall.plugin.sonar.SonarConnection;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SonarMetricCapabilityIT implements MetricCapabilityTCK {

    private static MetricCapability sonar = new SonarConnection();

    @BeforeClass
    public static void init() throws ConnectionException {
        sonar.connect(SONAR_URL, null, null);
    }

    @Test
    public void should_populate_quality() {
        SoftwareProjectId projectId = struts();
        QualityResult quality = sonar.analyzeQuality(projectId, "violations_density");
        QualityMeasure measure = quality.getMeasure("violations_density");
        assertEquals("Rules compliance", measure.getName());
        assertEquals("83.9%", measure.getFormattedValue());
        assertEquals(83.9, measure.getValue(), 0);
    }

    @Test
    public void should_have_a_lot_of_quality_metrics() {
        SoftwareProjectId projectId = struts();
        QualityResult quality = sonar.analyzeQuality(projectId);
        Set<Entry<String, QualityMeasure>> measures = quality.getMeasures();
        for (Entry<String, QualityMeasure> measure : measures) {
            assertNotNull(measure.getValue().getValue());
        }
    }

    @Test
    public void should_not_fail_if_measure_does_not_exist() {
        SoftwareProjectId projectId = struts();
        sonar.analyzeQuality(projectId, "inexistant_measure");
    }

    @Test
    public void should_count_exact_it_and_ut() {
        SoftwareProjectId projectId = librestry();

        SonarConnection sonarPlugin = new SonarConnection();
        sonarPlugin.connect("http://fluxx.fr.cr:9000");
        TestResult unitTestsAnalysis = sonarPlugin.analyzeUnitTests(projectId);
        assertEquals(18.4, unitTestsAnalysis.getCoverage(), 0);
        assertEquals(1, unitTestsAnalysis.getFailCount());
        assertEquals(5, unitTestsAnalysis.getSkipCount());
        assertEquals(3, unitTestsAnalysis.getPassCount());
        assertEquals(9, unitTestsAnalysis.getTotalCount());

        TestResult integrationTestsAnalysis = sonarPlugin.analyzeIntegrationTests(projectId);
        assertEquals(47.4, integrationTestsAnalysis.getCoverage(), 0);
        // Sonar/Jacoco don't count IT tests
        assertEquals(0, integrationTestsAnalysis.getFailCount());
        assertEquals(0, integrationTestsAnalysis.getSkipCount());
        assertEquals(0, integrationTestsAnalysis.getPassCount());
        assertEquals(0, integrationTestsAnalysis.getTotalCount());
    }

    @Override
    @Test
    @Ignore
    public void should_analyze_quality_with_all_metrics() {
        // TODO Auto-generated method stub

    }

    @Override
    @Test
    @Ignore
    public void should_analyze_quality_with_only_3_metrics() {
    }

    @Override
    @Test
    @Ignore
    public void should_get_metrics_by_category() {
        // TODO Auto-generated method stub

    }

    private SoftwareProjectId librestry() {
        return new SoftwareProjectId("fr.xebia.librestry:librestry");
    }

    private SoftwareProjectId struts() {
        return new SoftwareProjectId(STRUTS_ARTIFACT_ID);
    }

}