package com.netcracker.ca.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netcracker.ca.model.Meeting;
import com.netcracker.ca.model.Team;
import com.netcracker.ca.service.MeetingService;

@RestController
public class MeetingController extends BaseApiController {

	@Autowired
	private MeetingService meetingService;

	@GetMapping({ "admin/api/project/{projectId}/meetings", "admin/api/project/{projectId}/meetings" })
	public List<Meeting> getProjectMeetings(@PathVariable int projectId) {
		return meetingService.getAllProjectMeetings(projectId);
	}

	@PostMapping("admin/api/project/{projectId}/meeting")
	public Meeting createForProject(@RequestBody Meeting meeting, @PathVariable int projectId) {
		meetingService.addToProject(meeting, projectId);
		return meeting;
	}
	
	@PostMapping("curator/api/meeting")
	public Meeting createForTeam(@RequestBody Meeting meeting, HttpSession session) {
		Team team = (Team) session.getAttribute("team");
		meetingService.addToTeam(meeting, team.getId());
		return meeting;
	}

	@PutMapping("/admin/api/meeting")
	public void update(@RequestBody Meeting meeting) {
		meetingService.update(meeting);
	}

	@DeleteMapping("/admin/api/meeting/{id}")
	public void delete(@PathVariable int id) {
		meetingService.delete(id);
	}

}