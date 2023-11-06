package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        try {

            BufferedReader inputTastiera = new BufferedReader(new InputStreamReader(System.in));
            Socket s = new Socket("localhost", 3000);
            System.out.println("Connessione effettuata. Digita ESCI per uscire.");

            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            do{
                System.out.println("Inserisci la nota da memorizzare o digita LISTA per visualizzare le note salvate");
                String stringa = inputTastiera.readLine();
                
                if(stringa.equals("LISTA")){
                    out.writeBytes("@\n");
                    String lista = in.readLine();
                    System.out.println(lista);
                }else if(stringa.equals("ESCI")){
                    out.writeBytes("Q\n");
                    break;
                }else{
                    out.writeBytes(stringa + "\n");
                }

            }while(true);
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Qualcosa è andato storto");
            System.exit(1);
        }
    }
}
