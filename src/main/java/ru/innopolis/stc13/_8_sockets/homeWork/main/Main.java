package ru.innopolis.stc13._8_sockets.homeWork.main;

import ru.innopolis.stc13._8_sockets.homeWork.client.Client;
import ru.innopolis.stc13._8_sockets.homeWork.server.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Запустить программу в режиме сервера(s) или клиента(c)? ");
        while (true) {
            char answer = Character.valueOf(scanner.nextLine().charAt(0));
            if(answer == 's') {
                new Server();
                break;
            } else if (answer == 'c') {
                new Client();
                break;
            } else {
                System.out.println("Error");
            }
        }
    }
}
