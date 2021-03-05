public class Zadanie5 {
	public static void main(String[] args) {
		Point[] A_points = { new Point(0., 0.), new Point(0., 100.), new Point(1000., 0.) };
		Point[] B_points = { new Point(0., 0.), new Point(0., 50.), new Point(50., 0.) };
		Point[] C_points = { new Point(50., 30.), new Point(0., 56.), new Point(35., 20.) };
		Polygon A = new Polygon(new Style(null, null, null), A_points);
		Polygon B = new Polygon(new Style("blue", "purple", 3.), B_points);
		Polygon C = new Polygon(new Style("orange", "red", 3.), C_points);

		Ellipse E = new Ellipse(new Style("white", "black", 7.), new Point(300., 300.), 100., 50.);

		SvgScene scena = new SvgScene();
		scena.addShape(A);
		scena.addShape(B);
		scena.addShape(C);
		scena.addShape(E);


		scena.saveHtml("Zadanie5.html");
	}

}
