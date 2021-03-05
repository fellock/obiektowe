import java.util.Arrays;
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
			writer.write("<html><body>");
			writer.write("<svg>");

			for (Polygon polygon : polygons) {
				writer.write(polygon.toSvg());
			}

			writer.write("</svg></body></html>");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
