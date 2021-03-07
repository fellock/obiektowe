/* Napisz klasę SvgScene posiadającą prywatną tablicę obiektów Polygon. Napisz funkcję, która przyjmuje obiekt klasy Polygon oraz dodaje go do tablicy w obiekcie SvgScene. Napisz funkcję saveHtml(String), która utworzy plik HTML w ścieżce danej argumentem i zapisze do niego reprezentacje wszystkich wielokątów znajdujących się na kanwie. */
public class Zadanie2 {
	public static void main(String[] args) {
		Point[] A_points = { new Point(0., 0.), new Point(0., 100.), new Point(1000., 0.) };
		Point[] B_points = { new Point(0., 0.), new Point(0., 50.), new Point(50., 0.) };
		Point[] C_points = { new Point(50., 30.), new Point(0., 56.), new Point(35., 20.) };
		Polygon A = new Polygon(new Style(null, null, null), A_points);
		Polygon B = new Polygon(new Style("blue", "purple", 3.), B_points);
		Polygon C = new Polygon(new Style("orange", "red", 3.), C_points);

		SvgScene scena = new SvgScene();
		scena.addShape(A);
		scena.addShape(B);
		scena.addShape(C);

		scena.saveHtml("Zadanie2.html");
	}

}
