package person;

public interface PersonPersistenceManager {
	public Person[] load(String path) throws AmbigiousPersonException;

	public void save(Person[] persons, String path);
}
