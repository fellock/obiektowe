import java.util.Arrays;

/* Napisz publiczne, statyczne metody klasy Person:

toDirectory - przyjmującą tablicę obiektów Person i ścieżkę do katalogu. Jeżeli katalog nie istnieje, należy go utworzyć, a w przeciwnym razie wyczyścić. W katalogu, dla każdej osoby należy stworzyć plik o nazwie odpowiadającej polu name i rozszerzeniu txt zawierający dane według schematu z zadania 1.

fromDirectory - przyjmującą ścieżkę do katalogu, zwracającą tablicę obiektów Person. */
public class Zadanie4 {
	public static void main(String[] args) {
		Person[] persons = Person.fromCSV("dane.csv");

		Person.toDirectory(persons, "ludzie");

		Person[] new_persons = Person.fromDirectory("ludzie");

		System.out.println(Arrays.deepToString(new_persons));
	}
}
