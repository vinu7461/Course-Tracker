package com.ct.model;

public class Course {

	private int courseid;
	private String courseName;
	private int fee;
	private String Description;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Course(String courseName, int fee, String description) {
		super();
		this.courseName = courseName;
		this.fee = fee;
		Description = description;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", courseName=" + courseName + ", fee=" + fee + ", Description="
				+ Description + "]";
	}
	public Course(int courseid, String courseName, int fee, String description) {
		super();
		this.courseid = courseid;
		this.courseName = courseName;
		this.fee = fee;
		Description = description;
	}
	
	
	
}

