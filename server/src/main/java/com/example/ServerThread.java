package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket s;

    public ServerThread(Socket s){
        this.s = s;
    }
    
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String lista = "";

            do{
                String comando = in.readLine();
                if(comando.equals("@")){
                    out.writeBytes(lista + "\n");
                }else if(comando.equals("Q")){
                    break;
                }else{
                    lista = lista + comando + ";";
                }
            }while(true);
            s.close();
        } catch( Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
