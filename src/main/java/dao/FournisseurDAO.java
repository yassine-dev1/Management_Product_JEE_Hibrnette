package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Configuration.HibernateUtil;
import Model.Fournisseur;

public class FournisseurDAO {
    public void create(Fournisseur fournisseur) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(fournisseur);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Fournisseur> retreive() {
        Transaction tx = null;
        List<Fournisseur> liste = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            liste = session.createQuery("From Fournisseur", Fournisseur.class).list();
            tx.commit();
            session.close();
            return liste;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public Fournisseur findById(int id) {
        Transaction tx = null;
        Fournisseur fournisseur = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            fournisseur = session.get(Fournisseur.class, id);
            tx.commit();
            session.close();
            return fournisseur;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public void update(Fournisseur fournisseur) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(fournisseur);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Fournisseur fournisseur = session.get(Fournisseur.class, id);
            if (fournisseur != null) session.delete(fournisseur);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
