package com.ECW.helper;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
