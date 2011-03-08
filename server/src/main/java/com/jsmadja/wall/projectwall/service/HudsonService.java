package com.jsmadja.wall.projectwall.service;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jsmadja.wall.hudsonclient.Hudson;
import com.jsmadja.wall.hudsonclient.HudsonBuildNotFoundException;
import com.jsmadja.wall.hudsonclient.HudsonProjectNotFoundException;
import com.jsmadja.wall.hudsonclient.domain.HudsonBuild;
import com.jsmadja.wall.hudsonclient.domain.HudsonProject;
import com.jsmadja.wall.projectwall.domain.Build;
import com.jsmadja.wall.projectwall.domain.Project;
import com.jsmadja.wall.projectwall.domain.QualityResult;

public class HudsonService implements Service {

    private static final Logger LOG = LoggerFactory.getLogger(HudsonService.class);

    private String url;
    private String login;
    private String password;

    private Hudson hudson;

    @Override
    public void init() {
        if (isBlank(url)) {
            throw new IllegalStateException("url can't be null.");
        }
        hudson = new Hudson(url);
    }

    @Override
    public List<Project> findAllProjects() {
        List<Project> projects = new ArrayList<Project>();
        for(HudsonProject hudsonProject:hudson.findAllProjects()) {
            Project project;
            try {
                project = createProject(hudsonProject);
                projects.add(project);
            } catch (HudsonProjectNotFoundException e) {
                LOG.warn(e.getMessage(), e);
            }
        }
        return projects;
    }

    @Override
    public Project findProjectByName(String projectName) throws ProjectNotFoundException {
        try {
            HudsonProject hudsonProject = hudson.findProject(projectName);
            return createProject(hudsonProject);
        } catch(HudsonProjectNotFoundException e) {
            throw new ProjectNotFoundException(e);
        }
    }

    @Override
    public void populate(Project project) throws ProjectNotFoundException {
        try {
            HudsonProject hudsonProject = hudson.findProject(project.getName());
            project.setHudsonProject(hudsonProject);
        } catch (HudsonProjectNotFoundException e) {
            throw new ProjectNotFoundException(e);
        }
    }

    private Project createProject(HudsonProject hudsonProject) throws HudsonProjectNotFoundException {
        Project project = new Project();
        project.setName(hudsonProject.getName());
        project.setDescription(hudsonProject.getDescription());
        project.setId(hudsonProject.getArtifactId());
        project.setHudsonProject(hudsonProject);
        return project;
    }

    @Override
    public Date getEstimatedFinishTime(Project project) throws ProjectNotFoundException {
        try {
            return hudson.getEstimatedFinishTime(project.getName());
        } catch (HudsonProjectNotFoundException e) {
            throw new ProjectNotFoundException(e);
        }
    }

    @Override
    public Build findBuildByProjectNameAndBuildNumber(String projectName, int buildNumber) throws BuildNotFoundException {
        try {
            return createBuild(hudson.findBuild(projectName, buildNumber));
        } catch (HudsonBuildNotFoundException e) {
            throw new BuildNotFoundException(e);
        }
    }

    private Build createBuild(HudsonBuild hudsonBuild) {
        Build build = new Build();
        build.setCommiters(hudsonBuild.getCommiters());
        build.setDuration(hudsonBuild.getDuration());
        build.setStartTime(hudsonBuild.getStartTime());
        build.setSuccessful(hudsonBuild.isSuccessful());
        build.setTestResult(hudsonBuild.getTestResult());
        return build;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void populateQuality(Project project, QualityResult quality) throws ProjectNotFoundException {
        throw new ProjectNotFoundException("populateQuality is not implemented in HudsonService");
    }

}
