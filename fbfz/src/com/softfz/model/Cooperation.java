package com.softfz.model;

import java.util.Date;
/**
 * 联盟商家实体类
 * @author Administrator
 *
 */
public class Cooperation {
	private int shopid;
	private Integer areaid;
	private Integer typeid;
	private String shoppic;
	private String shopname;
	private int viplevel;
	private String telphone;
	private String mobileno;
	private String address;
	private String description;
	private String longitude;
	private String latitude;
	private Date createtime;
	private Date viptime;
	private int countnum;
	private int keepnum;
	private double servicescore;
	private double envscore;
	private double transcore;
	private double featurescore;
	private double totalscore;
	private int comments;
	private int state;
	private String typename;
	private String areaname;
	private Integer bigtypeid;
	private Integer bigareaid;
	
	public String getViplevelName(){
		switch (viplevel) {
		case 1:
			return "普通商家";
		case 2:
			return "白银VIP";
		case 3:
			return "白金VIP";
		case 4:
			return "钻石VIP";
		default:
			return "未知";
		}
	}
	
	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getShoppic() {
		return shoppic;
	}

	public void setShoppic(String shoppic) {
		this.shoppic = shoppic;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public int getViplevel() {
		return viplevel;
	}

	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getViptime() {
		return viptime;
	}

	public void setViptime(Date viptime) {
		this.viptime = viptime;
	}

	public int getCountnum() {
		return countnum;
	}

	public void setCountnum(int countnum) {
		this.countnum = countnum;
	}

	public int getKeepnum() {
		return keepnum;
	}

	public void setKeepnum(int keepnum) {
		this.keepnum = keepnum;
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

	public double getTotalscore() {
		return totalscore;
	}

	public void setTotalscore(double totalscore) {
		this.totalscore = totalscore;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public Integer getBigtypeid() {
		return bigtypeid;
	}

	public void setBigtypeid(Integer bigtypeid) {
		this.bigtypeid = bigtypeid;
	}

	public Integer getBigareaid() {
		return bigareaid;
	}

	public void setBigareaid(Integer bigareaid) {
		this.bigareaid = bigareaid;
	}

}
