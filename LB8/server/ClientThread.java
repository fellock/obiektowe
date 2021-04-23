import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	private Socket socket;
	private PrintWriter writer;
	private Server server;
	private String username;

	public String getUsername() {
		return username;
	}

	public ClientThread(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
	}

	@Override
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			writer = new PrintWriter(output, true);

			while (true) {
				String message = reader.readLine();

				if (isCommand(message)) {
					runCommand(message);
				}

				server.broadcast(this, message);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String message) {
		writer.println(message);
	}

	private boolean isCommand(String message) {
		return (!message.isEmpty() && message.startsWith("$") && message != null);
	}

	private void runCommand(String message) {
		String[] messageList = message.split(" ");
		String command = messageList[0];

		switch (command) {
			default:
				System.out.println("ERROR: Nieznana komenda");
				break;
			case "$login":
				username = messageList[1];
				System.out.println("Ustawiono nick na " + username);
				break;
		}
	}
}
