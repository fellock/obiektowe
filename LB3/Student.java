import java.time.LocalDate;
import java.time.Month;

public class Student extends Account {
	private String course;
	private int startYear;

	public Student(String login, String password, String firstName, String lastName, String course, int startYear) {
		super(login, password, firstName, lastName);
		this.course = course;
		this.startYear = startYear;
	}

	public int semester() {
		LocalDate today = LocalDate.now();

		if (today.isAfter(LocalDate.of(startYear, 10, 1)) && today.isBefore(LocalDate.of(startYear + 1, 2, 1)))
			return 1;
		else if (today.isAfter(LocalDate.of(startYear + 1, 2, 1)) && today.isBefore(LocalDate.of(startYear + 1, 10, 1)))
			return 2;
		else if (today.isAfter(LocalDate.of(startYear + 1, 10, 1)) && today.isBefore(LocalDate.of(startYear + 2, 2, 1)))
			return 3;
		else if (today.isAfter(LocalDate.of(startYear + 2, 2, 1)) && today.isBefore(LocalDate.of(startYear + 2, 10, 1)))
			return 4;
		else if (today.isAfter(LocalDate.of(startYear + 2, 10, 1)) && today.isBefore(LocalDate.of(startYear + 3, 2, 1)))
			return 5;
		else if (today.isAfter(LocalDate.of(startYear + 3, 2, 1)) && today.isBefore(LocalDate.of(startYear + 3, 10, 1)))
			return 6;
		else if (today.isAfter(LocalDate.of(startYear + 3, 10, 1)) && today.isBefore(LocalDate.of(startYear + 4, 2, 1)))
			return 7;
		else if (today.isAfter(LocalDate.of(startYear + 4, 2, 1)) && today.isBefore(LocalDate.of(startYear + 4, 10, 1)))
			return 8;
		else if (today.isAfter(LocalDate.of(startYear + 4, 10, 1)) && today.isBefore(LocalDate.of(startYear + 5, 2, 1)))
			return 9;
		else if (today.isAfter(LocalDate.of(startYear + 5, 2, 1)) && today.isBefore(LocalDate.of(startYear + 5, 10, 1)))
			return 10;
		else
			return 0;

		// ROZWIĄZANIE Z ZAJEĆ PONIŻEJ

		/* LocalDate date = LocalDate.now();
		Month miesiac = date.getMonth();
		int rok = date.getYear();
		if (miesiac.compareTo(Month.OCTOBER) < 0)
			rok--;
		int semestr = ((rok - startYear) * 2) + 1;
		if (miesiac.compareTo(Month.FEBRUARY) >= 0 && miesiac.compareTo(Month.OCTOBER) < 0)
			semestr++;
		return semestr; */

	}
}
