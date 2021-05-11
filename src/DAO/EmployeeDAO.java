package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Employee;
import Entity.User;

public class EmployeeDAO {

	public List<User> getEmployees() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Query<User> query = session.createQuery("from User where user_type = Employee");

			List<User> employees = query.getResultList();

			return employees;
		} finally {
			session.close();
			factory.close();
		}
	}

	public void addEmployee(Employee employee) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.save(employee);

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

	public void updateEmployee(Employee employee) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.saveOrUpdate(employee);

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

	public void deleteEmployee(int id) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			Query query = session.createQuery("Delete from User where id =: employeeId");

			query.setParameter("employeeId", id);

			query.executeUpdate();

		} finally {
			session.close();
			factory.close();
		}

	}

	public Employee getEmployee(int id) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Employee employee = session.get(Employee.class, id);

			return employee;

		} finally {
			session.close();
			factory.close();
		}

	}

}
