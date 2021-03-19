/* Zdefiniuj klasę Person posiadającą prywatne pola name klasy String oraz birth, death klasy LocalDate. Utwórz w niej metodę fabrykującą fromFile, tworzącą obiekt na podstawie pliku o ścieżce danej argumentem. Plik powinien zawierać w kolejnych liniach: imię i nazwisko; datę urodzenia; (opcjonalnie) datę śmierci. Daty podawane są w formacie dd.MM.yyyy. Nadpisz metodę toString. Zagwarantuj, aby metoda fromFile była jedynym sposobem utworzenia obiektu klasy Person. */
public class Zadanie1 {
	public static void main(String[] args) {
		Person Jan = Person.fromFile("jan.txt");
		Person Ala = Person.fromFile("ala.txt");

		System.out.println(Jan.toString());
		System.out.println(Ala.toString());
	}
}
