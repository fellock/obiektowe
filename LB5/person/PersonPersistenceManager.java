package person;

interface PersonPersistenceManager {
	public Person[] load(String path);
	public void save(Person[] persons, String path);
}
