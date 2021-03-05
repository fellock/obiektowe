public class Polygon {
	private Point[] points;
	private Style style;

	public Polygon(int vert, Style style) {
		points = new Point[vert];
		this.style = style;
	}

	public Polygon(Style style, Point[] points) {
		this(0, style);
		this.points = points;
	}

	public void setPoint(int index, Point p) {
		points[index] = p;
	}

	public void setPoints(Point[] newPoints) {
		points = newPoints;
	}

	public String getPoints() {
		String str = "";

		for (Point p : points) {
			str += p.x + "," + p.y + " ";
		}

		return str;
	}

	public String toSvg() {
		return String.format("<polygon points=\"%s\" style=\"%s\" />", getPoints(), style.toSvg());
	}

	public Point rightBottom() {
		double tempX = 0.;
		double tempY = 0.;

		for (Point point : points) {
			tempX = Math.max(tempX, point.x);
			tempY = Math.max(tempY, point.y);
		}

		return new Point(tempX, tempY);
	}
}