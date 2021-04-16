/*
Napisz klasę DeathCauseStatistic, posiadającą jako prywatne pola kod ICD-10 choroby oraz tablicę liczb zgonów w kolejnych grupach wiekowych.

Napisz publiczną, statyczną metodę fromCsvLine zwracającą obiekt DeathCauseStatistic na podstawie pojedynczej linii pliku CSV. Uwzględnij, że w pliku po nazwie kodu znajduje się tabulator.

Napisz akcesor do kodu ICD-10 przyczyny zgonu. */
public class Zadanie1 {
	public static void main(String[] args) {
		DeathCauseStatistic DCS = DeathCauseStatistic.fromCsvLine("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");
		System.out.println(DCS.getICD());
	}
}