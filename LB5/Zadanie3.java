/* Zmodyfikuj pliki tekstowe, aby pod dotychczasowymi liniami warunkowo znalazł się napis “Rodzice:”, a po nim w następnych liniach od 1 do 2 napisów definiujących inne osoby znajdujące się we wczytywanych plikach. Plik może być także pozbawiony informacji o rodzicach. Wówczas napis “Rodzice:” nie pojawia się.

Do klasy Person dodaj pole parents będące listą obiektów klasy Person. Pole to należy ustawić podczas tworzenia obiektów metodą PersonPersistenceManager::load. */
import java.util.Arrays;
import person.*;

public class Zadanie3 {
	public static void main(String[] args) {
		PersonPersistenceManager directory_manager = new DirectoryPersonPersistenceManager();

		Person[] persons;
		try {
			persons = directory_manager.load("test_rodzice");
			System.out.println(Arrays.deepToString(persons));

			//! save nie ogarnia rodziców
			directory_manager.save(persons, "rodzice");
		} catch (AmbigiousPersonException e) {
			e.printStackTrace();
		}
	}
}
