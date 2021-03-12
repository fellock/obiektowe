import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
	private String login, password, firstName, lastName;
	private LocalDate lastLogin;
	private static List<Account> accounts = new ArrayList<>();

	public Account(String login, String password, String firstName, String lastName) {
		for (Account account : accounts) {
			if (account.login.equals(login)) {
				login += "1";
			}
		}
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastLogin = LocalDate.of(1970, 1, 1);
		accounts.add(this);
	}

	public Account(Account account) {
		this(account.login, account.password, account.firstName, account.lastName);
		this.lastLogin = account.lastLogin;
	}

	public boolean authorize(String login, String password) {
		if (this.login.equals(login) && this.password.equals(password)) {
			this.lastLogin = LocalDate.now();
			return true;
		} else
			return false;
	}

	public final String toString() {
		return this.firstName + " " + this.lastName;
	}

	public String getLogin() {
		return login;
	}
}