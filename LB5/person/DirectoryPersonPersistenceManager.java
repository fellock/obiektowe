package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryPersonPersistenceManager implements PersonPersistenceManager {

	@Override
	public Person[] load(String path) {
		List<Person> persons = new ArrayList<>();
		File directory = new File(path);

		if (directory.exists()) {
			for (File file : directory.listFiles()) {
				persons.add(fromFile(file.getPath()));
			}

			return persons.toArray(new Person[persons.size()]);
		} else {
			return null;
		}
	}

	@Override
	public void save(Person[] persons, String path) {
		File directory = new File(path);

		if (!directory.exists()) {
			directory.mkdirs();
		} else {
			purgeDirectory(directory);
		}

		for (Person person : persons) {
			toFile(person, path + "/" + person.name + ".txt");
		}
	}

	public Person fromFile(String path) {
		String _name = null;
		LocalDate _birth = null;
		LocalDate _death = null;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(path));

			_name = reader.readLine();
			_birth = Person.stringToDate(reader.readLine());
			_death = Person.stringToDate(reader.readLine());

			reader.close();

		} catch (IOException | NullPointerException | DateTimeParseException e) {
			e.printStackTrace();
		}

		return new Person(_name, _birth, _death);
	}


	void purgeDirectory(File dir) {
		for (File file : dir.listFiles()) {
			if (file.isDirectory())
				purgeDirectory(file);
			file.delete();
		}
	}


	public static void toFile(Person person, String path) {
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(path));

			if (person.death != null) {
				writer.write(person.name + "\n" + Person.dateToString(person.birth) + "\n" + Person.dateToString(person.death));
			} else {
				writer.write(person.name + "\n" + Person.dateToString(person.birth));
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
