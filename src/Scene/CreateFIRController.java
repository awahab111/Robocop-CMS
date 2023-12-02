package Scene;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import CMS.User;
import CMS.DBHandler.CrimeDescriptionHandler;
import CMS.FIR.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateFIRController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ChoiceBox<String> crime_choice;

    @FXML
    private TextArea ta_desc;

    @FXML
    private TextArea ta_evidence;

    @FXML
    private TextField tflocation;

    User user = User.getInstance();


    @FXML
    void createFIRbtn(ActionEvent event) {
        String tfloc = tflocation.getText();
        String crime = crime_choice.getValue();
        String desc = ta_desc.getText();
        String evidence = ta_evidence.getText();

        FIR fir = new FIR();

        fir.addFIR(tfloc, desc, evidence, crime, user.getUser_ID());
    }


    @FXML
    void backbtnclicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CrimeDescriptionHandler crimeDescriptionHandler = new CrimeDescriptionHandler();

        try {
            crime_choice.getItems().addAll(crimeDescriptionHandler.getCrimeDescription());
        } catch (SQLException e) {
            System.out.println("Error in CreateFIRController.java");
            e.printStackTrace();
        }
    }

    @FXML
    void policestation_btn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PoliceStations.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void forum_btn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Forum.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void post_btn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CreatePost.fxml"));
        loader.setClassLoader(getClass().getClassLoader());
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
