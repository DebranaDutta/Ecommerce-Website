package com.ECW.Product.Dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ECW.Model.Product;
import com.ECW.helper.FactoryProvider;

public class ProductDaoHibernate {
	public static Session session;
	public static Transaction transaction;

	public static boolean addNewProduct(Product product) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(product);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static List<Product> getAllProductDetails() {
		List<Product> products = null;
		try {
			session = FactoryProvider.getFactory().openSession();
			Query<Product> query = session.createQuery("from Product");
			products = query.getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public static void removeProducts(String prodIdStr) {
		try {
			int prodId = Integer.parseInt(prodIdStr);
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Product product = (Product) session.get(Product.class, prodId);
			session.remove(product);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Product getIndividualProductDetails(String prodIdStr) {
		Product product = null;
		try {
			int productId = Integer.parseInt(prodIdStr);
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			product = (Product) session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public static void updateProdcutDetails(int productId, String productName, int productPrice, String productCategory, String available, String productPic) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Product product = (Product) session.get(Product.class, productId);
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			product.setProductCategory(productCategory);
			product.setProductAvailability(available);
			product.setProductImage(productPic);
			product.setDate(new Date());
			session.save(product);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
