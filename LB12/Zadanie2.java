public class Zadanie2 {
	public static void main(String[] args) {
		SortedList<Integer> lista = new SortedList<>();

		lista.add(5);
		lista.add(2);
		lista.add(20);

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}
