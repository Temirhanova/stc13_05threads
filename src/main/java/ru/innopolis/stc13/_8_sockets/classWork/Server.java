package ru.innopolis.stc13._8_sockets.classWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer SERVER_PORT = 4999;

    public Server() {
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
             Socket socket = serverSocket.accept();
             InputStream fromClient = socket.getInputStream();
             OutputStream toClient = socket.getOutputStream()){
            BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(toClient));
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
            String message = "";
            while ((message = clientReader.readLine()) != null) {
                System.out.println(message);
                clientWriter.write("Message \"" + message + "\" is received by server");
                clientWriter.newLine();
                clientWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
