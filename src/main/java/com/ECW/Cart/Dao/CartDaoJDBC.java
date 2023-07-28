package com.ECW.Cart.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ECW.Model.Cart;

public class CartDaoJDBC {
	Connection connection;

	public CartDaoJDBC(Connection connection) {
		super();
		this.connection = connection;
	}

	// INSERT INTO `ecommerce`.`cart` (`cartId`, `productPic`, `productName`,
	// `productPrice`, `productQuantity`, `Date`, `UserId`, `ProductId`) VALUES ();
	public boolean addProductToCart(Cart cart) {
		boolean status = false;
		try {
			String query = "INSERT INTO ecommerce.cart (cartId, productPic, productName, productPrice, productQuantity, Date, UserId, ProductId, status) VALUES (?,?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, cart.getCartId());
			preparedStatement.setString(2, cart.getProductPic());
			preparedStatement.setString(3, cart.getProductName());
			preparedStatement.setInt(4, cart.getProductPrice());
			preparedStatement.setInt(5, cart.getProductQuantity());
			java.util.Date utilDate = cart.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			preparedStatement.setDate(6, sqlDate);
			preparedStatement.setLong(7, cart.getUserId());
			preparedStatement.setInt(8, cart.getProductId());
			preparedStatement.setString(9, cart.getStatus());

			int i = preparedStatement.executeUpdate();
			if (i != 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Cart> getCartDetailsByUser(long userId) {
		List<Cart> carts = new ArrayList<Cart>();
		try {
			String query = "select * from ecommerce.cart where UserId=? and status=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			preparedStatement.setString(2, "active");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int cartId = resultSet.getInt("cartId");
				String productPic = resultSet.getString("productPic");
				String productName = resultSet.getString("productName");
				int productPrice = resultSet.getInt("productPrice");
				int productQuantity = resultSet.getInt("productQuantity");
				Date date = resultSet.getDate("Date");
				int productId = resultSet.getInt("ProductId");
				String status = resultSet.getString("status");
				Cart cart = new Cart(cartId, productPic, productName, productPrice, productQuantity, date, userId, productId, status);
				carts.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;
	}

	// Update cart product quantity if product is already exist
	public boolean updateQuantityIfProductExists(int cartId, int productQuantity) {
		boolean status = false;
		try {
			String query = "UPDATE ecommerce.cart SET productQuantity = ? WHERE (cartId = ?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, productQuantity + 1);
			preparedStatement.setInt(2, cartId);
			int i = preparedStatement.executeUpdate();
			if (i != 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// DELETE FROM `ecommerce`.`cart` WHERE (`cartId` = '9046');
	public boolean deletefromCartByCartId(int cartId) {
		boolean status = false;
		try {
			String query = "DELETE FROM ecommerce.cart WHERE (cartId = ?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			int i = preparedStatement.executeUpdate();
			if (i != 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// UPDATE `ecommerce`.`cart` SET `productQuantity` = '2' WHERE (`cartId` =
	// '3027');
	public boolean updateProductQuantityInCart(int cartId, int quantity) {
		boolean status = false;
		try {
			String query = "UPDATE ecommerce.cart SET productQuantity = ? WHERE (cartId = ?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, cartId);
			int i = preparedStatement.executeUpdate();
			if (i != 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public Cart getCartDetailsByCartId(int cartId) {
		Cart cart = new Cart();
		try {
			String query = "select * from ecommerce.cart where cartId=? and status=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setString(2, "active");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productPic = resultSet.getString("productPic");
				String productName = resultSet.getString("productName");
				int productPrice = resultSet.getInt("productPrice");
				int productQuantity = resultSet.getInt("productQuantity");
				Date date = resultSet.getDate("Date");
				Long userId = resultSet.getLong("UserId");
				int productId = resultSet.getInt("ProductId");
				String status = resultSet.getString("status");

				cart = new Cart(cartId, productPic, productName, productPrice, productQuantity, date, userId, productId, status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	public Cart getCartDetailsByCartIdAsIncative(int cartId) {
		Cart cart = new Cart();
		try {
			String query = "select * from ecommerce.cart where cartId=? and status=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			preparedStatement.setString(2, "inactive");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productPic = resultSet.getString("productPic");
				String productName = resultSet.getString("productName");
				int productPrice = resultSet.getInt("productPrice");
				int productQuantity = resultSet.getInt("productQuantity");
				Date date = resultSet.getDate("Date");
				Long userId = resultSet.getLong("UserId");
				int productId = resultSet.getInt("ProductId");
				String status = resultSet.getString("status");

				cart = new Cart(cartId, productPic, productName, productPrice, productQuantity, date, userId, productId, status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	public boolean changeCartStatus(int cartId) {
		boolean status = false;
		try {
			String query = "UPDATE ecommerce.cart SET status = 'inactive' WHERE (cartId = ?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, cartId);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
