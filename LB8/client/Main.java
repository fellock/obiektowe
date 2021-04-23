import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		ServerThread serverThread = new ServerThread("localhost", 1618);
		serverThread.start();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			String username = reader.readLine();
			serverThread.login(username);

			while (true) {
				String message = reader.readLine();
				serverThread.send(username, message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
