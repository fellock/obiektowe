public class StringList {

	class Node {
		String value;
		Node next;

		public Node(String value, StringList.Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private Node head;

	public StringList() {
		this.head = null;
	}

	public boolean checkIfEmpty() {
		if (this.head == null) {
			try {
				throw new IndexOutOfBoundsException("List jest pusta");
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
				return true;
			}
		} else {
			return false;
		}
	}

	public String first() {
		checkIfEmpty();
		return head.value;
	}

	public void prepend(String value) {
		head = new Node(value, head);
	}

	public void removeFirst() {
		if (this.head == null)
			throw new IndexOutOfBoundsException();
		head = head.next;
	}

	/*
	 * Do klasy listy dodaj referencję na ostatni węzeł oraz metody publiczne:
	 *
	 * String last() - zwracającą napis z ostatniego węzła listy, void
	 * append(String) - wstawiającą napis na koniec listy, void removeLast() -
	 * usuwającą ostatni węzeł listy.
	 *
	 * Uwzględnij rzucanie wyjątku IndexOutOfBoundsException dla pustej listy.
	 * Napisz testy analogiczne do stworzonych w zadaniu 2 i 3.
	 */

	public String last() {
		if (this.head)
	}

}