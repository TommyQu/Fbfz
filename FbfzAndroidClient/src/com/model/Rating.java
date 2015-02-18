package com.model;

import java.util.Date;

public class Rating {
	private int shopid;
	private int userid;
	private int  rid;
	private String content;
	private Date creartetime;
	private double servicescore;
	private double envscore;
	private double transcore;
	private double featurescore;
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreartetime() {
		return creartetime;
	}
	public void setCreartetime(Date creartetime) {
		this.creartetime = creartetime;
	}
	public double getServicescore() {
		return servicescore;
	}
	public void setServicescore(double servicescore) {
		this.servicescore = servicescore;
	}
	public double getEnvscore() {
		return envscore;
	}
	public void setEnvscore(double envscore) {
		this.envscore = envscore;
	}
	public double getTranscore() {
		return transcore;
	}
	public void setTranscore(double transcore) {
		this.transcore = transcore;
	}
	public double getFeaturescore() {
		return featurescore;
	}
	public void setFeaturescore(double featurescore) {
		this.featurescore = featurescore;
	}
	

}
