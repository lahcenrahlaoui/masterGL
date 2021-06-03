
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Client{

    public static void main(String[] args) {

        System.out.println("Client class start ");

        ServerSocket serveur;
            Socket socketClientSend;
            PrintWriter contentSent;
            BufferedReader contentRecieved;
            Socket socketClientRecieve;
            Scanner scanner = new Scanner(System.in);
            System.out.print("enter opiration like this ( 4+3  or 9/2 )  :  ");
            String st;
            st = scanner.nextLine();

        /******      Send message   *******/
        try{
                serveur = new ServerSocket(1253);
                socketClientSend = serveur.accept();
                contentSent = new PrintWriter(new OutputStreamWriter(socketClientSend.getOutputStream()));
                contentSent.println(st);
                contentSent.close();
            }catch (IOException e){
                System.out.println("Client class Error from try ,  port: 1253 ");
            }


            // recieve resultat
            try{
                socketClientRecieve = new Socket("127.0.0.1",1252);
                contentRecieved = new BufferedReader(new InputStreamReader(socketClientRecieve.getInputStream()));
                String string = null;
                int x = 0 ;
                int y = 0 ;
                char m ;
                int i = 0 ;
                while(string == null){
                    string = contentRecieved.readLine();
                    System.out.println("resultat = "+string);
                }
            }catch(IOException e){
                System.out.println("Client class Error from try ,  port: 1252 ");
            }
    }
}
