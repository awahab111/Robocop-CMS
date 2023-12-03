package Scene.Police;

import java.io.IOException;
import java.util.ArrayList;

import DBHandler.CriminalRecordHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AddCriminalRecordController{

    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField address;

    @FXML
    private TextField birthplace;

    @FXML
    private TextField cnic;

    @FXML
    private TextField fathername;

    @FXML
    private TextField name;

    @FXML
    private Pane viewpane;

    @FXML
    private TextArea history;

   @FXML
    void AddCriminalRecord_btn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/PoliceScene/CreateCriminalRecords.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AddNotificationbtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/PoliceScene/AddNotifi.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AssignedFIRbtn(ActionEvent event) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/PoliceScene/ViewAssignedFIR.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ViewCriminalRecordsbtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../Resources/PoliceScene/ViewCriminalRecords.fxml"));
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
    void backbtnclicked(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("../Resources/PoliceScene/PoliceView.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("../Resources/PoliceScene/UpdateFIRScene.fxml"));
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
    void OKRecordbtn(ActionEvent event) {
        CriminalRecordHandler crh = new CriminalRecordHandler();
        if (cnic.getText().isEmpty() || name.getText().isEmpty() || fathername.getText().isEmpty() || birthplace.getText().isEmpty() || address.getText().isEmpty() || history.getText().isEmpty()) {
            return;
        }

        ArrayList<String> crimes = new ArrayList<String>();
        crimes.add(history.getText());
        crh.insertRecord(name.getText(), fathername.getText(), birthplace.getText(), address.getText(), cnic.getText(), crimes);
        
    }


}
