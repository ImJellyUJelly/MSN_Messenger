package Client.GUI;

import Server.Server;
import Client.App;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class LoginView extends Application {
    private Label lbUsername;
    private Label lbPassword;
    private TextField tfUsername;
    private PasswordField tfPassword;
    private Button btLogin;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Server server = new Server();

        // Make de grid lines visible
        // grid.setGridLinesVisible(true);

        lbUsername = new Label("Username: ");
        tfUsername = new TextField();

        lbPassword = new Label("Password: ");
        tfPassword = new PasswordField();
        btLogin = new Button("Sign in");
        btLogin.setPrefWidth(75);
        btLogin.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    btLogin_Click(event);
                    primaryStage.close();
                } catch (Exception ex) {
                    showAlert(ex);
                }
            }
        });

        grid.add(lbUsername, 14, 26, 4, 1);
        grid.add(tfUsername, 18, 26, 25, 1);

        grid.add(lbPassword, 14, 27, 4, 1);
        grid.add(tfPassword, 18, 27, 25, 1);
        grid.add(btLogin, 41, 29, 1, 1);

        Socket socket = null;
        int portNumber = 4567;
        try {
            socket = new Socket("127.0.0.1", portNumber);
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        Group root = new Group();
        Scene scene = new Scene(root, 750, 600);

        root.getChildren().add(grid);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void btLogin_Click(ActionEvent event) throws Exception {
        try {
            String username;
            String password;
            username = tfUsername.getText();
            password = tfPassword.getText();
            if (tfUsername.getText() != null && !tfUsername.getText().isEmpty()) {
                if (tfPassword.getText() != null && !tfPassword.getText().isEmpty()) {
                    App app = new App();
                    app.login(username, password);

                    MSNView view = new MSNView();
                    view.setApp(app);

                    view.start(new Stage());
                } else {
                    throw new Exception("Use a valid username and/or password.");
                }
            } else {
                throw new Exception("Use a valid username and/or password.");
            }
        } catch(SQLException sex) {
            showAlert(sex);
        } catch (Exception ex) {
            showAlert(ex);
        }
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
