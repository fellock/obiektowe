package person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Person {
	String name;
	LocalDate birth;
	LocalDate death;
	List<Person> parents = new ArrayList<>();

	Person(String name, LocalDate birth, LocalDate death) {
		this.name = name;
		this.birth = birth;
		this.death = death;
	}

	Person(String name, LocalDate birth, LocalDate death, List<Person> parents) {
		this.name = name;
		this.birth = birth;
		this.death = death;
		this.parents = parents;
	}

	static LocalDate stringToDate(String s) {
		return LocalDate.parse(s, DateTimeFormatter.ofPattern("d.M.yyyy"));
	}

	static String dateToString(LocalDate d) {
		return d.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	@Override
	public String toString() {
		return "Person [birth=" + birth + ", death=" + death + ", name=" + name + "]";
	}
}