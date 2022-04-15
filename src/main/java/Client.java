import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        //String host = "127.0.0.1";
        String host = "netology.ru";
        int port = 80;
        String user = "Roman";
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println("now connected to " + clientSocket.getRemoteSocketAddress());
            out.println(user);
            String resp = in.readLine();
            System.out.println("Server response: \n" + resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}