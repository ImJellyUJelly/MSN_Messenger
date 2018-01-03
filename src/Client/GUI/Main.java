package Client.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Label lbUsername;
    private Label lbPassword;
    private TextField tfUsername;
    private PasswordField tfPassword;
    private Button btLogin;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

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
                    System.out.println(username);
                    System.out.println(password);
                } else {
                    throw new Exception("Use a valid username and/or password.");
                }
            } else {
                throw new Exception("Use a valid username and/or password.");
            }
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
