import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Server instance = null;
    private int port = 0;

    public static boolean keepRunning;
    public static ServerSocket serverSocket;

    private Server(int port) {
        this.port = port;
        keepRunning = true;
    }

    public static Server getInstance(int port) {
        if (instance == null) {
            instance = new Server(port);
        }
        return instance;
    }

    public void run() throws IOException {
        try {
            System.out.println("Waiting for clients..");
            serverSocket = new ServerSocket(port);

            initializeState();

            while (keepRunning) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client arrived..");
                new ClientRequestThread(clientSocket).start();
            }
        } catch (Exception e) {
            System.out.println("Server closed..");
        }
    }

    public static SocialNetwork readObjectFromFile() {
        SocialNetwork object1 = null;

        try {
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            object1 = (SocialNetwork) in.readObject();

            in.close();
            file.close();

        } catch (Exception e) {
            // e.printStackTrace();
        }
        return object1;
    }

    public static void writeObjectToFile(SocialNetwork state) {

        try {
            FileOutputStream file = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(state);

            out.close();
            file.close();

            System.out.println("Object has been writing");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    private static void initializeState() {
        SocialNetwork state = Server.readObjectFromFile();
        if (state == null) {
            ClientRequestThread.state = new SocialNetwork();
        } else {
            state.showUsers();
            ClientRequestThread.state = state;
        }
    }
}
