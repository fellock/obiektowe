/* Napisz klasę DeathCauseStatisticList, wewnątrz której, w wybranej strukturze danych przetrzymywana będzie informacja o wszystkich obiektach DeathCauseStatistic. Napisz metodę repopulate, przyjmującą ścieżkę do pliku, która usuwa istniejące dane z tej struktury i zapełnia ją danymi z pliku CSV.

W klasie DeathCauseStatisticsList napisz metodę mostDeadlyDiseases, która przyjmie wiek oraz liczbę n, mniejszą od liczby wymienionych chorób. Metoda powinna zwrócić n-elementową listę referencji na obiekty DeathCauseStatistic odpowiadające chorobom powodującym największą liczbę zgonów w grupie wiekowej do której przynależy podany wiek. Lista powinna być posortowana malejąco.*/
public class Zadanie3 {
	public static void main(String[] args) {
		DeathCauseStatisticList dCSL = new DeathCauseStatisticList();
		dCSL.repopulate("zgony.csv");
		dCSL.mostDeadlyDiseases(13, 10).forEach(s -> System.out.println(s.getICD()));
	}
}
