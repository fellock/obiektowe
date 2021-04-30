import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCommander {
	private Path path;

	public FileCommander() {
		this.path = Path.of(System.getProperty("user.home"));
	}

	public String pwd() {
		return path.toString();
	}

	public void cd(String path) {
		this.path = this.path.resolve(path);
	}

	public List<String> ls() {
		List<String> files = new ArrayList<>();
		List<String> dirs = new ArrayList<>();

		File current = new File(pwd());

		for (File file : current.listFiles()) {
			if (file.isDirectory()) {
				dirs.add("[" + file.getName() + "]");
			} else {
				files.add(file.getName());
			}
		}

		Collections.sort(dirs);
		Collections.sort(files);

		return Stream.concat(dirs.stream(), files.stream()).collect(Collectors.toList());
	}
}
