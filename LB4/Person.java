import java.io.BufferedReader;
import java.io.FileReader;
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
		} catch (IOException | NullPointerException | DateTimeParseException e) {
			e.printStackTrace();
		}

		return persons.toArray(new Person[persons.size()]);

	}

	@Override
	public String toString() {
		return "Person [birth=" + birth + ", death=" + death + ", name=" + name + "]";
	}


}