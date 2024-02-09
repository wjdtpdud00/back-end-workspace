package com.kh.model;

public class Member {
	private String id ;
	private String oldPw;
	private String newPw ;
	private String name;
	
	public Member () {}
	public Member(String id, String newPw, String name) {
		this.id=id;
		this.newPw = newPw;
		this.name = name;
	}
	public Member(String id, String oldPw, String newPw, String name) {
		this.id = id;
		this.oldPw = oldPw;
		this.newPw = newPw;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOldPw() {
		return oldPw;
	}
	public void setOldPw(String oldPw) {
		this.oldPw = oldPw;
	}
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", oldPw=" + oldPw + ", newPw=" + newPw + ", name=" + name + "]";
	}
	
	
	
}
