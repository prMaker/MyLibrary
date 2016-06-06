package com.entity;

import java.util.Date;

public class Borrow {
	@Override
	public String toString() {
		String str = id + "\t" + bid + "\t" + cid + "\t" + bdate;
		return str;
	}

	private Integer id;
	private Integer bid;
	private Integer cid;
	private Date bdate;
	public Integer getId() {
		return id;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}
