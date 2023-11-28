package Scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void createFIRScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateFIR.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
