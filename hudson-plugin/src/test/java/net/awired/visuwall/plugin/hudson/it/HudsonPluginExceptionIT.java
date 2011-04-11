package net.awired.visuwall.plugin.hudson.it;

import static net.awired.visuwall.plugin.hudson.it.IntegrationTestData.HUDSON_ID;
import net.awired.visuwall.api.domain.Project;
import net.awired.visuwall.api.domain.ProjectId;
import net.awired.visuwall.api.exception.BuildNotFoundException;
import net.awired.visuwall.api.exception.ProjectNotFoundException;
import net.awired.visuwall.plugin.hudson.HudsonPlugin;

import org.junit.BeforeClass;
import org.junit.Test;

public class HudsonPluginExceptionIT {

    static HudsonPlugin hudsonPlugin = new HudsonPlugin();

    @BeforeClass
    public static void init() {
        hudsonPlugin.setUrl(IntegrationTestData.HUDSON_URL);
        hudsonPlugin.init();
    }

    @Test(expected=BuildNotFoundException.class)
    public void should_throw_exception_when_searching_inexistant_build() throws BuildNotFoundException, ProjectNotFoundException {
        ProjectId projectId = new ProjectId();
        projectId.addId(HUDSON_ID, "");
        hudsonPlugin.findBuildByBuildNumber(projectId, 0);
    }

    @Test(expected=ProjectNotFoundException.class)
    public void should_throw_exception_when_searching_inexistant_project() throws ProjectNotFoundException {
        ProjectId projectId = new ProjectId();
        projectId.addId(HUDSON_ID, "");
        hudsonPlugin.findProject(projectId);
    }

    @Test(expected=ProjectNotFoundException.class)
    public void should_throw_exception_when_searching_estimated_finish_time_of_inexistant_project() throws ProjectNotFoundException {
        ProjectId projectId = new ProjectId();
        projectId.addId(HUDSON_ID, "");
        hudsonPlugin.getEstimatedFinishTime(projectId);
    }

    @Test(expected=ProjectNotFoundException.class)
    public void should_throw_exception_when_searching_last_build_number_of_inexistant_project() throws BuildNotFoundException, ProjectNotFoundException {
        ProjectId projectId = new ProjectId();
        projectId.addId(HUDSON_ID, "");
        hudsonPlugin.getLastBuildNumber(projectId);
    }

    @Test(expected=ProjectNotFoundException.class)
    public void should_throw_exception_when_searching_is_building_of_inexistant_project() throws ProjectNotFoundException {
        ProjectId projectId = new ProjectId();
        projectId.addId(HUDSON_ID, "");
        hudsonPlugin.isBuilding(projectId);
    }

    @Test(expected=ProjectNotFoundException.class)
    public void should_throw_exception_when_populating_inexistant_project() throws ProjectNotFoundException {
        Project project = new Project();
        project.setName("");
        hudsonPlugin.populate(project);
    }
}