import java.util.Arrays;
import java.util.Locale;
import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
	private Polygon[] polygons = new Polygon[0];

	public void addPolygon(Polygon polygon) {
		polygons = Arrays.copyOf(polygons, polygons.length + 1);
		polygons[polygons.length - 1] = polygon;
	}

	public void saveHtml(String path) {
		try {
			FileWriter writer = new FileWriter(path);
			Point rB = this.rightBottom();

			writer.write("<html><body>");
			writer.write(String.format(Locale.US, "<svg height=\"%f\" width=\"%f\">", rB.y, rB.x));
			for (Polygon polygon : polygons) {
				writer.write(polygon.toSvg());
			}
			writer.write("</svg></body></html>");

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Point rightBottom() {
		double tempX = 0.;
		double tempY = 0.;

		for (Polygon polygon : polygons) {
			Point tempPoint = polygon.rightBottom();

			tempX = Math.max(tempX, tempPoint.x);
			tempY = Math.max(tempY, tempPoint.y);
		}

		return new Point(tempX, tempY);
	}


}
