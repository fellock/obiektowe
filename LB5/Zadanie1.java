import java.util.Arrays;

import person.*;

public class Zadanie1 {
	public static void main(String[] args) {
		PersonPersistenceManager directory_manager = new DirectoryPersonPersistenceManager();

		Person[] persons;
		try {
			persons = directory_manager.load("ppl");
			System.out.println(Arrays.deepToString(persons));

			directory_manager.save(persons, "ppl2");
		} catch (AmbigiousPersonException e) {
			e.printStackTrace();
		}

	}
}
