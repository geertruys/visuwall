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

package net.awired.visuwall.api.plugin.capability;

import net.awired.visuwall.api.domain.ProjectId;
import net.awired.visuwall.api.domain.SoftwareProjectId;
import net.awired.visuwall.api.domain.TestResult;

public interface TestCapability extends BasicCapability {

    /**
     * Generate the unit tests reporting
     * 
     * @param projectId
     * @return
     */
    @Deprecated
    TestResult analyzeUnitTests(ProjectId projectId);

    /**
     * Generate the integration tests reporting
     * 
     * @param projectId
     * @return
     */
    @Deprecated
    TestResult analyzeIntegrationTests(ProjectId projectId);

    /**
     * Generate the unit tests reporting
     * 
     * @param projectId
     * @return
     */
    TestResult analyzeUnitTests(SoftwareProjectId projectId);

    /**
     * Generate the integration tests reporting
     * 
     * @param projectId
     * @return
     */
    TestResult analyzeIntegrationTests(SoftwareProjectId projectId);

}