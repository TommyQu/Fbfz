package com.softfz.model;

import java.util.Date;

public class Appraise {
	private int appid=-1;
	private String content="";
	private Date apptime;
	private int servicescore=0;
	private int environmentscore=0;
	private int transportscore=0;
	private int featurescore=0;
	private String membername="";
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getApptime() {
		return apptime;
	}
	public void setApptime(Date apptime) {
		this.apptime = apptime;
	}
	public int getServicescore() {
		return servicescore;
	}
	public void setServicescore(int servicescore) {
		this.servicescore = servicescore;
	}
	public int getEnvironmentscore() {
		return environmentscore;
	}
	public void setEnvironmentscore(int environmentscore) {
		this.environmentscore = environmentscore;
	}
	public int getTransportscore() {
		return transportscore;
	}
	public void setTransportscore(int transportscore) {
		this.transportscore = transportscore;
	}
	public int getFeaturescore() {
		return featurescore;
	}
	public void setFeaturescore(int featurescore) {
		this.featurescore = featurescore;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	

}
