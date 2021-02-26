public class Zadanie1 {
	public static void main(String[] args) {
		Point A = new Point(0, 0);
		Point B = new Point(1, 1);

		Line line = new Line(A, B);

		System.out.println(line.getLength());
	}
}
