package com.netcracker.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcracker.ca.service.ProjectService;

@Controller
@RequestMapping("hr")
public class HRController extends BaseController {

    	@Autowired
	private ProjectService projectService;
    
    	@RequestMapping("")
	public String projects() {
		// TODO "hrProjects"
		return "hrProjects";
	}
	
	@GetMapping("project/{projectId}")
	public String project(@PathVariable int projectId, Model model) {
		model.addAttribute("project", projectService.getByIdWithTeams(projectId));
		return "hrProjectTeams";
	}
	
	@GetMapping("project/{projectId}/team/{teamId}/meetings")
	public String projectMeetings(@PathVariable("projectId") int projectId,@PathVariable("teamId") int teamId, Model model) {
		model.addAttribute("project", projectService.getByIdWithTeams(projectId));
		model.addAttribute("teamId", teamId);
		return "hrMeetings";
	}
	
	@RequestMapping(value = "/hrFeedback/{app_form_id}",  method = RequestMethod.GET)
	public String curFilesPage(@PathVariable("app_form_id") int app_form_id, Model model) {
		model.addAttribute("app_form_id", 1);
		return "hrFeedback";
	}

	@GetMapping("project/{projectId}/meetings")
	public String projectMeetings(@PathVariable int projectId, Model model) {
		model.addAttribute("project", projectService.getByIdWithTeams(projectId));
		return "hrMeetings";
	}

}

