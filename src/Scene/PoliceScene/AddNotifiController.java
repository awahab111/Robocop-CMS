package Scene.PoliceScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import CMS.Notification;
import CMS.DBHandler.NotificationHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Node;


public class AddNotifiController implements Initializable {
    @FXML
    private TextArea anon_description;

    @FXML
    private ChoiceBox<String> notif_type;

    private String[] types = {"FIR Reported", "Accident", "Investigation", "General"};

    private Stage stage;
    private Scene scene;
    private Parent root;

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
    void backbtnclicked(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("PoliceView.fxml"));
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
    void updateFIRbtn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateFIRScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void OK_btn(ActionEvent event) {
        String noti_type = notif_type.getValue();
        String noti_desc = anon_description.getText();

        NotificationHandler nh = new NotificationHandler();
        nh.insertNotification(noti_type, noti_desc);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        notif_type.getItems().addAll(types);
    }
}
