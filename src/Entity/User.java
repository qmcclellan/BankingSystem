package Entity;
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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

// make discriminator column to be user type
@Entity
@Inheritance
@DiscriminatorColumn(name ="user_type")
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String fName;
	
	@Column(name="last_name")
	private String lName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pin")
	private int pin;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH,
							CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="bank_id")
	private Bank bank;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.DETACH,
													CascadeType.MERGE, CascadeType.REFRESH})
	
	@JoinTable(name="user_accounts",
				joinColumns=@JoinColumn(name="user_id"),//lowercase for joinColumn
				inverseJoinColumns=@JoinColumn(name="bamk_account_id"))
	private List<BankAccount> accounts;
	//private List<Account> account;	

	public User() {
		// TODO Auto-generated constructor stub
		
	}

	public User(String fName, String lName, String email, int pin) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pin = pin;
	}

	
	
	public User(int id, String fName, String lName, String email, int pin) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pin = pin;
	}
	
	

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	

}
