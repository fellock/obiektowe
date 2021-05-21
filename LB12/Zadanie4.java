import java.util.ArrayList;
import java.util.List;

public class Zadanie4 {
	public static void main(String[] args) {
		List<Integer> lista1 = new ArrayList<>(List.of(1, 4, 2, 5, 6));
		List<Integer> lista2 = new ArrayList<>(List.of(5, 6, 9));

		CountComparator countComparator = new CountComparator();
		SumComparator sumComparator = new SumComparator();
		System.out.println(countComparator.compare(lista1, lista2));
		System.out.println(sumComparator.compare(lista1, lista2));
	}
}
