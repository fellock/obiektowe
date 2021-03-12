/* Utwórz klasę Teacher dziedzicząca po Account, posiadającą dodatkowe pole title klasy String. Wszystkie pola należy ustawić konstruktorem. W klasie Account utwórz publiczną metodę toString zwracającą napis utworzony z imienia i nazwiska. W klasie Teacher powinien on dodatkowo zawierać tytuł. Po przetestowaniu, uczyń metodę klasy Account ostateczną. */
public class Zadanie2 {
	public static void main(String[] args) {
		Teacher t = new Teacher("Teacher", "teach", "Piotr", "Kowalski", "Magister");

		Account user = new Account("Student", "hasło", "Jan", "Kowalski");

		System.out.println(t.toString());
		System.out.println(user.toString());
	}
}
