import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

	public List<String> find(String sequence) {
		List<File> files = Arrays.asList(new File(pwd()).listFiles());
		List<String> out = new ArrayList<>();

		for (File file : files) {
			out.add(file.toString());
		}

		out.removeIf(a -> !a.contains(sequence));

		return out;
	}

	public File archive(List<String> paths) throws IOException {
		File tmp = File.createTempFile("archive", ".zip");
		FileOutputStream fileOut = new FileOutputStream(tmp);
		ZipOutputStream zipOut = new ZipOutputStream(fileOut);

		for (String path : paths) {
			FileInputStream inputStream = new FileInputStream(String.valueOf(this.path.resolve(path)));
			ZipEntry zipEntry = new ZipEntry(Paths.get(path).getFileName().toString());
			zipOut.putNextEntry(zipEntry);
			byte[] buffer = new byte[1024];

			for (int x = inputStream.read(buffer); x >= 0; x = inputStream.read(buffer)) {
				zipOut.write(buffer, 0, x);
			}
			inputStream.close();
		}

		return tmp;
	}
}
