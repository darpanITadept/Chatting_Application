import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.scene.control.TextArea;

public class ChatingAppServerThread extends Thread {

    private Socket socket;
    private PrintWriter m_writer;
    private ArrayList<ChatingAppServerThread> threadArr;
    private TextArea logTextArea;

    public ChatingAppServerThread(Socket socket, ArrayList<ChatingAppServerThread> t, TextArea logTextArea) {
        this.socket = socket;
        this.threadArr = t;
        this.logTextArea = logTextArea;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            m_writer = new PrintWriter(socket.getOutputStream(), true);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            logMessage("Connection from Socket[add=" + socket.getInetAddress() + ",port=" + socket.getPort()
                    + ",localport=" + socket.getLocalPort() + "]at " + dtf.format(now));

            while (true) {
                String echoString = input.readLine();

                logMessage("Received Client Input: " + echoString);

                if (echoString.equals("exit")) {
                    break;
                }

                for (int i = 0; i < threadArr.size(); i++) {
                    threadArr.get(i).m_writer.println(echoString);
                }
            }
        } catch (IOException e) {
            logMessage("Oooops " + e.getMessage());
        } finally {
            try {
                socket.close();} catch (IOException e) {
                    logMessage("Error closing socket: " + e.getMessage());
                }
            }
        }

        private void logMessage(String message) {
            javafx.application.Platform.runLater(() -> {
                logTextArea.appendText(message + "\n");
            });
        }
    }

