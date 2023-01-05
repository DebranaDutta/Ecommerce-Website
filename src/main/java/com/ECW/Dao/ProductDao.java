package com.ECW.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ECW.Model.Product;

public class ProductDao {
	private Connection connection;

	public ProductDao(Connection connection) {
		super();
		this.connection = connection;
	}

	// String query=select * from ecommerce.product where Available="yes";
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		String available = "yes";
		try {
			String query = "select * from ecommerce.product where Available=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, available);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int productId = resultSet.getInt("Id");
				String productName = resultSet.getString("Name");
				int productPrice = resultSet.getInt("Price");
				String productCategory = resultSet.getString("Category");
				String productImage = resultSet.getString("Image");

				Product product = new Product(productId, productName, productPrice, productCategory, productImage);
				products.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getProductsByCategoryName(String categoryName) {
		List<Product> products = new ArrayList<Product>();
		String available = "yes";
		try {
			String query = "select * from ecommerce.product where Category=? and Available= ?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, categoryName);
			preparedStatement.setString(2, available);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int productId = resultSet.getInt("Id");
				String productName = resultSet.getString("Name");
				int productPrice = resultSet.getInt("Price");
				String productCategory = resultSet.getString("Category");
				String productImage = resultSet.getString("Image");

				Product product = new Product(productId, productName, productPrice, productCategory, productImage);
				products.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	// Admin
	// String query="select * from ecommerce.product where Category="Mobile";"
	public List<Product> getProductsByCategoryAdmin(String categoryName) {
		List<Product> products = new ArrayList<Product>();
		try {
			String query = "select * from ecommerce.product where Category=?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, categoryName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int productId = resultSet.getInt("Id");
				String productName = resultSet.getString("Name");
				int productPrice = resultSet.getInt("Price");
				String productCategory = resultSet.getString("Category");
				String available1 = resultSet.getString("Available");
				String productImage = resultSet.getString("Image");

				Product product = new Product(productId, productName, productPrice, productCategory, productImage);
				products.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
