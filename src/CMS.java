import java.io.IOException;

import CMS.Forum.Forum;
import DBHandler.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CMS extends Application {
    Database db = Database.getInstance();

    Forum forum = Forum.getInstance();

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Scene/Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Robocop");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {}
}
 
 public static void main(String[] args) {
        launch(args);
    }
}