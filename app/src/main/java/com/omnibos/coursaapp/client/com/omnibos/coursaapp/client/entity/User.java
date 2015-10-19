package com.omnibos.coursaapp.client.com.omnibos.coursaapp.client.entity;


import net.sf.json.JSON;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
	private String uid;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String school;
	private String email;
	private String phone;
	private String intro;
	private String stdId;
	private String stdPassword;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public String getStdPassword() {
		return stdPassword;
	}

	public void setStdPassword(String stdPassword) {
		this.stdPassword = stdPassword;
	}

	public JSONObject toJson(){
		JSONObject jsonObject=new JSONObject();
		try{
			jsonObject.put("uid",uid);
			jsonObject.put("password",password);
		}catch(JSONException ex){
			ex.printStackTrace();
		}
		return jsonObject;
	}

}