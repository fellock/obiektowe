/* Napisz interfejs ICDCodeTabular posiadający jedną, publiczną metodę getDescription, która dla podanego kodu choroby zwróci jej opis, lub gdy takiego kodu nie odnajdzie rzuci wyjątek IndexOutOfBoundsException. Zaimplementuj ten interfejs w dwóch klasach ICDCodeTabularOptimizedForTime oraz ICDCodeTabularOptimizedForMemory.


Klasa ICDCodeTabularOptimizedForTime powinna jednorazowo załadować wszystkie kody i opisy z pliku, a jej metoda getDescription powinna zwracać wartości z wybranej struktury danych w pamięci tymczasowej.


Klasa ICDCodeTabularOptimizedForMemory nie powinna przetrzymywać danych w pamięci operacyjnej, ale za każdym wywołaniem metody getDescription powinna otwierać plik i wyszukiwać w nim opisu.
 */
public class Zadanie4 {
	public static void main(String[] args) {
		ICDCodeTabular tabular = new ICDCodeTabularOptimizedForTime("icd10.txt");

		System.out.println(tabular.getDescription("N15"));
	}
}
