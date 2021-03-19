/* Napisz publiczne, statyczne metody klasy Person:

toFile - przyjmującą obiekt Person i ścieżkę do pliku, zapisującą dane według schematu z zadania 1,

toCsv - przyjmującą tablicę obiektów Person i ścieżkę do pliku, zapisującą dane według schematu z zadania 2.

Napisz publiczną, statyczną metodę sortCsv klasy Person, która przyjmie ścieżkę do pliku CSV i posortuje ją rosnąco według daty urodzenia. Wykorzystaj napisane wcześniej metody. */
public class Zadanie3 {
	public static void main(String[] args) {
		Person[] persons = Person.fromCSV("dane.csv");

		Person.toFile(persons[1], "Zadanie 3.txt");
		Person.toCSV(persons, "Zadanie 3.csv");
	}
}
