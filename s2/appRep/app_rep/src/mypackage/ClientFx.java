package mypackage;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;




public class ClientFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World!");
        Button btn0 = new Button();
        Button btn1 = new Button();
        btn0.setText("Say 'Hello World'");
        btn0.setOnAction((EventHandler<ActionEvent>) event -> System.out.println("Hello World!"));
        btn1.setText("dont say  ");
        btn1.setOnAction((EventHandler<ActionEvent>) event -> System.out.println("Hello World!"));

        StackPane root = new StackPane();

        Scene scene = new Scene(new Group(),  700, 550);
        scene.getStylesheets().add("../css/stylesheet.css");

        root.getChildren().add(btn0);
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }

}
