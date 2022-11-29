package com.ECW.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private String fullName;
	private String userName;
	private String email;
	@Id
	private long phoneNumber;
	private String password;
	private String securityQuestion;
	private String answer;
	private String gender;
	private Date date;
	private String userType;

	public User() {
		super();
	}

	public User(String fullName, String userName, String email, long phoneNumber, String password, String securityQuestion, String answer, String gender) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.gender = gender;
	}

	public User(String fullName, String userName, String email, long phoneNumber, String password, String securityQuestion, String answer, String gender, Date date) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.gender = gender;
		this.date = date;
	}

	public User(String fullName, String userName, String email, long phoneNumber, String password, String securityQuestion, String answer, String gender, Date date,
			String userType) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.gender = gender;
		this.date = date;
		this.userType = userType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password + ", securityQuestion="
				+ securityQuestion + ", answer=" + answer + ", gender=" + gender + ", date=" + date + ", userType=" + userType + "]";
	}

}
