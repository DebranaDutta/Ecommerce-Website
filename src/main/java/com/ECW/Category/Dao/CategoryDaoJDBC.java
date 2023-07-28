package com.ECW.Category.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ECW.Model.Category;

public class CategoryDaoJDBC {
	private Connection connection;

	public CategoryDaoJDBC(Connection connection) {
		super();
		this.connection = connection;
	}

	// INSERT INTO `ecommerce`.`category` (`categoryId`, `CategoryDetails`,
	// `CategoryName`) VALUES ('1', 'nfaonf', 'nfahb');
	public boolean AddCategory(Category category) {
		boolean status = false;
		try {
			String query = "INSERT INTO ecommerce.category (categoryId, CategoryDetails,CategoryName) VALUES (?,?,?)";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, category.getCategoryId());
			preparedStatement.setString(2, category.getCategoryName());
			preparedStatement.setString(3, category.getCategoryDetails());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// String query="select * from ecommerce.category;"
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		try {
			String query = "select * from ecommerce.category;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int categoryId = resultSet.getInt("categoryId");
				String categoryName = resultSet.getString("categoryName");
				Category category = new Category(categoryId, categoryName);
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	// String query=select categoryName from ecommerce.category where categoryId=?;
	public String getCategoryNameByCategoryID(int cartId) {
		String categoryName = null;
		try {
			String query = "select categoryName from ecommerce.category where categoryId=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				categoryName = resultSet.getString("categoryName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryName;
	}
}
