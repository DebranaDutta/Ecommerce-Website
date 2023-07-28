package com.ECW.Category.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.ECW.Model.Category;
import com.ECW.helper.FactoryProvider;

public class CategoryDaoHibernate {
	public static Session session;
	public static Transaction transaction;

	public static boolean addNewCategory(Category category) {
		session = FactoryProvider.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
		return true;
	}

	public static List<Category> getAllCategoryDetails() {
		List<Category> categories = null;
		try {
			session = FactoryProvider.getFactory().openSession();
			Query<Category> query = session.createQuery("from Category");
			categories = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
}
