package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private ServerSocket socket;
	private List<ClientThread> clients = new ArrayList<>();

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
				ClientThread clientThread = new ClientThread(clientSocket, this);
				clients.add(clientThread);
				clientThread.start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void broadcast(ClientThread from, String message) {
		for (ClientThread client: clients) {
			if (client != from) {
				client.send(message);
			}
		}
	}
}
