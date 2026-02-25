package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Configuration.HibernateUtil;
import Model.Commande;
import Model.Ligne_Commande;

public class CommandeDAO {
public void create(Commande commande) {
	Transaction tx=null;
	try {
	Session session=HibernateUtil.getSessionFactory().openSession();
	tx=session.beginTransaction();
	session.save(commande);
	for(Ligne_Commande l:commande.getLignes()) {
		l.setCommande(commande);
		session.saveOrUpdate(l);
		
	}
	
	tx.commit();
	session.close();
}
catch(HibernateException e) {
	tx.rollback();
	e.printStackTrace();
}
	
}
}
