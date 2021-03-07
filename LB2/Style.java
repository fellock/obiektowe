public class Style {
	public final String fillColor, strokeColor;
	public final Double strokeWidth;

	public Style(String fillColor, String strokeColor, Double strokeWidth) {
		this.fillColor = fillColor != null ? fillColor : "none";
		this.strokeColor = strokeColor != null ? strokeColor : "black";
		this.strokeWidth = strokeWidth != null ? strokeWidth : 1.;
	}

	public String toSvg() {
		String fillColor, strokeColor, strokeWidth;

		fillColor = this.fillColor != null ? this.fillColor : "none";
		strokeColor = this.strokeColor != null ? this.strokeColor : "black";
		strokeWidth = this.strokeWidth != null ? this.strokeWidth.toString() : "1";

		return String.format("fill: %s;stroke: %s;stroke-width: %s", fillColor, strokeColor, strokeWidth);
	}

}
