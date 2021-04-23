import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket;
	private PrintWriter writer;

	public ServerThread(String ip, int port) {
		try {
			this.socket = new Socket(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void send(String username, String message) {
		if (isCommand(message)) {
			runCommand(message);
		} else {
			writer.println("$broadcast [" + username + "]: " + message);
		}
	}

	public void login(String message) {
		writer.println("$login " + message);
	}

	private boolean isCommand(String message) {
		return (!message.isEmpty() && message.startsWith("/") && message != null);
	}

	private void runCommand(String message) {
		String[] messageList = message.split(" ", 2);
		String command = messageList[0];
		String argument = messageList[1];

		switch (command) {
			default:
				System.out.println("ERROR: Nieznana komenda");
				break;
		}
	}

}
