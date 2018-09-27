package ru.innopolis.stc13._8_sockets.homeWork.client;

import ru.innopolis.stc13._8_sockets.homeWork.main.Const;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client () {
        System.out.println("Start Client");
        Scanner scan = new Scanner(System.in);
        try (Socket socket = new Socket(Const.ip, Const.port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)){
            System.out.println("Введите свой ник:");
            out.println(scan.nextLine());
            Resender resender = new Resender(in);
            resender.start();
            String str = "";
            while (!str.equals("exit")){
                str = scan.nextLine();
                out.println(str);
            }
            resender.setStop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Resender extends Thread {
        private boolean stoped = false;
        BufferedReader in;

        public Resender(BufferedReader in) {
            System.out.println("Create Client thread");
            this.in = in;
        }

        public void setStop() {
            stoped = true;
        }
        @Override
        public void run() {
            try {
                while (!stoped) {
                    if(in.readLine() != null) {
                        String str = in.readLine();
                        System.out.println(str);
                    }

                }
            } catch (IOException e) {
                System.err.println("Ошибка при получении сообщения.");
                e.printStackTrace();
            }
        }
    }

}
