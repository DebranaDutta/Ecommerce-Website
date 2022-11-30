package com.ECW.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@Column(name = "Id")
	private int productId;
	@Column(name = "Name", length = 100)
	private String productName;
	@Column(name = "Price")
	private int productPrice;
	@Column(name = "Category")
	private String productCategory;
	@Column(name = "Available")
	private String productAvailability;
	private Date date;
	@Column(name = "Image", length = 1000, nullable = true)
	private String productImage;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int productPrice, String productCategory, String productAvailability, Date date) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productAvailability = productAvailability;
		this.date = date;
	}

	public Product(int productId, String productName, int productPrice, String productCategory, String productAvailability, Date date, String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productAvailability = productAvailability;
		this.date = date;
		this.productImage = productImage;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(String productAvailability) {
		this.productAvailability = productAvailability;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", productCategory=" + productCategory
				+ ", productAvailability=" + productAvailability + ", date=" + date + ", productImage=" + productImage + "]";
	}

}
