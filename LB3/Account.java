import java.time.LocalDate;

public class Account {
	private String login, password, firstName, lastName;
	private LocalDate lastLogin;

	public Account(String login, String password, String firstName, String lastName) {
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLogin = LocalDate.of(1970, 1, 1);
	}

	public boolean authorize(String login, String password) {
		if(this.login.equals(login) && this.password.equals(password)) {
			this.lastLogin = LocalDate.now();
			return true;
		}
		else return false;
	}

	public final String toString() {
		return this.firstName + " " + this.lastName;
	}
}