import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    TextField text;
    @FXML
    Label log;
    @FXML
    Button verser,avoire,retirer,connection;
    IRemote obj;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        connection.setOnAction(event -> {
            try {
        /*Registry registry = LocateRegistry.getRegistry("192.168.43.239", 1099);
        IRemote objet = (IRemote) registry.lookup("objet-banque");*/
                String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":9024/IRemote";
                 obj = (IRemote) Naming.lookup(url);
                log.setText("Log : Connecte avec succes");

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        verser.setOnAction(event -> {
    try {
        /*Registry registry = LocateRegistry.getRegistry("192.168.43.239", 1099);
        IRemote objet = (IRemote) registry.lookup("objet-banque");*/
        double solde = Float.parseFloat(text.getText());
        log.setText("Log : Montant Verse --- "+obj.verser(solde)+"DA");
    } catch (Exception e) {
        e.printStackTrace();
    }
});
        retirer.setOnAction(event -> {
    try {
        /*Registry registry = LocateRegistry.getRegistry("192.168.43.239", 1099);
        IRemote objet = (IRemote) registry.lookup("objet-banque");*/
        double solde = Float.parseFloat(text.getText());
        log.setText("Log : Montant Retire --- "+obj.retirer(solde)+"DA");
    } catch (Exception e) {
        e.printStackTrace();
    }
});
        avoire.setOnAction(event -> {
    try {

        log.setText("Log : Solde Actuel --- "+obj.avoire()+"DA");
    } catch (Exception e) {
        e.printStackTrace();
    }
});

    }
}
