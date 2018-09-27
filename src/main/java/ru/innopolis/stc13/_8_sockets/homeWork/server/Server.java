package ru.innopolis.stc13._8_sockets.homeWork.server;

import ru.innopolis.stc13._8_sockets.homeWork.main.Const;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    ArrayList<Connection> connections = new ArrayList<>();
    public Server() {
        System.out.println("Start Server");
        try(ServerSocket server = new ServerSocket(Const.port)){
            while (true) {
                Socket socket = server.accept();
                Connection con = new Connection(socket);
                connections.add(con);
                con.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        private String name = "";
        public Connection(Socket socket) {
            this.socket = socket;
            System.out.println("Create connection thred");
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                name = in.readLine();
                for(Connection c : connections) {
                    c.out.println(name + " cames now");
                }
                String str = "";
                while (true) {
                    str = in.readLine();
                    if(str.equals("exit")) break;

                    for(Connection c : connections) {
                        c.out.println(name + ": " + str);
//                        System.out.println(name + ": " + str);
                    }
                }

                for(Connection c : connections) {
                    c.out.println(name + " has left.");
//                    System.out.println(name + " has left.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


