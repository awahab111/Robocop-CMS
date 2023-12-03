package Scene.Police;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import CMS.PoliceOfficer;
import CMS.FIR.FIR;
import DBHandler.FIRHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;


public class PoliceUFIRController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    PoliceOfficer user = PoliceOfficer.getInstance();

    
    @FXML
    private Pane dapane;

    @FXML
    private Text datetimelabel;

    @FXML
    private ChoiceBox<Integer> firchoice;

    @FXML
    private HTMLEditor investi_report;

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
    void updatePrevFIRbtn(ActionEvent event) {
        Integer selectedFIR = firchoice.getValue();
        FIRHandler fh = new FIRHandler();
        FIR fir = fh.getFIR(selectedFIR);
        fh.updateFIR(fir.getFIR_ID(), investi_report.getHtmlText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FIRHandler fh = new FIRHandler();
        try{
            firchoice.getItems().addAll(fh.getAssignedFIRs(user.getOfficerID()));
        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        firchoice.setOnAction(event -> {
            Integer selectedFIR = firchoice.getValue();
            handleFIRSelection(selectedFIR);
        });

        investi_report.setHtmlText("<h1>Investigation Report</h1>");

    }

    private void handleFIRSelection(Integer selectedFIR) {
        FIRHandler fh = new FIRHandler();
        FIR fir = fh.getFIR(selectedFIR);
        datetimelabel.setText(fir.getDate() + " " + fir.getTime());
        datetimelabel.setStyle("-fx-text-fill: grey; -fx-font-style: italic; -fx-font-size: 10px;");

        investi_report.setHtmlText(fir.getReport());
    }

}
