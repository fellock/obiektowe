package server;

public class Main {
	public static void main(String[] args) {
		Server server = new Server(1618);
		server.listen();
	}
}
