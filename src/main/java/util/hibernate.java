package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate {
    private static SessionFactory sessionfactory;
	
	public static Session getSession(){
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			sessionfactory = configuration.buildSessionFactory();
			Session session=sessionfactory.openSession();
			return session;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
    }

}
