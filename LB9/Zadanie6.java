import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zadanie6 {
	public static void main(String[] args) throws IOException {
		FileCommander commander = new FileCommander();

		List<String> files = new ArrayList<>();
		files.add("plik 1.txt");
		files.add("plik 2.rtf");

		System.out.println(commander.archive(files).toString());

	}
}
