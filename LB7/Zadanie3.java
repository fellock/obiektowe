/* Napisz klasę DeathCauseStatisticList, wewnątrz której, w wybranej strukturze danych przetrzymywana będzie informacja o wszystkich obiektach DeathCauseStatistic. Napisz metodę repopulate, przyjmującą ścieżkę do pliku, która usuwa istniejące dane z tej struktury i zapełnia ją danymi z pliku CSV. */
public class Zadanie3 {
	public static void main(String[] args) {
		DeathCauseStatisticList dCSL = new DeathCauseStatisticList();
		dCSL.repopulate("zgony.csv");

		System.out.println(dCSL.getKeys());
	}
}
