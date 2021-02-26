
/* Napisz funkcję (metodę klasy głównej), która przyjmie: obiekt l klasy Line oraz obiekt p klasy Point. Funkcja powinna zwrócić odcinek prostopadły do l, rozpoczynający się w punkcie p o długości równej odcinkowi l. Następnie zmodyfikuj tę metodę tak, aby zwracała tablicę dwóch możliwych do konstrukcji linii oraz przenieś tą metodę jako statyczną do klasy Line. Szczególne przypadki należy zignorować. */
import java.lang.Math;

public class Zadanie3 {
	public static Line[] f(Line l, Point p) {
		Point p1 = l.getP1();
		Point p2 = l.getP2();

		double a1 = (p1.y - p2.y) / (p1.x - p2.x);
		double a2 = -1 / a1;

		double b2 = p.y - a2 * p.x;

		double x0 = p.x;
		double y0 = p.y;

		double r = l.getLength();

		double root = Math.sqrt(-y0 * y0 + (2 * a2 * x0 + 2 * b2) * y0 - a2 * a2 * x0 * x0 - 2 * a2 * b2 * x0
				+ (a2 * a2 + 1) * r * r - b2 * b2);

		double x1 = -((root - a2 * y0 - x0 + a2 * b2) / (a2 * a2 + 1));
		double y1 = -((a2 * root - a2 * a2 * y0 - a2 * x0 - b2) / (a2 * a2 + 1));

		double x2 = ((root + a2 * y0 + x0 - a2 * b2) / (a2 * a2 + 1));
		double y2 = ((a2 * root + a2 * a2 * y0 + a2 * x0 + b2) / (a2 * a2 + 1));

		return new Line[] { new Line(p, new Point(x1, y1)), new Line(p, new Point(x2, y2)) };
	}

	public static void main(String[] args) {
		Point A = new Point(0, 0);
		Point B = new Point(100, 100);

		Line line = new Line(A, B);
		Line[] arr = f(line, B);

		System.out.println(line.toSvg());
		for (Line l : arr) {
			System.out.println(l.toSvg());
		}
	}
}
