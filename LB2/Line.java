import java.lang.Math;
import java.util.Locale;

public class Line {
	private Point p1, p2;

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
}