package person;

import java.time.LocalDate;

public class TempPerson extends Person {

	private String path;

	public TempPerson(String name, LocalDate birth, LocalDate death, String path) {
		super(name, birth, death);
		this.path = path;
	}

	public String getPath() {
		return path;
	}



}
