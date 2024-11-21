package Services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Driver;
import util.hibernate;

public class driverService {
	
	public void adddriver(Driver driver) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(driver);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Driver getDriverById(int id) {
        Session session = hibernate.getSession();
        Driver driver = null;
        try {
            driver = session.get(Driver.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return driver;
    }
    
    public Driver getDriverByName(String name) {
    	Session session = hibernate.getSession();
        Driver driver = null;
        try {
            List<Driver> list = getAllDriver();
            for(Driver d:list) {
            	if(name.equalsIgnoreCase(d.getName())) {
            		driver =d;
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return driver;
    }

    public List<Driver> getAllDriver() {
        Session session = hibernate.getSession();
        List<Driver> driver = null;
        try {
        	driver = session.createQuery("FROM Driver", Driver.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return driver;
    }

    public void updateDriver(Driver driver) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(driver);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteDriver(int id) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Driver driver = session.get(Driver.class, id);
            if (driver != null) {
                session.delete(driver);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
