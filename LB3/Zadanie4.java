/* Napisz klasę Student dziedziczącą po Account. Klasa powinna posiadać dwa pola prywatne: course klasy String i startYear typu int oznaczające kierunek i rok rozpoczęcia studiów na nich. Napisz konstruktor ustawiający wszystkie pola na wartości argumentów.

Napisz także metodę semester podającą numer semestru (1-10) na podstawie pola startYear i aktualnego czasu. Zakładamy, że student aktualnie studiuje, studiuje tylko na jednym kierunku oraz, że semestr zimowy zaczyna się 1.10, a semestr letni 1.02. */
public class Zadanie4 {
	public static void main(String[] args) {
		Student s = new Student("student", "pass", "Rafał", "Kowalski", "Informatyka", 2020);

		System.out.println(s.semester());
	}
}
