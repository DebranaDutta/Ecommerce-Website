package com.ECW.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ECW.Model.Category;

public class CategoryDao {
	private Connection connection;

	public CategoryDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	//String query="select * from ecommerce.category;"
	public List<Category> getAllCategories(){
		List<Category> categories=new ArrayList<Category>();
		try {
			String query="select * from ecommerce.category;";
			PreparedStatement preparedStatement=this.connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int categoryId=resultSet.getInt("categoryId");
				String categoryName=resultSet.getString("categoryName");
				Category category=new Category(categoryId, categoryName);
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	//String query=select categoryName from ecommerce.category where categoryId=?;
	public String getCategoryNameByCategoryID(int cartId) {
		String categoryName=null;
		try {
			String query="select categoryName from ecommerce.category where categoryId=?;";
			PreparedStatement preparedStatement=this.connection.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				categoryName=resultSet.getString("categoryName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryName;
	}
}
