import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

	@Override
	public String toString() {
		return "Person [birth=" + birth + ", death=" + death + ", name=" + name + "]";
	}


}