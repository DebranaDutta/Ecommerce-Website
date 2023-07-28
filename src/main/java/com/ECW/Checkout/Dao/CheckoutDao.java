package com.ECW.Checkout.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ECW.Model.Checkout;

public class CheckoutDao {
	Connection connection;

	public CheckoutDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean insertIntoCheckoutTable(Checkout checkout) {
		boolean status = false;
		try {
			String query = "INSERT INTO `ecommerce`.`checkout` (`transactionId`, `totalPrice`, `payment`, `productId`, `cartid`, `userid`, `addressId`, `Date`) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, checkout.getTransactionId());
			preparedStatement.setInt(2, checkout.getTotalPrice());
			preparedStatement.setString(3, checkout.getPayment());
			preparedStatement.setString(4, checkout.getProductId());
			preparedStatement.setString(5, checkout.getCartId());
			preparedStatement.setLong(6, checkout.getUserId());
			preparedStatement.setInt(7, checkout.getAddressId());
			java.util.Date utilDate = checkout.getDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			preparedStatement.setDate(8, sqlDate);

			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Checkout> getOrderDetails(long userId) {
		List<Checkout> checkouts = new ArrayList<Checkout>();
		try {
			String query = "select * from ecommerce.checkout where userid=? and status='Not Delivered';";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String transactionId = resultSet.getString("transactionId");
				int totalPrice = resultSet.getInt("totalPrice");
				String payment = resultSet.getString("payment");
				String productId = resultSet.getString("productId");
				String cartId = resultSet.getString("cartId");
				int addressId = resultSet.getInt("addressId");
				Date date = resultSet.getDate("Date");

				Checkout checkout = new Checkout(transactionId, totalPrice, payment, productId, cartId, userId, addressId, date);
				checkouts.add(checkout);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkouts;
	}

	public List<Checkout> getNotDeliveredOrderDetails() {
		List<Checkout> checkouts = new ArrayList<Checkout>();
		try {
			String query = "select * from ecommerce.checkout where status='Not Delivered';";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String transactionId = resultSet.getString("transactionId");
				int totalPrice = resultSet.getInt("totalPrice");
				Long userId = resultSet.getLong("userid");
				String payment = resultSet.getString("payment");
				String productId = resultSet.getString("productId");
				String cartId = resultSet.getString("cartId");
				int addressId = resultSet.getInt("addressId");
				Date date = resultSet.getDate("Date");
				String status = resultSet.getString("status");

				Checkout checkout = new Checkout(transactionId, totalPrice, payment, productId, cartId, userId, addressId, date, status);
				checkouts.add(checkout);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkouts;
	}
}
