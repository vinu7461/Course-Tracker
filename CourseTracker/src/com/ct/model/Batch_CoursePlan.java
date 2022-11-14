package com.ct.model;

import javax.management.loading.PrivateClassLoader;

public class Batch_CoursePlan {

	private String batchid;
	private int daynumber;
	private String topic;
	private String status;
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public int getDaynumber() {
		return daynumber;
	}
	public void setDaynumber(int daynumber) {
		this.daynumber = daynumber;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Batch_CoursePlan(String batchid, int daynumber, String topic, String status) {
		super();
		this.batchid = batchid;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Batch_CoursePlan [batchid=" + batchid + ", daynumber=" + daynumber + ", topic=" + topic + ", status="
				+ status + "]";
	}
	
	
	
}
