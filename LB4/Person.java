import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private LocalDate birth;
	private LocalDate death;

	private Person(String name, LocalDate birth, LocalDate death) {
		this.name = name;
		this.birth = birth;
		this.death = death;
	}

	private static LocalDate stringToDate(String s) {
		return LocalDate.parse(s, DateTimeFormatter.ofPattern("d.M.yyyy"));
	}

	private static String dateToString(LocalDate d) {
		return d.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public static Person fromFile(String path) {
		String _name = null;
		LocalDate _birth = null;
		LocalDate _death = null;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(path));

			_name = reader.readLine();
			_birth = stringToDate(reader.readLine());
			_death = stringToDate(reader.readLine());

			reader.close();

		} catch (IOException | NullPointerException | DateTimeParseException e) {
			e.printStackTrace();
		}

		return new Person(_name, _birth, _death);
	}

	public static void toFile(Person person, String path) {
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(path));

			if (person.death != null) {
				writer.write(person.name + "\n" + dateToString(person.birth) + "\n" + dateToString(person.death));
			} else {
				writer.write(person.name + "\n" + dateToString(person.birth));
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Person[] fromCSV(String path) {
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
				_birth = stringToDate(line_arr[1]);
				try {
					_death = stringToDate(line_arr[2]);
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

	public static void toCSV(Person[] persons, String path) {
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(path));

			for (Person person : persons) {
				writer.write(person.name + ";" + dateToString(person.birth) + ";");
				if (person.death != null) {
					writer.write(dateToString(person.death));
				}
				writer.write("\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Person [birth=" + birth + ", death=" + death + ", name=" + name + "]";
	}

}