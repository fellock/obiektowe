package server;

public class ServerMain {
	public static void main(String[] args) {
		Server server = new Server(1618);
		server.listen();
	}
}
