package com.boxoffice.model.vo;

public class Member {
	private int mNo;
	private String id;
	private String password;
	private String name;

	public Member() {
		super();
	}

	public Member(int mNo, String id, String password, String name) {
		super();
		this.mNo = mNo;
		this.id = id;
		this.password = password;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [mNo=" + mNo + ", id=" + id + ", password=" + password + ", name=" + name + "]";
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}