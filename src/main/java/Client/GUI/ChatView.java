package Client.GUI;

import Client.App;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.invoke.empty.Empty;

import javax.swing.*;

public class ChatView extends Application {
    private Button btSend;
    private TextField tfMessages;
    private TextField tfMessage;

    private App app;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        tfMessages = new TextField();
        tfMessages.setPrefHeight(300);
        tfMessages.setPrefWidth(500);
        tfMessage = new TextField();
        tfMessage.setPrefHeight(50);
        tfMessage.setPrefWidth(500);
        btSend = new Button("Send");
        btSend.setPrefSize(100, 50);
        btSend.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    btSend_Click(event);
                } catch (Exception ex) {
                    showAlert(ex);
                }
            }
        });

        grid.add(tfMessages, 1, 1, 1, 1);
        grid.add(tfMessage, 1, 2, 1, 1);
        grid.add(btSend, 2, 2, 1, 1);

        Group root = new Group();
        Scene scene = new Scene(root, 800, 400);

        root.getChildren().add(grid);

        primaryStage.setTitle("MSN Messenger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void btSend_Click(ActionEvent event) {
        if(tfMessage.getText() != "") {
            tfMessages.setText(tfMessages.getText() + "/n" + app.getUser().getName() + ": " + tfMessage.getText());
        }
    }

    private void showAlert(Exception exception) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(exception.getMessage());
        alert.show();
    }

    public void setApp(App app) {
        this.app = app;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
