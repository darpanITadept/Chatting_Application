//Clinet Side Thread 
//------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {

    private Socket socket;
    private BufferedReader input;
    private ChatingAppClient chatClient;

    public ClientThread(Socket socket, ChatingAppClient chatClient) throws IOException {
        this.socket = socket;
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        try {
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String response = input.readLine();
                chatClient.displayMessage(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}