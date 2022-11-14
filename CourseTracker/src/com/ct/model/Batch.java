package com.ct.model;

public class Batch {

	private String batchid;
	private String courseid;
	private String facultyifid;
	private String numberOfStudents;
	private String batchStartDate;
	private String duration;
	public Batch(String batchid, String courseid, String facultyifid, String numberOfStudents, String batchStartDate,
			String duration) {
		super();
		this.batchid = batchid;
		this.courseid = courseid;
		this.facultyifid = facultyifid;
		this.numberOfStudents = numberOfStudents;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getFacultyifid() {
		return facultyifid;
	}
	public void setFacultyifid(String facultyifid) {
		this.facultyifid = facultyifid;
	}
	public String getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(String numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	public String getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(String batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Batch [batchid=" + batchid + ", courseid=" + courseid + ", facultyifid=" + facultyifid
				+ ", numberOfStudents=" + numberOfStudents + ", batchStartDate=" + batchStartDate + ", duration="
				+ duration + "]";
	}
	public Batch(String batchid, String courseid, String numberOfStudents, String batchStartDate, String duration) {
		super();
		this.batchid = batchid;
		this.courseid = courseid;
		this.numberOfStudents = numberOfStudents;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}
	
	
	
}
