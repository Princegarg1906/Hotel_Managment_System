package Services;

import java.util.List;

import model.Employee;
import util.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class employeeService {
	
	public void addEmployee(Employee emp) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(emp);
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

    public Employee getEmployeeById(int id) {
        Session session = hibernate.getSession();
        Employee emp = null;
        try {
            emp = session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return emp;
    }

    public List<Employee> getAllEmployee() {
        Session session = hibernate.getSession();
        List<Employee> emp = null;
        try {
        	emp = session.createQuery("FROM Employee", Employee.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return emp;
    }

    public void updateEmployee(Employee employee) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(employee);
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

    public void deleteEmployee(int id) {
        Session session = hibernate.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee emp = session.get(Employee.class, id);
            if (emp != null) {
                session.delete(emp);
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
