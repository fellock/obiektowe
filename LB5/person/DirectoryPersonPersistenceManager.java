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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryPersonPersistenceManager implements PersonPersistenceManager {

	@Override
	public Person[] load(String path) throws AmbigiousPersonException {
		File directory = new File(path);
		Map<String, TempPerson> persons = new HashMap<>();

		if (directory.exists()) {
			for (File file : directory.listFiles()) {
				TempPerson tempPerson = fromFile(file.getPath());

				if (persons.containsKey(tempPerson.name)) {
					throw new AmbigiousPersonException(tempPerson.getPath(), persons.get(tempPerson.name).getPath());
				} else {
					persons.put(tempPerson.name, tempPerson);
				}
			}

			for (Map.Entry<String, TempPerson> person : persons.entrySet()) {
				person.getValue().convertParents(persons);
			}

			return persons.values().toArray(new Person[persons.size()]);
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

	public TempPerson fromFile(String path) {
		String _name = null;
		LocalDate _birth = null;
		LocalDate _death = null;
		List<String> _parents = new ArrayList<>();
		String tempLine, tempLine2;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(path));

			_name = reader.readLine();
			_birth = Person.stringToDate(reader.readLine());
			tempLine = reader.readLine();

			if (tempLine != null) {
				if (tempLine.equals("Rodzice:")) {
					// rodzice
					_parents.add(reader.readLine());

					// sprawdzam czy drugi rodzic jest podany
					tempLine2 = reader.readLine();
					if (tempLine2 != null) {
						_parents.add(tempLine2);
					}

				} else {
					// śmierć i/lub rodzice
					_death = Person.stringToDate(tempLine);
					tempLine = reader.readLine();

					if (tempLine != null) {
						if (tempLine.equals("Rodzice: ")) {
							// rodzice
							_parents.add(reader.readLine());

							// sprawdzam czy drugi rodzic jest podany
							tempLine2 = reader.readLine();
							if (tempLine2 != null) {
								_parents.add(tempLine2);
							}

						}
					}
				}
			}

			reader.close();

		} catch (IOException | NullPointerException | DateTimeParseException e) {
			e.printStackTrace();
		}

		return new TempPerson(_name, _birth, _death, _parents, path);
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
				writer.write(person.name + "\n" + Person.dateToString(person.birth) + "\n"
						+ Person.dateToString(person.death));
			} else {
				writer.write(person.name + "\n" + Person.dateToString(person.birth));
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
