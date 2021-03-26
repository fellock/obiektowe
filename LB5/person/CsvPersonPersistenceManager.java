package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CsvPersonPersistenceManager implements PersonPersistenceManager {

	@Override
	public Person[] load(String path) {
		BufferedReader reader;
		String _name;
		LocalDate _birth;
		LocalDate _death;
		String line;
		String[] line_arr;
		List<Person> persons = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null) {

				_name = null;
				_birth = null;
				_death = null;

				line_arr = line.split(";");

				_name = line_arr[0];
				_birth = Person.stringToDate(line_arr[1]);
				try {
					_death = Person.stringToDate(line_arr[2]);
				} catch (ArrayIndexOutOfBoundsException e) {
					_death = null;
				}

				persons.add(new Person(_name, _birth, _death));

			}
			reader.close();
		} catch (IOException | NullPointerException | DateTimeParseException e) {
			e.printStackTrace();
		}

		return persons.toArray(new Person[persons.size()]);

	}

	@Override
	public void save(Person[] persons, String path) {
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(path));

			for (Person person : persons) {
				writer.write(person.name + ";" + Person.dateToString(person.birth) + ";");
				if (person.death != null) {
					writer.write(Person.dateToString(person.death));
				}
				writer.write("\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
