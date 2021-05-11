package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Customer;
import Entity.User;

public class CustomerDAO {

public List<Customer> listCustomers(){
	
	SessionFactory factory= new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(User.class)
							.addAnnotatedClass(Customer.class)
							.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	
	try {
		
		Query<Customer> customers = session.createQuery("from User where user_type = Customer", Customer.class);
		
		List<Customer> customerList = customers.getResultList();
		
		
		return customerList;
		
	}finally {
		session.close();
		factory.close();
	}
}

public void addCustomer(Customer customer) {
	
	SessionFactory factory= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Customer.class)
			.buildSessionFactory();

Session session = factory.getCurrentSession();


try {
	session.beginTransaction();
	
	session.save(customer);
	
	session.getTransaction().commit();
	
}finally {
	session.close();
	factory.close();
}	
}

public void deleteCustomer(int id) {
	
	SessionFactory factory= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Customer.class)
			.buildSessionFactory();

Session session = factory.getCurrentSession();

try {
	
	
	Query query =session.createQuery("Delete from User where id =:cId");
	
	query.setParameter("cId", id);
	
	query.executeUpdate();
	
}finally {
	session.close();
	factory.close();
}
}

public Customer getCustomer(int id) {
	SessionFactory factory= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Customer.class)
			.buildSessionFactory();

Session session = factory.getCurrentSession();


try {
	
	Customer customer = session.get(Customer.class, id);
	
	return customer;
	
}finally {
	session.close();
	factory.close();
}
}

public void updateCustomer(Customer customer) {
	
	SessionFactory factory= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Customer.class)
			.buildSessionFactory();

Session session = factory.getCurrentSession();
try {
	
	session.saveOrUpdate(customer);
	
}finally {
	session.close();
	factory.close();
}	
}

}
