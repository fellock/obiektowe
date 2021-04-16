/* Wewnątrz klasy DeathCauseStatistic zdefiniuj publiczną klasę AgeBracketDeaths posiadającą publiczne, ostateczne pola typu int: young, old, deathCount zawierające granice grupy wiekowej i liczbę zgonów.

W klasie DeathCauseStatistic napisz metodę przyjmującą wiek i zwracającą obiekt AgeBracketDeaths odpowiadający temu wiekowi. */
public class Zadanie2 {
	public static void main(String[] args) {
		DeathCauseStatistic DCS = DeathCauseStatistic.fromCsvLine("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");
		System.out.println(DCS.getAgeBracket(67).deathCount);
	}
}
