package Entity;

public class Login {
	private User user;
	private boolean loggedIn;
	private String email;
	private int pin;
	
	
	public Login(String email, int pin) {
		this.email = email;
		this.pin = pin;
		//loggedIn(authenticate(email,pin));
		
	}
	/*
	public boolean authenticate(String email, int pin) {
		if() {
		return true;
		}
		
		return false;
	}*/
	
	public boolean loggedIn(boolean loggedIn) {
		if(loggedIn == true) {
			this.loggedIn = true;
			return true;
		}
		
		return false;
	}

}
