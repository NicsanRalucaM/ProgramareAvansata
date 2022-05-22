public class Main {
    public static void main(String[] args) throws Exception {
        Server server = Server.getInstance(7777);
        server.run();
    }
}
