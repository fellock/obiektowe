/* Do klasy Account dodaj prywatną, statyczną listę wszystkich istniejących kont. Jeżeli konto o loginie, który chcemy utworzyć już istnieje, należy do nowego loginu dopisać “1”. Do klasy Account dopisz konstruktor kopiujący, który wykonuje kopię konta z uwzględnieniem zasady niepowtarzania loginów. */

public class Zadanie3 {
	public static void main(String[] args) {
		Account user1 = new Account("Student", "hasło", "Jan", "Kowalski");
		Account user2 = new Account("Student", "pass", "Maciek", "Kowalski");

		System.out.println(user1.getLogin());
		System.out.println(user2.getLogin());
	}
}
