package mypackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Client {



    public static void main(String[] args) {

        ServerSocket serveur;
        Socket socketClientSend;
        PrintWriter contentSended;
        Scanner scanner = new Scanner(System.in);

        System.out.print("give the equation like  52+3 or 21/3 :  ");
        String st = scanner.nextLine();
        System.out.print(" *** Now go and excute the Client class *** ");


        try{
            serveur = new ServerSocket(10001);
            socketClientSend = serveur.accept();
            contentSended = new PrintWriter(new OutputStreamWriter(socketClientSend.getOutputStream()));

            /* // first method
                contentSended.println(x+""+m+""+y);
              */
            contentSended.println(st);
            contentSended.close();
        }catch (IOException e){

            System.out.println("error ");
        }



        BufferedReader contentRecieved;
        Socket socketClientRecieve;



        try{
            socketClientRecieve = new Socket("192.168.43.12",10001);
            contentRecieved = new BufferedReader(new InputStreamReader(socketClientRecieve.getInputStream()));
            String string = null;
            int x = 0 ;
            int y = 0 ;
            char m ;
            int i =  0 ;
            int resultat = 0;
            while(string == null){
                string = contentRecieved.readLine();
                System.out.println("the result :  " +  resultat);
            }

        }catch(IOException e){

        }


    }
}
