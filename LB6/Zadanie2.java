import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* Napisz testy sprawdzające poprawność dodania oraz usunięcia pojedynczego elementu listy. Rozważ przypadki, gdy tablica posiada jeden oraz wiele elementów. */

public class Zadanie2 {

	StringList list;

	@BeforeEach
	void Init() {
		list = new StringList();
	}

	@Test
	public void testSinglePrepend() {
		list.prepend("1");
		Assertions.assertEquals("1", list.first());
	}

	@Test
	public void testMultiplePrepend() {
		list.prepend("1");
		list.prepend("2");
		Assertions.assertEquals("2", list.first());
	}

	@Test
	void testRemoveFirst() {
		list.prepend("1");
		list.prepend("2");
		list.removeFirst();
		Assertions.assertEquals("1", list.first());
	}

}
