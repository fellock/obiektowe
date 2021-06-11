import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static PrintWriter clientOutputStream;
	private static Game game = new Game();

	public Server(int port) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Game server started on port " + port);
			System.out.println("Waiting for another player");
			Socket clientSocket = serverSocket.accept();
			new RequestHandler(clientSocket).start();
			System.out.println("Connected with another player!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class RequestHandler extends Thread {
		Socket socket;
		BufferedReader reader;
		PrintWriter response;

		public RequestHandler(Socket clientSocket) {
			try {
				socket = clientSocket;
				InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(isReader);
				response = new PrintWriter(socket.getOutputStream());
				clientOutputStream = response;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void writeToClient(PrintWriter response, String data) {
			response.println(data);
			response.flush();
		}

		private void writeToClient(String data) {
			response.println(data);
			response.flush();
		}

		@Override
		public void run() {
			String message = null;
			try {
				while ((message = reader.readLine()) != null) {
					int markedPosition = -1;
					try {
						markedPosition = Integer.parseInt(message);
						String result = game.makeMove(markedPosition);
						writeToClient(result);
					} catch (Exception ex) {
						writeToClient("Invalid Input! ");
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
