package Services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Reservation;
import util.hibernate;

import java.util.List;

public class reservationService {
	public void addReservation(Reservation reservation) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(reservation);
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

    public Reservation getReservationById(int reservationId) {
        Session session = hibernate.getSession();
        Reservation reservation = null;
        try {
            reservation = session.get(Reservation.class, reservationId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        Session session = hibernate.getSession();
        List<Reservation> reservations = null;
        try {
            reservations = session.createQuery("FROM Reservation", Reservation.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reservations;
    }
    public void updateReservation(Reservation reservation) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(reservation);
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
        public void deleteReservation(int id) {
            Session session = hibernate.getSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Reservation reservation = session.get(Reservation.class, id);
                if (reservation != null) {
                    session.delete(reservation);
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

