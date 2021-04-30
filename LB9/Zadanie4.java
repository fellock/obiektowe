import java.io.IOException;

public class Zadanie4 {
	public static void main(String[] args) throws IOException {
		FileCommanderCLI commander = new FileCommanderCLI(System.in, System.out);

		commander.eventLoop();
	}
}