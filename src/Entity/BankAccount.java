package Entity;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="bankaccount")
@Inheritance
@DiscriminatorColumn(name="account_type")
public abstract class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="account_number")
	private long accountNumber;
	
	@Column(name="routing_number")
	private long routingNumber;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="date_oened")
	private Date dateOpened;
	
	@Column(name="date_closed")
	private Date dateClosed;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
							CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
							CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="bank_id")
	private Bank bank;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE,
													CascadeType.PERSIST, CascadeType.REFRESH})
	
	@JoinTable(name="user_accounts",
				joinColumns=@JoinColumn(name="user_id"),
					inverseJoinColumns=@JoinColumn(name="bank_account_id"))
	private List<User> users;
	
	public BankAccount() {
		this.accountNumber = (long)( Math.random()*90000)* 10000 + 1;
		this.routingNumber = (long)(Math.random() * 90000)* 10000+ 1;
		this.balance = 0;
		this.dateOpened = new Date();
		
	}
	
	
	
	public BankAccount(Date date) {
		
		this.accountNumber = (long) Math.random();
		this.routingNumber = (long)Math.random();
		this.dateOpened = date;
		
	}
	
	

	public BankAccount(int id, long accountNumber, long routingNumber, Date dateOpened, Date dateClosed) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}
	
	
	

}
