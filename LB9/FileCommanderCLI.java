import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class FileCommanderCLI {
	private BufferedReader reader;
	private BufferedWriter writer;
	private FileCommander fileCommander;
	private boolean active = false;

	public FileCommanderCLI(InputStream inputStream, OutputStream outputStream) {
		this.reader = new BufferedReader(new InputStreamReader(inputStream));
		this.writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		this.fileCommander = new FileCommander();
	}

	public void eventLoop() throws IOException {
		active = true;
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			runCommand(line);
			writer.flush();
			if (!active) {
				break;
			}
		}
	}

	private void runCommand(String line) throws IOException {
		List<String> args = Arrays.asList(line.split(" "));

		switch(args.get(0)) {
			default:
				writer.write("ERROR: unknown command\n");
				break;
			case "quit":
				writer.write("Quitting...\n");
				active = false;
				break;
			case "pwd":
				if (args.size() == 1) {
					writer.write(fileCommander.pwd() + "\n");
				} else {
					writer.write("ERROR: wrong number of arguments, usage: pwd\n");
				}
				break;
			case "cd":
				if (args.size() == 2) {
					fileCommander.cd(args.get(1));
				} else {
					writer.write("ERROR: wrong number of arguments, usage: cd <path>\n");
				}
				break;
			case "ls":
				if (args.size() == 1) {
					for (String s : fileCommander.ls()) {
						writer.write(s + "\n");
					}
				} else {
					writer.write("ERROR: wrong number of arguments, usage: ls\n");
				}
				break;
			case "find":
				if (args.size() == 2) {
					for (String s : fileCommander.find(args.get(1))) {
						writer.write(s + "\n");
					}
				} else {
					writer.write("ERROR: wrong number of arguments, usage: find <sequence>\n");
				}
				break;
		}
	}

}
