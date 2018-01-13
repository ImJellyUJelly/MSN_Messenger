package Client.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChatView extends Application{
    private Button btSend;
    private ListView lvMessages;
    private TextField tfMessage;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        lvMessages = new ListView();
        lvMessages.setPrefHeight(300);
        lvMessages.setPrefWidth(500);
        tfMessage = new TextField();
        tfMessage.setPrefHeight(50);
        tfMessage.setPrefWidth(500);

        grid.add(lvMessages,1,1,1,1);
        grid.add(tfMessage,1,2,1,1);

        Group root = new Group();
        Scene scene = new Scene(root, 800, 400);

        root.getChildren().add(grid);

        primaryStage.setTitle("MSN Messenger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
