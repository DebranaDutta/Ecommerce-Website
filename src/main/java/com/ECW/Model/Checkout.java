package com.ECW.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Checkout {
	@Id
	private String transactionId;
	private int totalPrice;
	private String payment;
	private String productId;
	private String cartId;
	private Long userId;
	private int addressId;
	private Date date;
	private String status;

	public Checkout() {
		super();
	}

	public Checkout(String transactionId, int totalPrice, String payment, String productId, Long userId, int addressId) {
		super();
		this.transactionId = transactionId;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.productId = productId;
		this.userId = userId;
		this.addressId = addressId;
	}

	public Checkout(String transactionId, int totalPrice, String payment, String productId, Long userId, int addressId, Date date) {
		super();
		this.transactionId = transactionId;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.productId = productId;
		this.userId = userId;
		this.addressId = addressId;
		this.date = date;
	}

	public Checkout(String transactionId, int totalPrice, String payment, String productId, String cartId, Long userId, int addressId, Date date) {
		super();
		this.transactionId = transactionId;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.productId = productId;
		this.cartId = cartId;
		this.userId = userId;
		this.addressId = addressId;
		this.date = date;
	}

	public Checkout(String transactionId, int totalPrice, String payment, String productId, Long userId, int addressId, Date date, String status) {
		super();
		this.transactionId = transactionId;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.productId = productId;
		this.userId = userId;
		this.addressId = addressId;
		this.date = date;
		this.status = status;
	}

	public Checkout(String transactionId, int totalPrice, String payment, String productId, String cartId, Long userId, int addressId, Date date, String status) {
		super();
		this.transactionId = transactionId;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.productId = productId;
		this.cartId = cartId;
		this.userId = userId;
		this.addressId = addressId;
		this.date = date;
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "Checkout [transactionId=" + transactionId + ", totalPrice=" + totalPrice + ", payment=" + payment + ", productId=" + productId + ", userId=" + userId
				+ ", addressId=" + addressId + ", date=" + date + ", status=" + status + "]";
	}

}
