import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        Date current = new Date();
        int port = 80;
        System.out.println("Server started -- " + current);
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String name = in.readLine();
            System.out.println("New connection {" + name + " , " + clientSocket.getRemoteSocketAddress() + " }");
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
        }
    }
}