import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* Do klasy listy dodaj referencję na ostatni węzeł oraz metody publiczne:

String last() - zwracającą napis z ostatniego węzła listy,
void append(String) - wstawiającą napis na koniec listy,
void removeLast() - usuwającą ostatni węzeł listy.

Uwzględnij rzucanie wyjątku IndexOutOfBoundsException dla pustej listy. Napisz testy analogiczne do stworzonych w zadaniu 2 i 3. */
public class Zadanie4 {

	StringList list;

	@BeforeEach
	void Init() {
		list = new StringList();
	}

	@Test
	void testSingleAppend() {
		list.append("1");
		Assertions.assertEquals("1", list.last());
	}

	@Test
	void testMultippleAppend() {
		list.append("1");
		list.append("2");
		Assertions.assertEquals("2", list.last());
	}

	@Test
	void testLastGivenEmpty() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, list::last);
	}

	@Test
	void testRemoveLast() {
		list.append("1");
		list.append("2");
		list.removeLast();
		Assertions.assertEquals("1", list.last());
	}

	@Test
	void testRemoveLastGivenEmpty() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, list::removeLast);
	}
}
