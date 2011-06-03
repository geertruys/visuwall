/**
 * Copyright (C) 2010 Julien SMADJA <julien dot smadja at gmail dot com> - Arnaud LEMAIRE <alemaire at norad dot fr>
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

package net.awired.visuwall.hudsonclient.helper;

import java.util.List;

import net.awired.visuwall.hudsonclient.generated.hudson.mavenmodulesetbuild.HudsonMavenMavenModuleSetBuild;
import net.awired.visuwall.hudsonclient.generated.hudson.mavenmodulesetbuild.HudsonModelUser;

import org.w3c.dom.Node;

public class HudsonXmlHelper {

    public static boolean isSuccessful(HudsonMavenMavenModuleSetBuild job) {
        Node element = (org.w3c.dom.Element) job.getResult();
        if (element == null) {
            return false;
        }
        Node result = element.getFirstChild();
        if (result == null) {
            return false;
        }
        return "SUCCESS".equals(result.getNodeValue());
    }

    public static String[] getCommiters(HudsonMavenMavenModuleSetBuild setBuild) {
        List<HudsonModelUser> users = setBuild.getCulprit();
        String[] commiters = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            commiters[i] = users.get(i).getFullName();
        }
        return commiters;
    }

    public static String getProjectName(Node element) {
        return element.getFirstChild().getFirstChild().getNodeValue();
    }

    public static String getState(HudsonMavenMavenModuleSetBuild setBuild) {
        if (setBuild == null) {
            return "NEW";
        }
        org.w3c.dom.Element element = (org.w3c.dom.Element) setBuild.getResult();
        if (element == null) {
            return "NEW";
        }

        return element.getFirstChild().getNodeValue();
    }
}
