public class Zadanie2 {
	public static void main(String[] args) {
		FileCommander fileCommander = new FileCommander();
		fileCommander.ls().forEach(a -> System.out.println(a));
	}
}
