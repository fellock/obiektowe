package person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TempPerson extends Person {

	private String path;
	private List<String> parentNames = new ArrayList<>();

	public TempPerson(String name, LocalDate birth, LocalDate death, String path) {
		super(name, birth, death);
		this.path = path;
	}

	public TempPerson(String name, LocalDate birth, LocalDate death, List<String> parentNames, String path) {
		super(name, birth, death);
		this.path = path;
		this.parentNames = parentNames;
	}

	public String getPath() {
		return path;
	}

	public void convertParents(Map<String, TempPerson> parentsMap) {
		for (String name : this.parentNames) {
			this.parents.add(parentsMap.get(name));
		}
	}

}
