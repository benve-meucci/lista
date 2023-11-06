package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {

            System.out.println("Server avviato...");
            ServerSocket server = new ServerSocket(3000);
            while (true) {
                Socket s = server.accept();
                ServerThread thread = new ServerThread(s);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
        }
    }
}
