import java.util.Arrays;

/* Dany jest plik CSV, w którego kolejnych wierszach zapisane są linie według schematu:

Imię i nazwisko; data urodzenia; (opcjonalnie) data śmierci.

Napisz publiczną, statyczną metodę klasy Person fromCsv, przyjmującą ścieżkę do pliku o podanym schemacie, która tworzy i zwraca tablicę obiektów Person na podstawie jego zawartości. */
public class Zadanie2 {
	public static void main(String[] args) {
		Person[] persons = Person.fromCSV("dane.csv");

		System.out.println(Arrays.deepToString(persons));
	}
}
