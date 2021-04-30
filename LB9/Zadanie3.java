public class Zadanie3 {
	public static void main(String[] args) {
		FileCommander fileCommander = new FileCommander();
		fileCommander.find("txt").forEach(a -> System.out.println(a));
	}
}
