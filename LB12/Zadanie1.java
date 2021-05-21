import java.util.ArrayList;
import java.util.List;

public class Zadanie1 {

	static List filter(List objectList, Class filterClass) {
		List results = new ArrayList();
		for (Object object : objectList) {
			if (filterClass.isInstance(object))
				results.add(object);
		}
		return results;
	}

	public static void main(String[] args) {
		var lista = new ArrayList<>();
		lista.add(2);
		lista.add("ala");
		lista.add(1.53f);
		lista.add(5.4);

		var nowaLista = filter(lista, Number.class);
		System.out.println(nowaLista);
	}

}
