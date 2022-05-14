import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    // Define the port on which the server is listening
    public static int port = 8200;
    private static SimpleServer instance = null;

    public static boolean keepRunning = true;
    public static ServerSocket serverSocket;

    public static boolean isKeepRunning() {
        return keepRunning;
    }

    public static void setKeepRunning(boolean keepRunning) {
        SimpleServer.keepRunning = keepRunning;
    }

    public SimpleServer() throws IOException {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a client ...");
            while (keepRunning) {

                Socket socket = serverSocket.accept();
                System.out.println("New client arrived..");
                new ClientThread(socket).start();
            }

        }   catch (Exception e) {
            System.out.println("Server closed..");
        }
        finally {
            System.exit(0);
        }
    }

    public static SimpleServer getInstance(int port) throws IOException {
        if (instance == null) {
            instance = new SimpleServer();
        }
        return instance;
    }




    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
    }

}
