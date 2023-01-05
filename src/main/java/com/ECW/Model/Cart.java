package com.ECW.Model;

import java.util.Date;

public class Cart {
	private int cartId;
	private String productPic;
	private String productName;
	private int productPrice;
	private int productQuantity;
	private Date date;
	private long userId;
	private int productId;
	private String status;

	public Cart(int cartId, String productPic, String productName, int productPrice, int productQuantity, Date date, long userId, int productId, String status) {
		super();
		this.cartId = cartId;
		this.productPic = productPic;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.date = date;
		this.userId = userId;
		this.productId = productId;
		this.status = status;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductPic() {
		return productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productPic=" + productPic + ", productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", date=" + date + ", userId=" + userId + ", productId=" + productId + ", status=" + status + "]";
	}

}
