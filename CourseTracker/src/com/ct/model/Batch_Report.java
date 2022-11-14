package com.ct.model;

public class Batch_Report {

	private String batchid;
	private String courseName;
	private String facultyName;
	private int noOfStudents;
	private String batchStartDate;
	private int totalDaysGenerated;
	private double completionpercentage;
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public String getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(String batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	public int getTotalDaysGenerated() {
		return totalDaysGenerated;
	}
	public void setTotalDaysGenerated(int totalDaysGenerated) {
		this.totalDaysGenerated = totalDaysGenerated;
	}
	public double getCompletionpercentage() {
		return completionpercentage;
	}
	public void setCompletionpercentage(double completionpercentage) {
		this.completionpercentage = completionpercentage;
	}
	public Batch_Report(String batchid, String courseName, String facultyName, int noOfStudents, String batchStartDate,
			int totalDaysGenerated, double completionpercentage) {
		super();
		this.batchid = batchid;
		this.courseName = courseName;
		this.facultyName = facultyName;
		this.noOfStudents = noOfStudents;
		this.batchStartDate = batchStartDate;
		this.totalDaysGenerated = totalDaysGenerated;
		this.completionpercentage = completionpercentage;
	}
	@Override
	public String toString() {
		return "Batch_Report [batchid=" + batchid + ", courseName=" + courseName + ", facultyName=" + facultyName
				+ ", noOfStudents=" + noOfStudents + ", batchStartDate=" + batchStartDate + ", totalDaysGenerated="
				+ totalDaysGenerated + ", completionpercentage=" + completionpercentage + "]";
	}
	
	
	
	
}

