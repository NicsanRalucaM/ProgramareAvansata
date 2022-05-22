import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class ClientRequestThread extends Thread {
    final private Socket clientSocket;
    final private PrintWriter out;
    final private BufferedReader in;

    public static SocialNetwork state;

    private boolean keepRunning;

    public ClientRequestThread(Socket clientSocket) throws Exception {
        this.clientSocket = clientSocket;
        out = new PrintWriter(clientSocket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        keepRunning = true;
    }


    public void run() {
        try {
            while (keepRunning) {
                clientSocket.setSoTimeout(60 * 1000);
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
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handleMessage(String message) throws IOException {
        List<String> tokens = splitIntoTokens(message);

        String keyword = tokens.get(0);

        switch (keyword) {
            case "register":
                tokens.remove(0);
                handleRegistration(tokens);
                break;
            case "login":
                tokens.remove(0);
                handleLogin(tokens);
                break;
            case "friend":
                tokens.remove(0);
                handleFriends(tokens);
                break;
            case "send":
                tokens.remove(0);
                handleSending(tokens);
                break;
            case "read":
                tokens.remove(0);
                handleReading(tokens);
                break;
            case "exit":
                tokens.remove(0);
                handleExit(tokens);
                break;
            case "stop":
                tokens.remove(0);
                handleStop(tokens);
                break;
        }
    }

    private void handleRegistration(List<String> tokens) {
        String username = tokens.get(0);
        if (!state.hasUsername(username)) {
            User newUser = new User(username);
            state.addUser(newUser);

            state.showUsers();

            String response = "User " + username + " was added successfully..";
            System.out.println(response);
            out.println(response);
            out.flush();
        }
    }

    private void handleLogin(List<String> tokens) {
        String username = tokens.get(0);
        if (state.hasUsername(username)) {

            state.setOnline(username);
            name = username;

            String response = "User " + username + " is now online..";
            System.out.println(response);
            out.println(response);
            out.flush();
        }
    }

    private String name;

    private void handleFriends(List<String> tokens) {
        if (state.getOnlineStatus(name)) {
            User user = state.getByUsername(name);
            for (String token : tokens) {
                user.addFriend(token);
            }
        }
        out.println("Friend list updated..");
        out.flush();
    }

    private void handleSending(List<String> tokens) {
        User user = state.getByUsername(name);
        StringBuffer message = new StringBuffer();
        for (String msg : tokens) {
            message.append(msg);
            message.append(" ");
        }
        for (String friend : user.getFriends()) {
            User userFriend = state.getByUsername(friend);
            if (userFriend != null) {
                userFriend.addMessage(name + ": " + message);
            }
        }
        System.out.println("Message sent ..");
        out.println("Message sent ..");
        out.flush();
    }

    private void handleReading(List<String> tokens) {
        User thisUser = state.getByUsername(name);
        out.println(thisUser.getMessages());
        thisUser.setMessageEmpty();
        out.flush();
    }

    private void handleExit(List<String> tokens) {
        User thisUser = state.getByUsername(name);
        thisUser.setOnlineStatus(false);

        state.printUserState();

        keepRunning = false;
    }

    private void handleStop(List<String> tokens) throws IOException {
        if (!Server.keepRunning) {
            out.println("Server will be shutdown asap ...(command from other player)");
            out.flush();
            return;
        }

//        Server.serverSocket.close();
        //System.out.println("helloo");
        out.println("Server will be shutdown asap ...");
        out.flush();
        User thisUser = state.getByUsername(name);
        thisUser.setOnlineStatus(false);
        keepRunning = false;

        new Thread(() -> {
            //System.out.println("helloo");
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("heloooo");
                if (state.checkIfAllUsersAreDisconnected()) {
                    Server.writeObjectToFile(state);
                    System.exit(0);
                }
                // System.out.println("daaa");
                state.printUserState();
            }
        }).start();

    }

    private List<String> splitIntoTokens(String content) {
        StringTokenizer tokenizer = new StringTokenizer(content);
        List<String> list = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list;
    }
}
