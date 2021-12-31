package com.shop.model;

public class BuyVO {
	private int buyid;
	private String bcode;
	private String buyer;
	private String email;
	private String tel;
	private String add1;
	private String add2;
	private String add3;
	private String note;	//요청사항
	private String bitem;	//구매한 물품명
	private int bitemid;  //구매한 물품의 id
	private int cnt;		//구매한 개수
	private int amount;		//총액
	private String cpuse;	//쿠폰사용여부
	private String paytype;	//결제방식
	private String payprop;	//결제방식에 따른 계좌번호나 카드번호
	
	public int getBitemid() {
		return bitemid;
	}
	public void setBitemid(int bitemid) {
		this.bitemid = bitemid;
	}
	public int getBuyid() {
		return buyid;
	}
	public void setBuyid(int buyid) {
		this.buyid = buyid;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getAdd3() {
		return add3;
	}
	public void setAdd3(String add3) {
		this.add3 = add3;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getBitem() {
		return bitem;
	}
	public void setBitem(String bitem) {
		this.bitem = bitem;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCpuse() {
		return cpuse;
	}
	public void setCpuse(String cpuse) {
		this.cpuse = cpuse;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getPayprop() {
		return payprop;
	}
	public void setPayprop(String payprop) {
		this.payprop = payprop;
	}
	
	

}
