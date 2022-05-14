import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

import static java.lang.System.out;

class ClientThread extends Thread {
    private Socket socket;
    private boolean keepRunning;
    private PrintWriter out;
     private BufferedReader in;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        this.keepRunning = true;
        out = new PrintWriter(socket.getOutputStream());
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public void run() {

        try {


            while (keepRunning) {
                socket.setSoTimeout(60 * 1000);
                String message = in.readLine();
                System.out.println(message);

                handleMessage(message);
            }
        } catch (SocketTimeoutException e) {
            out.println("You have been disconnected..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleMessage(String message) throws IOException {


        if (message.equalsIgnoreCase("register"))
            Registration();
        else if (message.equalsIgnoreCase("login"))
            Login();

        else if (message.equalsIgnoreCase("friend"))

            Friends();

        else if (message.equalsIgnoreCase("send"))

            Sending();
        else if (message.equalsIgnoreCase("read"))

            Reading();

        else if (message.equalsIgnoreCase("exit"))

            Exit();
        else if (message.equalsIgnoreCase("stop"))


            Stop();

    }
    private void Registration() {


            String response = "Registration";
            System.out.println(response);
            out.println(response);
            out.flush();
        }

    private void Login() {


            String response = "Login";
            System.out.println(response);
            out.println(response);
            out.flush();
        }

    private void Friends() {

        out.println("Friend list updated..");
        out.flush();
    }
    private void Sending() {

        //System.out.println("Sending..");
        out.println("Sending ..");
        out.flush();
    }
    private void Reading() {

        out.println("Reading ..");
        out.flush();
    }

    private void Exit() {

        keepRunning = false;
    }

    private void Stop() throws IOException {

        if (!SimpleServer.keepRunning) {

            out.println("Server will be shutdown asap ...(command from other player)");
            out.flush();



        }

        SimpleServer.serverSocket.close();
        SimpleServer.setKeepRunning(false);
        System.out.println(SimpleServer.keepRunning);

        out.println("Server will be shutdown asap ...");
        out.flush();

       // System.exit(0);


    }

}
