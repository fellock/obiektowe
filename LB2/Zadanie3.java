/* Napisz publiczną, statyczną metodę fabrykującą klasę Polygon o nazwie square. Funkcja powinna przyjąć jako argumenty: obiekt Line, obiekt Style i zwrócić wielokąt będący kwadratem, którego przekątną jest dany odcinek.

Przeciąż metodę klasy Line zwracającą prostopadły odcinek tak, aby przyjmowała jako dodatkowy argument długość zwracanego odcinka. */
public class Zadanie3 {
	public static void main(String[] args) {
		Polygon S = Polygon.square(new Line(new Point(200., 200.), new Point(300., 300.)),
				new Style("red", "black", 3.));

		SvgScene scena = new SvgScene();
		scena.addShape(S);

		scena.saveHtml("Zadanie3.html");
	}
}
