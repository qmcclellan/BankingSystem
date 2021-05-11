package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Account;
import Entity.Bank;
import Entity.BankAccount;
import Entity.User;

public class BankDAO {
	
	private Bank bank;
	
	public List<Bank> listBanks(){
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(BankAccount.class)
								.addAnnotatedClass(Account.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			//Query<Bank> query =session.createQuery("from Bank", Bank.class);
			
			List<Bank> banks = session.createQuery("from Bank", Bank.class).getResultList();
			
			
			
			return banks;
		}finally {
			session.close();
			factory.close();
		}
	}
	
	public void addBank(Bank bank) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(BankAccount.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			session.saveOrUpdate(bank);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}
	
	public Bank getBank(int id) {
		
		SessionFactory factory = new Configuration() 
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(BankAccount.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		

			Bank bank = session.get(Bank.class, id);
		
		
		
		return bank;
		
		}finally {
			session.close();
			factory.close();
		}
	}
	
	public void deleteBank(int id) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(BankAccount.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		Query query = session.createQuery("Delete from Bank where id =: bank_id");
				query.setParameter("bank_id", id);
				
				query.executeUpdate();
		}finally {
			
			session.close();
			factory.close();
		}
	}
	
	

}
