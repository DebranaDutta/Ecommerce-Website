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

	public boolean updateUserPassword(String newPassword) {
		boolean status = false;
		try {
			String query = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// String query = "select * from ecommerce.user where userName=?;
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

	// String query = "select * from ecommerce.user where userName=? and
	// password=?;";
	public User getUserDetailsByUserNameAndEmailId(String userName, String emailId) {
		User user = null;
		try {
			String query = "select * from ecommerce.user where userName=? or email=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, emailId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				long contactNumber = Long.parseLong(resultSet.getString("phoneNumber"));
				String answer = resultSet.getString("answer");
				Date date = resultSet.getDate("date");
				String email = resultSet.getString("email");
				String fullName = resultSet.getString("fullName");
				String gender = resultSet.getString("gender");
				String password = resultSet.getString("password");
				String securityQuestion = resultSet.getString("securityQuestion");
				String username = resultSet.getString("userName");

				user = new User(fullName, username, email, contactNumber, password, securityQuestion, answer, gender,
						date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

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

				user = new User(fullName, userName, email, contactNumber, password, securityQuestion, answer, gender,
						date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
