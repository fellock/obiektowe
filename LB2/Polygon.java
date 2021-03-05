public class Polygon {
	private Point[] points;
	private Style style;

	public Polygon(int vert, Style style) {
		points = new Point[vert];
		this.style = style;
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

	public void toSvg() {
		System.out.println(String.format(
				"<svg height=\"210\" width=\"500\"><polygon points=\"%s\" style=\"%s\" /></svg>",
				getPoints(), style.toSvg()));
	}
}