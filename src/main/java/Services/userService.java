package Services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.User;
import util.hibernate;

public class userService {
	
	public void addUser(User user) {
		Transaction transaction = null;
		try(Session session  = hibernate.getSession()){
			transaction = session.beginTransaction();
			session.persist(user);
			transaction.commit();
		} catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void removeUser(int id) {
		Transaction transaction = null;
		try(Session session  = hibernate.getSession()){
			transaction = session.beginTransaction();
			User user = session.get(User.class, id);
			if (user != null) {
                session.delete(user);
            }
			transaction.commit();
		} catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}	
	}
	
	 public List<User> getAllUser() {
	        Session session = hibernate.getSession();
	        List<User> users = null;
	        try {
	            users = session.createQuery("FROM User", User.class).getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return users;
	    }
	 
	 public List<String> getAllemails() {
	        Session session = hibernate.getSession();
	        List<String> emails = new ArrayList<String>();
	        try {
	        	List<User> users = getAllUser();
	        	for(User u:users) {
	        		emails.add(u.getEmail());
	        	}
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return emails;
	    }
	 
	 public User getUseronUsername(String username) {
	        User user = null;
	        try(Session session = hibernate.getSession();) {
	        	user = session.get(User.class,username);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }

}
