package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	int account;
	String password;
	String name;
	String dob;
	String email;
	String phone;
	String fathername;
	String mothername;
	String gender;
	String adhaar;
	String pan;
	String bloodgroup;
	String alternatenumber;
	
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String sex) {
		this.gender = sex;
	}
	public String getAdhaar() {
		return adhaar;
	}
	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getAlternatenumber() {
		return alternatenumber;
	}
	public void setAlternatenumber(String alternatenumber) {
		this.alternatenumber = alternatenumber;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserDetails [account=" + account + ", password=" + password + ", name=" + name + ", dob=" + dob
				+ ", email=" + email + ", phone=" + phone + ", fathername=" + fathername + ", mothername=" + mothername
				+ ", sex=" + gender + ", adhaar=" + adhaar + ", pan=" + pan + ", bloodgroup=" + bloodgroup
				+ ", alternatenumber=" + alternatenumber + "]";
	}
	
}
