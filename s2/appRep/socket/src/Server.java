
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        System.out.println("Server class start ");



        Socket socketClientRecieve;
        BufferedReader contentRecieved;
        ServerSocket serveur;
        Socket socketClientSend;
        PrintWriter contentSended;
        /*******     recieve message    *////
        float resultat = 0 ;
        try{
            socketClientRecieve = new Socket("127.0.0.1",1253);
            contentRecieved = new BufferedReader(new InputStreamReader(socketClientRecieve.getInputStream()));
            String string = null;
            float x = 0 ;
            float y = 0 ;
            char m ;
            int i =  0 ;
            while(string == null){
                string = contentRecieved.readLine();
            }
            for( i = 0 ; i < string.length() ; i++){
                if((string.charAt(i) == '+')||(string.charAt(i) == '-')||(string.charAt(i) == '*')||(string.charAt(i) == '/')){
                    break;
                }
            }
            m = string.charAt(i);

            x = Float.parseFloat(string.substring(0,i));

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
        }catch(IOException e){
            System.out.println("Server class Error from try ,  port: 1253 ");
        }
        String st = resultat+"";
        /***  Send result ***/
        try{
            serveur = new ServerSocket(1252);
            socketClientSend = serveur.accept();
            contentSended = new PrintWriter(new OutputStreamWriter(socketClientSend.getOutputStream()));
            contentSended.println(st);
            contentSended.close();
        }catch (IOException e){
            System.out.println("Server class Error from try ,  port: 1252 ");
        }
    }
}
