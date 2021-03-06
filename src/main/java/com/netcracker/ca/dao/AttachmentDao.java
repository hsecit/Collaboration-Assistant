package com.netcracker.ca.dao;

import java.util.List;

import com.netcracker.ca.model.Attachment;

public interface AttachmentDao {
	
	void addToProject(Attachment attachment, int projectId);
	
	void addToTeam(Attachment attachment, int teamId);
	
	Attachment getById(int id);
	
	void delete(int id);
	
	List<Attachment> getTeamAttachments(int teamId);
	
	List<Attachment> getProjectAttachments(int projectId);
	
	Attachment getByLinkForTeam(String link, int teamId);
	
	Attachment getByLinkForProject(String link, int projectId);
	
}