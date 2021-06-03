package mypackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {


        Socket socketClientRecieve;
        BufferedReader contentRecieved;


        ServerSocket serveur;
        Socket socketClientSend;


        PrintWriter contentSended;

        /*******     recieve message    *////
        float resultat = 0 ;
        try{
            socketClientRecieve = new Socket("192.168.43.12",10001);
            contentRecieved = new BufferedReader(new InputStreamReader(socketClientRecieve.getInputStream()));
            String string = null;
            float x = 0 ;
            float y = 0 ;
            char m ;
            int i =  0 ;
            while(string == null){
                string = contentRecieved.readLine();

                for( i = 0 ; i < string.length() ; i++){
                    if((string.charAt(i) == '+')||(string.charAt(i) == '-')||(string.charAt(i) == '*')||(string.charAt(i) == '/')){
                        break;
                    }
                }
                m = string.charAt(i);

                x = Float.parseFloat(string.substring(0,i));
                System.out.println("im i  > "+i);
                y = Float.parseFloat(string.substring(i+1,string.length()));
                if(m == '+'){
                    resultat  = x + y ;
                }else if(m == '-'){

                    resultat  = x - y ;
                }
                else if(m == '*'){

                    resultat  = x * y ;
                }
                else if(m == '/'){

                    resultat  = x / y ;
                }
                else{
                    resultat = 0;
                }
            }
        }catch(IOException e){
        }





        //////***** another method *////
        // inputs
        /*
       // first
        System.out.println("give the first number");
        int x = scanner.nextInt();

        System.out.println("ADD METHOD + or - or * or /");
        char m = scanner.next().charAt(0);

        System.out.println("give the first number");
        int y = scanner.nextInt();
        */

        /******   fin another method ****///


        ///**********   send  message    ****/////


        String st = resultat+"";
        System.out.println(">>>> " + st);
        try{
            serveur = new ServerSocket(10001);
            socketClientSend = serveur.accept();
            contentSended = new PrintWriter(new OutputStreamWriter(socketClientSend.getOutputStream()));

           /*
            // first method
            contentSended.println(x+""+m+""+y);
            */
            // second method
            System.out.println(">>>> " + st);

            contentSended.println(st);
            contentSended.close();
        }catch (IOException e){

            System.out.println("error ");
        }
    }
}
