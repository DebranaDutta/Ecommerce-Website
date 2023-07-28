package com.ECW.User.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ECW.Model.User;
import com.ECW.helper.FactoryProvider;

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
}
