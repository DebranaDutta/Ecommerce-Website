package com.ECW.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.ECW.Model.User;

public class UserDao {
	private Connection connection;

	public UserDao(Connection connection) {
		super();
		this.connection = connection;
	}

	//String query = "UPDATE ecommerce.user SET password = ? WHERE (userName = ?);";
	public boolean updateUserPassword(String newPassword, String userName) {
		boolean status = false;
		try {
			String query = "UPDATE ecommerce.user SET password = ? WHERE (userName = ?);";
			PreparedStatement preparedStatement=this.connection.prepareStatement(query);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, userName);
			int i=preparedStatement.executeUpdate();
			if(i>0) {
				status=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//String query = "select answer from ecommerce.user where userName=?;
	public String getSecurityAnsweByUserName(String userName) {
		String answer=null;
		try {
			String query = "select answer from ecommerce.user where userName=?;";
			PreparedStatement preparedStatement=this.connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				answer=resultSet.getString("answer");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answer;
	}
	
	// String query = "select securityQuestion from ecommerce.user where userName=?;
	public String getSecurityQuestionByUserName(String userName) {
		String securityQuestion = null;
		try {
			String query = "select securityQuestion from ecommerce.user where userName=?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				securityQuestion = resultSet.getString("securityQuestion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return securityQuestion;
	}

	//String query = "select * from ecommerce.user where userName=? and password=?;";
	public User getUserByUserIdAndPassword(String password, String userName) {
		User user = null;
		try {
			String query = "select * from ecommerce.user where userName=? and password=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				long contactNumber = Long.parseLong(resultSet.getString("phoneNumber"));
				String answer = resultSet.getString("answer");
				Date date = resultSet.getDate("date");
				String email = resultSet.getString("email");
				String fullName = resultSet.getString("fullName");
				String gender = resultSet.getString("gender");
				String securityQuestion = resultSet.getString("securityQuestion");
				String userType=resultSet.getString("userType");
				user = new User(fullName, userName, email, contactNumber, password, securityQuestion, answer, gender, date, userType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
