package com.ECW.helper;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ECW.Model.Category;
import com.ECW.Model.Product;
import com.ECW.Model.User;

public class CrudOperationsUsingHibernate {
	public static Session session;
	public static Transaction transaction;

	public static boolean addNewUser(User user) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean addNewProduct(Product product) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(product);
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

	public static boolean addNewCategory(Category category) {
		session = FactoryProvider.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
		return true;
	}

	public static List<Category> getAllCategoryDetails() {
		List<Category> categories = null;
		session = FactoryProvider.getFactory().openSession();
		Query<Category> query = session.createQuery("from Category");
		return categories = query.getResultList();
	}
}
