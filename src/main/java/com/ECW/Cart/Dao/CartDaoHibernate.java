package com.ECW.Cart.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ECW.Model.Cart;
import com.ECW.helper.FactoryProvider;

import jakarta.persistence.Query;

public class CartDaoHibernate {
	public static Session session;
	public static Transaction transaction;

	public static boolean addProductToCart(Cart cart) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(cart);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<Cart> getCartDetailsByUser(long userId) {
		List<Cart> carts = new ArrayList<Cart>();
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Cart as C where C.userId= :id AND C.status= :status");
			query.setParameter("id", userId);
			query.setParameter("status", "active");
			carts = query.getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;
	}

	public static boolean updateQuantityIfProductExists(int cartId, int productQuantity) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("UPDATE Cart SET productQuantity= :productQuantity WHERE cartId= :cartId");
			query.setParameter("productQuantity", productQuantity + 1);
			query.setParameter("cartId", cartId);
			query.executeUpdate();
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deletefromCartByCartId(int cartId) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Cart cart = (Cart) session.get(Cart.class, cartId);
			session.remove(cart);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateProductQuantityInCart(int cartId, int quantity) {
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("UPDATE Cart SET productQuantity= :productQuantity WHERE cartId= :cartId");
			query.setParameter("productQuantity", quantity);
			query.setParameter("cartId", cartId);
			query.executeUpdate();
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Cart getCartDetailsByCartId(int cartId) {
		Cart cart = new Cart();
		try {
			session = FactoryProvider.getFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Cart as C WHERE C.cartId= :cartId AND C.status= :status");
			query.setParameter("cartId", cartId);
			query.setParameter("status", "active");
			cart = (Cart) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	public static Cart getCartDetailsByCartIdAsIncative(int cartId) {
		Cart cart = new Cart();
		try {
			session=FactoryProvider.getFactory().openSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("from Cart as C WHERE C.cartId= :cartId AND C.status= :status");
			query.setParameter("cartId", cartId);
			query.setParameter("status", "inactive");
			cart = (Cart) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
}
