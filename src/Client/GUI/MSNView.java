package Client.GUI;

import Client.Business.Enums.StatusType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MSNView extends Application {
    private Label lbNaam;
    private Label lbPersonalMessage;
    private ComboBox cbStatus;
    private Image iAccountPicture;

    public MainController getMain() {
        return main;
    }

    public void setMain(MainController main) {
        this.main = main;
    }

    private MainController main;

    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Make de grid lines visible
        // grid.setGridLinesVisible(true);

        lbNaam = new Label("Jelle Schräder");
        lbPersonalMessage = new Label("I'm Jelly U Jelly?");
        cbStatus = new ComboBox();
        fillComboBox();
        //iAccountPicture = new Image("");

        grid.add(lbNaam, 0, 0, 1, 1);
        grid.add(lbPersonalMessage, 0, 1, 1, 1);
        grid.add(cbStatus, 0, 2, 1, 1);

        Group root = new Group();
        Scene scene = new Scene(root, 400, 750);

        root.getChildren().add(grid);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void fillComboBox() {
        for(StatusType type : StatusType.values()) {
            cbStatus.getItems().add(type);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
