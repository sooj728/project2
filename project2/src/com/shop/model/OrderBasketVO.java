package com.shop.model;

public class OrderBasketVO {
	private int orderbasketid;
	private String ocode;
	private int throwerid;	//장바구니에 물건을 담은 회원의 아이디
	private String oitem;	//장바구니에 넣은 상품명
	private int oitemid;	//장바구니에 넣은 상품의 아이디
	private int cnt;
	private int validity;
	
	public int getThrowerid() {
		return throwerid;
	}
	public void setThrowerid(int throwerid) {
		this.throwerid = throwerid;
	}
	public int getOrderbasketid() {
		return orderbasketid;
	}
	public void setOrderbasketid(int orderbasketid) {
		this.orderbasketid = orderbasketid;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public String getOitem() {
		return oitem;
	}
	public void setOitem(String oitem) {
		this.oitem = oitem;
	}
	public int getOitemid() {
		return oitemid;
	}
	public void setOitemid(int oitemid) {
		this.oitemid = oitemid;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	
}
