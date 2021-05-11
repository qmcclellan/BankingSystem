package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import Entity.Bank;
import Entity.BankAccount;
import Entity.CheckingAccount;
import Entity.SavingsAccount;
import Entity.User;
/*
 * add search method
 * */
public class BankAccountDAO {
	private BankAccount bankAccount;
	
	public List<BankAccount> getAccounts(){
		List<BankAccount> accounts = new ArrayList<>();
		
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(BankAccount.class)
					.addAnnotatedClass(CheckingAccount.class)
					.addAnnotatedClass(SavingsAccount.class)
					.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
	
	Query<BankAccount> theQuery =
			session.createQuery("from BankAccount", BankAccount.class);
	
	
	accounts= theQuery.getResultList();
	
	return accounts;
	}
	
	public void createAccount(BankAccount account) {
		
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(BankAccount.class)
					.addAnnotatedClass(CheckingAccount.class)
					.addAnnotatedClass(SavingsAccount.class)
					.addAnnotatedClass(Bank.class)
					.addAnnotatedClass(User.class)
					.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		session.beginTransaction();
		
		session.save(account);
		
		session.getTransaction().commit();
		
	}finally {
		session.close();
		factory.close();
		
	}
	}
	
	public void deleteAccount(int id) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(BankAccount.class)
								.addAnnotatedClass(CheckingAccount.class)
								.addAnnotatedClass(SavingsAccount.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			BankAccount ba = session.get(BankAccount.class, id);
			
			session.delete(ba);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}
	
	
	public void updateAccount(BankAccount account) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(BankAccount.class)
								.addAnnotatedClass(CheckingAccount.class)
								.addAnnotatedClass(SavingsAccount.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			BankAccount ba = session.get(BankAccount.class, account.getId());
			
			ba.setAccountNumber(account.getAccountNumber());
			ba.setRoutingNumber(account.getRoutingNumber());
			ba.setDateOpened(account.getDateOpened());
			ba.setDateClosed(account.getDateClosed());
			
			session.saveOrUpdate(ba);
			
			session.getTransaction().commit();		
		
	}finally {
		session.close();
		factory.close();
	}}


	public BankAccount getAccount(BankAccount account) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(BankAccount.class)
								.addAnnotatedClass(CheckingAccount.class)
								.addAnnotatedClass(SavingsAccount.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
		session.beginTransaction();
		
		BankAccount ba = session.get(BankAccount.class, account.getId());
		
		session.getTransaction().commit();
		
		return ba;
		
	}finally {
		session.close();
		factory.close();
	}
}

	public void deleteAccount(int accountNum, int routingNum) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								//.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(BankAccount.class)
								//.addAnnotatedClass(User.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Query theQuery = null;
		
		try {
			
		theQuery = session.createQuery("from BankAccount where accountNumber like: accountNum and routingNumber like : routingNum", BankAccount.class);
		
			theQuery.setParameter(accountNum, "%" + accountNum+ "%");
			theQuery.setParameter(routingNum, "%" + routingNum+ "%");
			
		List<BankAccount> baccounts = theQuery.getResultList();
		
		if(baccounts.size() == 1) {
			
			 BankAccount ba = baccounts.get(0);
			 
			 deleteAccount(ba.getId());
		}
		
		System.out.println(baccounts);
		
		}finally {
			session.close();
			factory.close();
			
		}
		
	}
	
}
