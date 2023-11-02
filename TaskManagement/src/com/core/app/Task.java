package com.core.app;

import java.time.LocalDate;

public class Task {
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", status=" + status + ", isActive=" + isActive + "]";
	}
	static int IDGenerator=1;
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private TaskStatus status;
	boolean isActive;
	public Task( String taskName, String description, LocalDate taskDate) {
		
		this.taskId =IDGenerator++;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = TaskStatus.PENDING;
		this.isActive = true;
	}
	public int getTaskId() {
		return taskId;
	}

	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

}
