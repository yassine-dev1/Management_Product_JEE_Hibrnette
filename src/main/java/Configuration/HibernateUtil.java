package Configuration;


import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.*;
import org.hibernate.*;
public class HibernateUtil {
public static SessionFactory getSessionFactory() {
	try {
		
		 Configuration config=new Configuration();
		 return config.configure("Configuration/hibernate.cfg.xml").buildSessionFactory();
		
	}
	catch(HibernateException e) {
		e.printStackTrace();
		return null;
	}
	
	
	
	
}

public static void main(String[] argv) {
	
	HibernateUtil.getSessionFactory();
}



}
