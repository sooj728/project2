package com.shop.model;

import java.util.Date;

public class IssuecouponVO {
	private String icode;
	private String iname;
	private long dc;
	private String use;
	private int issuecouponid;
	private String holder;
	private Date receivedate;
	public String getIcode() {
		return icode;
	}
	public void setIcode(String icode) {
		this.icode = icode;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public long getDc() {
		return dc;
	}
	public void setDc(long dc) {
		this.dc = dc;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public int getIssuecouponid() {
		return issuecouponid;
	}
	public void setIssuecouponid(int issuecouponid) {
		this.issuecouponid = issuecouponid;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Date getReceivedate() {
		return receivedate;
	}
	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}
	

}
