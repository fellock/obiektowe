import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* Napisz metody publiczne:

get(int) - zwracającą wartość z węzła o podanym indeksie,
insert(String, int) - tworzący węzeł przed wskazanym indeksem i ustawiający tam dany argumentem napis,
remove(int) - usuwającą węzeł listy o wskazanym indeksie.

Napisz co najmniej jeden test dla każdej z zaprogramowanych metod. Rozważ sytuację, gdy lista nie posiada węzła o danym indeksie. */
public class Zadanie5 {

	StringList list;

	@BeforeEach
	void Init() {
		list = new StringList();
	}

	@Test
	void testGetInBounds() {
		list.append("1");
		list.append("2");
		list.append("3");
		Assertions.assertEquals("2", list.get(1));
	}

	@Test
	void testGetOutOfBounds() {
		list.append("1");
		list.append("2");
		list.append("3");
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
	}

}
