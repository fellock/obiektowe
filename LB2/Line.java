import java.lang.Math;
import java.util.Locale;

public class Line {
	private static Point p1, p2;

	public Line(Point _p1, Point _p2) {
		p1 = _p1;
		p2 = _p2;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public double getLength() {
		return Math.hypot(p2.x - p1.x, p2.y - p1.y);
	}

	public String toSvg() {
		return String.format(Locale.US, "<svg height=\"210\" width=\"500\"><line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:rgb(255,0,0);stroke-width:2\"/></svg>", p1.x, p1.y, p2.x, p2.y);
	}

	public Line[] perpendicular(Line l, Point p) {
		return perpendicular(l, p, this.getLength());
	}


	public static Line[] perpendicular(Line l, Point p, double r) {
		Point p1 = l.getP1();
		Point p2 = l.getP2();

		double a1 = (p1.y - p2.y) / (p1.x - p2.x);
		double a2 = -1 / a1;

		double b2 = p.y - a2 * p.x;

		double x0 = p.x;
		double y0 = p.y;

		double root = Math.sqrt(-y0 * y0 + (2 * a2 * x0 + 2 * b2) * y0 - a2 * a2 * x0 * x0 - 2 * a2 * b2 * x0
				+ (a2 * a2 + 1) * r * r - b2 * b2);

		double x1 = -((root - a2 * y0 - x0 + a2 * b2) / (a2 * a2 + 1));
		double y1 = -((a2 * root - a2 * a2 * y0 - a2 * x0 - b2) / (a2 * a2 + 1));

		double x2 = ((root + a2 * y0 + x0 - a2 * b2) / (a2 * a2 + 1));
		double y2 = ((a2 * root + a2 * a2 * y0 + a2 * x0 + b2) / (a2 * a2 + 1));

		return new Line[] { new Line(p, new Point(x1, y1)), new Line(p, new Point(x2, y2)) };
	}
}