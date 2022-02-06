package com.sample.model;

import java.util.Date;

public class Task {
	private int id;
	private String person;
	private Date deadline;
	private String detail;
	private Boolean isComplete;
	
	public Task(int id, String person, Date deadline, String detail, Boolean isComplete) {
		super();
		this.id = id;
		this.person = person;
		this.deadline = deadline;
		this.detail = detail;
		this.isComplete = isComplete;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", person=" + person + ", deadline=" + deadline + ", detail=" + detail
				+ ", isComplete=" + isComplete + "]";
	}
	
}
