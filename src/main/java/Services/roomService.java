package Services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Rooms;
import util.hibernate;

public class roomService {
	
	public void addRoom(Rooms room) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(room);
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

    public Rooms getRoomsByNumber(String number) {
        Session session = hibernate.getSession();
        Rooms room = null;
        try {
            List<Rooms> list = getAllRooms();
            for(Rooms r:list) {
            	if(number.equalsIgnoreCase(r.getRoom_number())){
            		room = r;
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return room;
    }

    public List<Rooms> getAllRooms() {
        Session session = hibernate.getSession();
        List<Rooms> room = null;
        try {
        	room = session.createQuery("FROM Rooms", Rooms.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return room;
    }

    public void updateRooms(Rooms room) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(room);
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

    public void deleteRooms(int id) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Rooms room = session.get(Rooms.class, id);
            if (room != null) {
                session.delete(room);
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
