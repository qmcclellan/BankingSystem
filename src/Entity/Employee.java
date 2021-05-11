package Entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Emplyoee")
public class Employee extends User {
	
	@Column(name="employee_id")
	private long employId;

	public Employee() {
		// TODO Auto-generated constructor stub
		
		this.employId = (long)Math.random();
	}

	public Employee(String fName, String lName, String email, int pin) {
		super(fName, lName, email, pin);
		// TODO Auto-generated constructor stub
		this.employId = (long)Math.random();
	}

	public long getEmployId() {
		return employId;
	}

	public void setEmployId(long employId) {
		this.employId = employId;
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
