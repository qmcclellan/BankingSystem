package Entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="bank")
public class Bank {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	//maybe make into hashmap to save user and account
	@OneToMany
	private List<User> users;
	
	@OneToMany
	private List<BankAccount> accounts;
	
	public Bank() {
		this.accounts = new ArrayList<>();
		
	}
	
	public Bank(String name) {
		
		this.name = name;
		this.accounts = new ArrayList<>();
		
	}

	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized List<User> getUsers() {
		return users;
	}

	public synchronized void setUsers(List<User> users) {
		this.users = users;
	}

	public synchronized List<BankAccount> getAccounts() {
		return accounts;
	}

	public synchronized void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	

	
	

}
