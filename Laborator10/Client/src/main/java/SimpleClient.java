import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {
    private Socket serverSocket;
    private PrintWriter out;
    private BufferedReader in;

    public SimpleClient(String ipAddress, int port) throws Exception {
        this.serverSocket = new Socket(ipAddress, port);
        this.out = new PrintWriter(serverSocket.getOutputStream());
        this.in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
    }

    public void getStarted() throws Exception {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {

                String command = scanner.nextLine();

                out.println(command);
                out.flush();

                if (command.equals("exit")) {
                    serverSocket.close();
                    in.close();
                    out.close();
                    System.exit(0);
                }

                String response = in.readLine();
                System.out.println(response);
                if(response.equalsIgnoreCase("Server will be shutdown asap ..."))
                {
                    serverSocket.close();
                    in.close();
                    out.close();
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8200; // The server's port
        SimpleClient simpleClient = new SimpleClient(serverAddress, PORT);
        simpleClient.getStarted();

    }
}
