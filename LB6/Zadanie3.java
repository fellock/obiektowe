import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* Niech metody first i removeFirst rzucają wyjątek IndexOutOfBoundsException, jeżeli lista jest pusta. Napisz test sprawdzający rzucanie tego wyjątku. */
public class Zadanie3 {

	StringList list;

	@BeforeEach
	void Init() {
		list = new StringList();
	}

	@Test
	void testFirstGivenEmpty() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, list::first);
	}

	@Test
	void testRemoveFirstGivenEmpty() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, list::removeFirst);
	}
}
