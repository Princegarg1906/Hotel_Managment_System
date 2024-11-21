package Services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.PickUp;
import util.hibernate;

public class pickupService {
	
	public void addPickUp(PickUp pickUp) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(pickUp);
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

    public PickUp getPickUpById(int PickUpId) {
        Session session = hibernate.getSession();
        PickUp pickUp = null;
        try {
            pickUp = session.get(PickUp.class, PickUpId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pickUp;
    }

    public List<PickUp> getAllPickUps() {
        Session session = hibernate.getSession();
        List<PickUp> pickUps = null;
        try {
            pickUps = session.createQuery("FROM PickUp", PickUp.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pickUps;
    }
    public void updatePickUp(PickUp pickUp) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(pickUp);
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
        public void deletePickUp(int id) {
            Session session = hibernate.getSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                PickUp pickUp = session.get(PickUp.class, id);
                if (pickUp != null) {
                    session.delete(pickUp);
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
