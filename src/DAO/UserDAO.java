package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Bank;
import Entity.BankAccount;
import Entity.Customer;
import Entity.Employee;
import Entity.User;

public class UserDAO {
	
	public List<User> getUsers() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Query<User> query = session.createQuery("from User where user_type = Employee");

			List<User> users = query.getResultList();

			return users;
		} finally {
			session.close();
			factory.close();
		}
	}

	public void addUser(User user) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Bank.class).addAnnotatedClass(BankAccount.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.save(user);

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

	public void updateUser(User user) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.saveOrUpdate(user);

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

	public void deleteUser(int id) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			Query query = session.createQuery("Delete from User where id =: userId");

			query.setParameter("userId", id);

			query.executeUpdate();

		} finally {
			session.close();
			factory.close();
		}

	}

	public User getUser(int id) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			User user = session.get(User.class, id);

			return user;

		} finally {
			session.close();
			factory.close();
		}

	}


}
