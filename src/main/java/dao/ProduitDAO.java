package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bo.Client;
import bo.Produit;

public class ProduitDAO {
public List<Produit> retreive(){
	Transaction tx=null;
List<Produit> liste=new ArrayList<Produit>();
		try {
		Session session=HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		liste=session.createQuery("From Produit P where P.qtstock>0").list();
		tx.commit();
		session.close();
		return liste;
		
		
	}
	catch(HibernateException e) {
		tx.rollback();
		e.printStackTrace();
		return liste;
	
	}

	
}
	// CREATE
	public void create(Produit produit){
		Transaction tx=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			session.save(produit);
			tx.commit();
			session.close();
			System.out.println("Produit ajouté : " + produit.getId());
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
	}

	// READ by ID
	public Produit findById(int id){
		Transaction tx=null;
		Produit produit=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			produit=(Produit)session.get(Produit.class, id);
			tx.commit();
			session.close();
			return produit;
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			return null;
		}
	}

	// DELETE
	public void delete(int id){
		Transaction tx=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			tx=session.beginTransaction();
			Produit produit=(Produit)session.get(Produit.class, id);
			if(produit!=null) session.delete(produit);
			tx.commit();
			session.close();
			System.out.println("Produit supprimé : " + id);
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
	}
public void update(Produit produit){
	Transaction tx=null;

		try {
		Session session=HibernateUtil.getSessionFactory().openSession();
		tx=session.beginTransaction();
		session.update(produit);
		
		tx.commit();
		session.close();
		System.out.println("====================Produit modifié"+produit.getId() );
		
		
		
	}
	catch(HibernateException e) {
		tx.rollback();
		e.printStackTrace();
		
	
	}

	
}
}
