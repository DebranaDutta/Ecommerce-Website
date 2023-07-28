package com.ECW.Address.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ECW.Model.Address;
import com.ECW.helper.FactoryProvider;

import jakarta.persistence.Query;

public class AddressDaoHibernate {
	public static Session session;
	public static Transaction transaction;

	public static boolean addNewAddress(Address address) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(address);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static List<Address> getAllAddressDetails(long userId) {
		List<Address> addresses = new ArrayList<Address>();
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Address as A where A.userId= :id");
			query.setParameter("id", userId);
			addresses = query.getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addresses;
	}

	public static boolean removeAddress(int addressId) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Address as A where A.addressId= :id");
			query.setParameter("id", addressId);
			query.executeUpdate();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
