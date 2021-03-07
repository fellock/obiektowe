import java.util.Locale;

public class Ellipse extends Shape {
	private Point center;
	private double rX, rY;

	public Ellipse(Style style, Point center, double rX, double rY) {
		super(style);
		this.center = center;
		this.rX = rX;
		this.rY = rY;
	}

	public String toSvg() {
		return String.format(Locale.US, "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" style=\"%s\"", center.x,
				center.y, rX, rY, style.toSvg());
	}

	public Point rightBottom() {
		return new Point(center.x + rX + style.strokeWidth, center.y + rY + style.strokeWidth);
	}
}
