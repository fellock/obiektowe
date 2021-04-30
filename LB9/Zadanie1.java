public class Zadanie1 {
	public static void main(String[] args) {
		FileCommander fileCommander = new FileCommander();

		System.out.println(fileCommander.pwd());
		fileCommander.cd("Documents");
		System.out.println(fileCommander.pwd());
	}
}
