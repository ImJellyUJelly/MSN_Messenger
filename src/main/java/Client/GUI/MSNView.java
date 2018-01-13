package Client.GUI;

import Client.App;
import Client.Business.Enums.StatusType;
import Client.Business.IUser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MSNView extends Application {
    private Label lbNaam;
    private Label lbPersonalMessage;
    private Label lbOnlineString;
    private Label lbOfflineString;
    private ComboBox cbStatus;
    private Image iAccountPicture;
    private ListView friendListOnline;
    private ListView friendListOffline;
    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Make de grid lines visible
        //grid.setGridLinesVisible(true);

        lbNaam = new Label(app.getUser().getName());
        lbPersonalMessage = new Label(app.getUser().getPersonalMessage());
        lbOnlineString = new Label("Online vrienden:");
        lbOfflineString = new Label("Offline vrienden:");
        cbStatus = new ComboBox();
        cbStatus.setPrefWidth(200);
        fillComboBox();
        cbStatus.setValue("Online");
        friendListOnline = new ListView();
        friendListOffline = new ListView();
        fillFriendList();
        friendListOnline.setPrefWidth(350);
        friendListOnline.setPrefHeight((friendListOnline.getItems().size() * 50) + 25);

        friendListOnline.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    bt_OpenChat(event);
                } catch (Exception ex) {
                    showAlert(ex);
                }
            }
        });

        friendListOffline.setPrefWidth(350);
        friendListOffline.setPrefHeight((friendListOffline.getItems().size() * 25) + 25);
        //iAccountPicture = new Image("");

        grid.add(lbNaam, 0, 0, 1, 1);
        grid.add(lbPersonalMessage, 0, 1, 1, 1);
        grid.add(cbStatus, 0, 2, 1, 1);
        grid.add(lbOnlineString,0, 3, 1, 1);
        grid.add(friendListOnline, 0, 4, 1,1);
        grid.add(lbOfflineString,0,5, 1, 1);
        grid.add(friendListOffline, 0, 6, 1,1);

        Group root = new Group();
        Scene scene = new Scene(root, 400, 750);

        root.getChildren().add(grid);

        primaryStage.setTitle("MSN Messenger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fillComboBox() {
        for(StatusType type : StatusType.values()) {
            cbStatus.getItems().add(type);
        }
    }

    private void fillFriendList() {
        for(IUser user : app.getUser().getFriendList()) {
            if(user.getStatus() == StatusType.Online || user.getStatus() == StatusType.Busy || user.getStatus() == StatusType.Away) {
                friendListOnline.getItems().add(user);
            } else {
                friendListOffline.getItems().add(user);
            }
        }
    }

    private void bt_OpenChat(MouseEvent event) {
        ChatView view = new ChatView();
        view.start(new Stage());
    }

    private void showAlert(Exception exception) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(exception.getMessage());
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
