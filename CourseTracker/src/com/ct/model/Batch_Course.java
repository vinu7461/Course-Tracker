package com.ct.model;

public class Batch_Course {

	private String batchId;
	private int CourseId;
	private String CourseName;
	private int FacultyId;
	private int TotalStudents;
	private String StartDate;
	private int Duration;
	public Batch_Course(String batchId, int courseId, String courseName, int facultyId, int totalStudents,
			String startDate, int duration) {
		super();
		this.batchId = batchId;
		CourseId = courseId;
		CourseName = courseName;
		FacultyId = facultyId;
		TotalStudents = totalStudents;
		StartDate = startDate;
		Duration = duration;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getFacultyId() {
		return FacultyId;
	}
	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}
	public int getTotalStudents() {
		return TotalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		TotalStudents = totalStudents;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	@Override
	public String toString() {
		return "Batch_Course [batchId=" + batchId + ", CourseId=" + CourseId + ", CourseName=" + CourseName
				+ ", FacultyId=" + FacultyId + ", TotalStudents=" + TotalStudents + ", StartDate=" + StartDate
				+ ", Duration=" + Duration + "]";
	}
	
	
	
}

