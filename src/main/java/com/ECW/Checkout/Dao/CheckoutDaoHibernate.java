package com.ECW.Checkout.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ECW.Model.Checkout;
import com.ECW.helper.FactoryProvider;

import jakarta.persistence.Query;

public class CheckoutDaoHibernate {
	public static Session session;
	public static Transaction transaction;

	public static boolean insertIntoCheckoutTable(Checkout checkout) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(checkout);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<Checkout> getOrderDetails(long userId) {
		List<Checkout> checkouts = new ArrayList<Checkout>();
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Checkout as C where C.userId= :userid and C.status= :status");
			query.setParameter("userid", userId);
			query.setParameter("status", "Not Delivered");
			checkouts = query.getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkouts;
	}

	public static List<Checkout> getDeliveredOrderDetails(long userId) {
		List<Checkout> checkouts = new ArrayList<Checkout>();
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Checkout as C where C.userId= :userid and C.status= :status");
			query.setParameter("userid", userId);
			query.setParameter("status", "Delivered");
			checkouts = query.getResultList();
			session.close();
		} catch (Exception e) {

		}
		return checkouts;
	}

	public static List<Checkout> getNotDeliveredOrderDetails() {
		List<Checkout> checkouts = new ArrayList<Checkout>();
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Checkout as C where C.status= :status");
			query.setParameter("status", "Not Delivered");
			checkouts = query.getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkouts;
	}
}
