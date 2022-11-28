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
		session = FactoryProvider.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		return true;
	}

	public static boolean addNewProduct(Product product) {
		session = FactoryProvider.getFactory().openSession();
		transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		return true;
	}
	
	public static boolean addNewCategory(Category category) {
		session=FactoryProvider.getFactory().openSession();
		transaction=session.beginTransaction();
		session.save(category);
		transaction.commit();
		return true;
	}
	
	public static List<Category> getAllCategoryDetails(){
		List<Category> categories=null;
		session=FactoryProvider.getFactory().openSession();
		Query<Category> query= session.createQuery("from Category");
		return categories=query.getResultList();
	}
}
