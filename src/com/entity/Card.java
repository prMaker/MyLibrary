package com.entity;

public class Card {
	@Override
	public String toString() {
		return "Card [id=" + id + ", code=" + code + ", name=" + name + ", tel=" + tel + "]";
	}

	private Integer id;
	private String code;
	private String name;
	private String tel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
