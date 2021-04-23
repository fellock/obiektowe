import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private ServerSocket socket;
	private List<Client> clients = new ArrayList<>();

	public Server(int port) {
		try {
			this.socket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listen() {
		while (true) {
			try {
				Socket clientSocket = socket.accept();
				Client clientThread = new Client(clientSocket, this);
				clients.add(clientThread);
				clientThread.start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void broadcast(Client from, String message) {
		for (Client client: clients) {
			if (client != from) {
				client.send(message);
			}
		}
	}
}
