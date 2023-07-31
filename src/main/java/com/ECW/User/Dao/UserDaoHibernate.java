package com.ECW.User.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ECW.Model.User;
import com.ECW.helper.FactoryProvider;

import jakarta.persistence.Query;

public class UserDaoHibernate {
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

	public static User getUserDetails(Long userId) {
		User user = new User();
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			user = (User) session.get(User.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			session=FactoryProvider.getFactory().openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery("from User");
			users=query.getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}
