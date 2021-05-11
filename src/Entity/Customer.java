package Entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends User {
	@OneToMany
	private List<BankAccount> accounts;

	public Customer() {
		// TODO Auto-generated constructor stub
		accounts = new ArrayList<>();
	}

	public Customer(String fName, String lName, String email, int pin) {
		super(fName, lName, email, pin);
		// TODO Auto-generated constructor stub
		accounts = new ArrayList<>();
	}
	
	public void addAccount(BankAccount account) {
		accounts.add(account);
	}

	@Override
	public String getfName() {
		// TODO Auto-generated method stub
		return super.getfName();
	}

	@Override
	public void setfName(String fName) {
		// TODO Auto-generated method stub
		super.setfName(fName);
	}

	@Override
	public String getlName() {
		// TODO Auto-generated method stub
		return super.getlName();
	}

	@Override
	public void setlName(String lName) {
		// TODO Auto-generated method stub
		super.setlName(lName);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public int getPin() {
		// TODO Auto-generated method stub
		return super.getPin();
	}

	@Override
	public void setPin(int pin) {
		// TODO Auto-generated method stub
		super.setPin(pin);
	}

	
}
