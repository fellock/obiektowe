public class StringList {

	class Node {
		String value;
		Node next;

		public Node(String value, StringList.Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private Node head, tail;

	public StringList() {
		this.head = null;
		this.tail = null;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void throwIfEmpty() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("List jest pusta");
	}

	public String first() {
		throwIfEmpty();
		return head.value;
	}

	public void prepend(String value) {
		if (isEmpty()) {
			head = new Node(value, head);
			tail = head;
		} else {
			head = new Node(value, head);
		}
	}

	public void removeFirst() {
		throwIfEmpty();

		if (head == tail)
			tail = null;

		head = head.next;
	}

	public String last() {
		throwIfEmpty();
		return tail.value;
	}

	public void append(String value) {
		if (isEmpty()) {
			prepend(value);
		} else {
			tail.next = new Node(value, null);
			tail = tail.next;
		}
	}

	public void removeLast() {
		throwIfEmpty();

		if (head == tail) {
			removeFirst();
		} else {
			Node tmp = head;
			while (tmp.next != tail)
				tmp = tmp.next;
			tmp.next = null;
			tail = tmp;
		}

	}

	public String get(int index) {
		Node tmp = head;
		int i = 0;
		while (i != index && tmp != null) {
			tmp = tmp.next;
			i++;
		}
		if (tmp == null)
			throw new IndexOutOfBoundsException("Indeks poza granicami listy");
		return tmp.value;
	}

}