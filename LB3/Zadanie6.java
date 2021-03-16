/* Napisz interfejs Enroller definiujący funkcjonalność zapisu studentów na zajęcia udostępniający metody publiczne:

clear() : void - usuwający poprzednie ustawienia,
setSubjectInstance(SubjectInstance) : void - mutator ustawiający limit studentów,
addStudent(Student) : void - metoda dodająca studenta do zapisu,
process() : void - wykonanie procesu przypisania.

Utwórz klasę AlphabeticEnroller, który zapisuje studentów alfabetycznie według ich nazwiska. Na potrzeby tej klasy, w klasie Account utwórz akcesor do nazwiska

Utwórz klasę RandomEnroller, która w chwili wywołania metody addStudent przypisuje studentowi losowo wygenerowaną liczbę, a następnie przypisuje do zajęć tych, którzy otrzymali jej największa wartość. */
public class Zadanie6 {
	public static void main(String[] args) {
		Teacher t = new Teacher("Teacher", "teach", "Piotr", "Kowalski", "Magister");
		Subject OOP = new Subject("Programowanie obiektowe", "Informatyka", 2);
		SubjectInstance oop_1 = new SubjectInstance(OOP, 2020, t, 2);

		Student s1 = new Student("student", "pass", "Rafał", "Kowalski", "Informatyka", 2020);
		Student s2 = new Student("student", "pass", "Paweł", "Bedocki", "Informatyka", 2020);
		Student s3 = new Student("student", "pass", "Paweł", "A", "Informatyka", 2020);

		AlphabeticEnroller AE = new AlphabeticEnroller(oop_1);
		RandomEnroller RE = new RandomEnroller(oop_1);

		AE.addStudent(s1);
		AE.addStudent(s2);
		AE.addStudent(s3);

		RE.addStudent(s1);
		RE.addStudent(s2);
		RE.addStudent(s3);

		AE.process();
		RE.process();

		System.out.println(AE.getStudents());
		System.out.println(RE.getStudents());

	}
}
