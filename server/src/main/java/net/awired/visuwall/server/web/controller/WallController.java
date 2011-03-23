package net.awired.visuwall.server.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.awired.visuwall.api.domain.Project;
import net.awired.visuwall.api.domain.ProjectStatus;
import net.awired.visuwall.server.domain.Wall;
import net.awired.visuwall.server.service.WallService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wall")
public class WallController {

	private static final Logger LOG = LoggerFactory.getLogger(WallController.class.getName());
	private static final String WALL_JSP = "wall/wall";

	@Autowired
	private WallService wallService;

	@RequestMapping
	public @ResponseBody Set<String> getWallNames() {
		return wallService.getWallNames();
	}

    @RequestMapping("{wallName}")
    public @ResponseBody Wall getProjects(@PathVariable String wallName) {
    	Wall wall = wallService.getWall(wallName);
        LOG.info("Projects collection size :" + wall.getProjects().size());
        return wall;
    }
	
    @RequestMapping("{wallName}/status")
    public @ResponseBody List<ProjectStatus> getStatus(@PathVariable String wallName) {
        return wallService.getStatus(wallName);
    }


	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String getCreate() {
		return WALL_JSP;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create() {
		return null;
	}

}
