package com.ECW.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ECW.Model.Product;

public class ProductDao {
	private Connection connection;

	public ProductDao(Connection connection) {
		super();
		this.connection = connection;
	}

	// String query = "INSERT INTO ecommerce.product (Id, date, Available, Category,
	// Image, Name, Price) VALUES (?, ?, ?, ?, ?, ?, ?);";
	public boolean addNewProduct(Product product) {
		boolean status = false;
		try {
			String query = "INSERT INTO ecommerce.product (Id, date, Available, Category, Image, Name, Price) VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);

			preparedStatement.setInt(1, product.getProductId());
			java.util.Date utilDate = product.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			preparedStatement.setDate(2, sqlDate);
			preparedStatement.setString(3, product.getProductAvailability());
			preparedStatement.setString(4, product.getProductCategory());
			preparedStatement.setString(5, product.getProductImage());
			preparedStatement.setString(6, product.getProductName());
			preparedStatement.setInt(7, product.getProductPrice());

			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	// String query=select * from ecommerce.product;
	public List<Product> getAllProductsIrrecpectiveOfproductAvailability() {
		List<Product> products = new ArrayList<Product>();
		try {
			String query = "select * from ecommerce.product;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int productId = resultSet.getInt("Id");
				String productName = resultSet.getString("Name");
				int productPrice = resultSet.getInt("Price");
				String productCategory = resultSet.getString("Category");
				String productImage = resultSet.getString("Image");
				String productAvailability = resultSet.getString("Available");
				Date date = resultSet.getDate("date");

				Product product = new Product(productId, productName, productPrice, productCategory, productAvailability, date, productImage);
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
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

				Product product = new Product(productId, productName, productPrice, productCategory, available1, productImage);
				products.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	// getIndividualProductDetails
	public Product getIndividualProductDetails(int productId) {
		Product product = new Product();
		try {
			String query = "select * from ecommerce.product where id=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productName = resultSet.getString("Name");
				int productPrice = resultSet.getInt("Price");
				String productCategory = resultSet.getString("Category");
				String productImage = resultSet.getString("Image");
				product = new Product(productId, productName, productPrice, productCategory, productImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	//Edit Product Details
}
