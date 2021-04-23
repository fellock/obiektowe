import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
	private Socket socket;
	private PrintWriter writer;
	private Server server;

	public Client(Socket socket, Server server) {
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
				System.out.println(message);
				server.broadcast(this, message);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String message) {
		writer.println(message);
	}
}
