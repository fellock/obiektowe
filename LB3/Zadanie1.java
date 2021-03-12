/* Napisz klasę Account posiadającą prywatne pola login, password, firstName, lastName klasy String oraz lastLogin klasy LocalDate. Napisz konstruktor tej klasy ustawiający pola na wartości zmiennych oraz datę na 1.01.1970.

Napisz metodę authorize, która przyjmie dwie zmienne klasy String i porówna je z polami login i password. Jeżeli się zgadzają należy zwrócić prawdę i ustawić lastLogin na aktualny czas. W przeciwnym razie należy zwrócić fałsz. */

public class Zadanie1 {
	public static void main(String[] args) {
		Account user = new Account("Student", "hasło", "Jan", "Kowalski");

		System.out.println(user.authorize("Student", "hasło"));
		System.out.println(user.authorize("Student", "haslo"));
	}

}
