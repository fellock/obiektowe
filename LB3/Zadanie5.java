/* Napisz klasę Subject reprezentującą przedmiot, posiadającą prywatne pola:

name : String - nazwa przedmiotu,
course : String - nazwa kierunku, na którym przedmiot jest prowadzony,
semester : int - numer (1-10) semestru, na którym przedmiot jest prowadzony.

Napisz konstruktor ustawiający wszystkie pola.


Napisz klasę SubjectInstance reprezentującą przedmiot odbywający się w określonym roku:

subject : Subject - przedmiot,
year : int - rok prowadzenia, w przypadku semestru letniego rok wcześniejszy,
teacher : Teacher - prowadzący,
students : List<Student> - zapisani studenci,
limit : int - limit zapisanych studentów


Napisz konstruktor ustawiający wszystkie pola poza listą studentów. Napisz publiczną metodę enroll, która przyjmuje jako argument studenta. Jeżeli są miejsca, należy dopisać go do listy i zwrócić prawdę, a fałsz w przeciwnym przypadku. Napisz metodę, która zwróci kopię listy zapisanych studentów. */
public class Zadanie5 {
	public static void main(String[] args) {
		Student s1 = new Student("student", "pass", "Rafał", "Kowalski", "Informatyka", 2020);
		Student s2 = new Student("student", "pass", "Paweł", "Kowalski", "Informatyka", 2020);

		Teacher t = new Teacher("Teacher", "teach", "Piotr", "Kowalski", "Magister");

		Subject OOP = new Subject("Programowanie obiektowe", "Informatyka", 2);

		SubjectInstance oop_1 = new SubjectInstance(OOP, 2020, t, 1);

		System.out.println(oop_1.enroll(s1));
		System.out.println(oop_1.enroll(s2));
		System.out.println(oop_1.getStudents());
	}
}
