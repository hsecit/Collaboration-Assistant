package com.netcracker.ca.service;

import java.util.List;

import com.netcracker.ca.model.Meeting;

/**
 * Created by Oleksandr on 12.11.2016.
 */
public interface MeetingService {
	
	Meeting getById(int id);
	
    void addToProject(Meeting meeting, int projectId);
    
    void addToTeam(Meeting meeting, int teamId);

    void update(Meeting meeting);

    void delete(int id);

    List<Meeting> getAllTeamMeetings(int id);

    List<Meeting> getAllProjectMeetings(int id);
    
    boolean belongsToTeam(int meetingId, int teamId);
    
    boolean belongsToProject(int meetingId, int projectId);
    
    void setAttendance(int meetingId, int studentId, boolean isPresent);
    
    boolean getAttendance(int meetingId, int studentId);
}
