package Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bankaccount")
@DiscriminatorValue("Checking")
public class CheckingAccount extends BankAccount implements Account {
	

	
	

	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
		
	}



	@Override
	public long getAccountNumber() {
		// TODO Auto-generated method stub
		return super.getAccountNumber();
	}

	@Override
	public void setAccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		super.setAccountNumber(accountNumber);
	}

	@Override
	public long getRoutingNumber() {
		// TODO Auto-generated method stub
		return super.getRoutingNumber();
	}

	@Override
	public void setRoutingNumber(long routingNumber) {
		// TODO Auto-generated method stub
		super.setRoutingNumber(routingNumber);
	}

	@Override
	public Date getDateOpened() {
		// TODO Auto-generated method stub
		return super.getDateOpened();
	}

	@Override
	public void setDateOpened(Date dateOpened) {
		// TODO Auto-generated method stub
		super.setDateOpened(dateOpened);
	}

	@Override
	public Date getDateClosed() {
		// TODO Auto-generated method stub
		return super.getDateClosed();
	}

	@Override
	public void setDateClosed(Date dateClosed) {
		// TODO Auto-generated method stub
		super.setDateClosed(dateClosed);
	}



	@Override
	public double withdrwal(double amount) {
		// TODO Auto-generated method stub
		
		super.setBalance( super.getBalance()- amount);
		
		return super.getBalance();
	}



	@Override
	public double deposit(double amount) {
		// TODO Auto-generated method stub
		
		super.setBalance(super.getBalance() + amount);
		
		return super.getBalance();
	}
	
	

}
