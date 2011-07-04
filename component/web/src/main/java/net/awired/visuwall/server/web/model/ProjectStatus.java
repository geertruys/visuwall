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

package net.awired.visuwall.server.web.model;

import java.util.Date;
import net.awired.visuwall.core.business.domain.Project;
import com.google.common.base.Objects;

public final class ProjectStatus {
    private final String id;
    private boolean building;
    private int buildingTimeleftSecond;
    private int lastBuildId;
    private Date lastUpdate;

    public ProjectStatus(Project project) {
        this.id = project.getId();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", id) //
                .add("lastBuildId", lastBuildId) //
                .add("building", building) //
                .add("buildingTimeleft", buildingTimeleftSecond) //
                .toString();
    }

    public boolean isBuilding() {
        return building;
    }

    public void setBuilding(boolean building) {
        this.building = building;
    }

    public int getLastBuildId() {
        return lastBuildId;
    }

    public void setLastBuildId(int lastBuildId) {
        this.lastBuildId = lastBuildId;
    }

    public String getId() {
        return id;
    }

    public void setBuildingTimeleftSecond(int buildingTimeleftSecond) {
        this.buildingTimeleftSecond = buildingTimeleftSecond;
    }

    public int getBuildingTimeleftSecond() {
        return buildingTimeleftSecond;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
