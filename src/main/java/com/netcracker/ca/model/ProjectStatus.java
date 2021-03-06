package com.netcracker.ca.model;

public class ProjectStatus {

	private int id;

	private String description;

	public ProjectStatus() {
	}

	public ProjectStatus(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectStatus other = (ProjectStatus) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("ProjectStatus");
		return builder
			.append(" [id=").append(id)
			.append(", description=").append(description)
			.append("]").toString();
	}
}