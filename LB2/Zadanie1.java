/* Zdefiniuj klasę Style o finalnych, publicznych polach klasy String: fillColor, strokeColor oraz Double: strokeWidth. Napisz konstruktor trójargumentowy ustawiający te wartości. Należy dopuścić ustawienie polom wartości null. Napisz publiczną metodę toSvg() zwracającą napis, który można umieścić w opcji style tagu <polygon>.

Zmodyfikuj klasę Polygon dodając do jej konstruktora argument Style i modyfikując jej metodę toSvg(), aby uzględniała styl. Jeżeli mają wartość null, należy narysować przezroczysty (fillColor) wielokąt, z czarnym obrysem (strokeColor) o grubości jednego piksela (strokeWidth). */
public class Zadanie1 {
	public static void main(String[] args) {
		Polygon P = new Polygon(5, new Style("blue", "purple", 10.));
		Point[] arr = { new Point(0, 0), new Point(0, 100), new Point(120, 120), new Point(200, 70),
				new Point(250, 40) };
		P.setPoints(arr);
		P.toSvg();
	}
}