/* Zdefiniuj w klasie Line publiczną metodę toSvg(), która zwróci napis zawierający kod języka znacznikowego SVG pozwalający wyświetlić tę linię. */
public class Zadanie2 {
	public static void main(String[] args) {
		Point A = new Point(0, 0);
		Point B = new Point(100, 100);

		Line line = new Line(A, B);

		System.out.println(line.toSvg());
	}
}
