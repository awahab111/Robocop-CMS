package Scene;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import CMS.DBHandler.CrimeDescriptionHandler;

public class CreateFIRController implements Initializable {
    
    @FXML
    private ChoiceBox<String> crime_choice;

    @FXML
    private TextArea ta_desc;

    @FXML
    private TextArea ta_evidence;

    @FXML
    private TextField tflocation;

    @FXML
    private TextField tfstatus;


    @FXML
    void createFIRbtn(ActionEvent event) {

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

}
