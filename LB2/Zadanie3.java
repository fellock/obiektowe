/* Napisz publiczną, statyczną metodę fabrykującą klasę Polygon o nazwie square. Funkcja powinna przyjąć jako argumenty: obiekt Line, obiekt Style i zwrócić wielokąt będący kwadratem, którego przekątną jest dany odcinek.

Przeciąż metodę klasy Line zwracającą prostopadły odcinek tak, aby przyjmowała jako dodatkowy argument długość zwracanego odcinka. */

//! UWAGA
//! Jescze nie działa, poprawię w następnym tygodniu

public class Zadanie3 {
	public static void main(String[] args) {
		Point[] A_points = { new Point(0., 0.), new Point(0., 100.), new Point(1000., 0.) };
		Point[] B_points = { new Point(0., 0.), new Point(0., 50.), new Point(50., 0.) };
		Point[] C_points = { new Point(50., 30.), new Point(0., 56.), new Point(35., 20.) };

		Polygon A = new Polygon(new Style(null, null, null), A_points);
		Polygon B = new Polygon(new Style("blue", "purple", 3.), B_points);
		Polygon C = new Polygon(new Style("orange", "red", 3.), C_points);
		Polygon D = Polygon.square(new Line(new Point(200., 200.), new Point(300., 300.)), new Style("red", "black", 3.));

		SvgScene scena = new SvgScene();
		// scena.addPolygon(A);
		// scena.addPolygon(B);
		// scena.addPolygon(C);
		scena.addPolygon(D);

		scena.saveHtml("Zadanie3.html");
	}
}
