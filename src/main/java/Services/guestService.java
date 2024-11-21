package Services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Guest;
import util.hibernate;

public class guestService {
	
	public void addGuest(Guest guest) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(guest);
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
	
	public int getGuestId(String name){
		Session session = hibernate.getSession();
        int id=0;
        try {
        	List<Guest> list = getAllGuests();
            for(Guest g:list) {
            	if(name.equalsIgnoreCase(g.getName())) {
            		id = g.getId();
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
	}

    public Guest getGuestById(int id) {
        Session session = hibernate.getSession();
        Guest guest = null;
        try {
            guest = session.get(Guest.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return guest;
    }

    public List<Guest> getAllGuests() {
        Session session = hibernate.getSession();
        List<Guest> guests = null;
        try {
            guests = session.createQuery("FROM Guest", Guest.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return guests;
    }

    public void updateGuest(Guest guest) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(guest);
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

    public void deleteGuest(int id) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Guest guest = session.get(Guest.class, id);
            if (guest != null) {
                session.delete(guest);
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
