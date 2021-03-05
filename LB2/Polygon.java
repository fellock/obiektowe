public class Polygon extends Shape {
	private Point[] points;

	public Polygon(int vert, Style style) {
		super(style);
		points = new Point[vert];
	}

	public Polygon(Style style, Point[] points) {
		this(0, style);
		this.points = points;
	}

	//! do naprawienia
	public static Polygon square(Line diagonal, Style style){
		Point center = new Point((diagonal.getP1().x + diagonal.getP2().x)/2, (diagonal.getP1().y + diagonal.getP2().y)/2);
		Polygon result = new Polygon(4, style);
		Line[] arr = Line.perpendicular(diagonal, center, diagonal.getLength()/2);
		result.setPoint(0, diagonal.getP1());
		result.setPoint(1, arr[0].getP2());
		result.setPoint(2, diagonal.getP2());
		result.setPoint(3, arr[1].getP2());
		return result;
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