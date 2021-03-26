import java.util.Arrays;

import person.*;

/* Rozważ sytuację, w której w dwóch plikach znajdują się osoby o tym samym imieniu i nazwisku. Utwórz wyjątek AmbigiousPersonException posiadający dwie metody zwracające ścieżki do tych plików. Wyjątek powinien być rzucany przez metodę DirectoryPersonPersistenceManager::load.
 */
public class Zadanie2 {
	public static void main(String[] args) {
		PersonPersistenceManager directory_manager = new DirectoryPersonPersistenceManager();

		Person[] persons;
		try {
			persons = directory_manager.load("ppl");
			System.out.println(Arrays.deepToString(persons));

			directory_manager.save(persons, "ppl2");
		} catch (AmbigiousPersonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
