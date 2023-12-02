package Scene.PoliceScene;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CMS.PoliceOfficer;
import CMS.DBHandler.FIRHandler;
import CMS.FIR.FIR;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PoliceViewController implements Initializable{

    @FXML
    private Pane dapane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    PoliceOfficer user = PoliceOfficer.getInstance();

    @FXML
    void AddCriminalRecord_btn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateCriminalRecords.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AddNotificationbtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNotifi.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AssignedFIRbtn(ActionEvent event) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAssignedFIR.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ViewCriminalRecordsbtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("ViewCriminalRecords.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Handle exception
            System.err.println("Failed to load the FXML file: " + e.getMessage());
        }
    }

    @FXML
    void logoutbtnclicked(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("../PoliceLogin.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Handle exception
            System.err.println("Failed to load the FXML file: " + e.getMessage());
        }
    }   

    @FXML
    void updateFIRbtn(ActionEvent event) throws IOException{
         try {
            root = FXMLLoader.load(getClass().getResource("UpdateFIRScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Handle exception
            System.err.println("Failed to load the FXML file: i am beom" + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }


}
