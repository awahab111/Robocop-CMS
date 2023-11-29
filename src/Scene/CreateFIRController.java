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



    @FXML
    void createFIRbtn(ActionEvent event) {
        String tfloc = tflocation.getText();
        String crime = crime_choice.getValue();
        String desc = ta_desc.getText();
        String evidence = ta_evidence.getText();

        // Create a date variable with the current date
        java.util.Date currentDate = new java.util.Date();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);
        java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);

        // Create a time variable with the current time
        java.sql.Time sqlTime = new java.sql.Time(currentDate.getTime());

        FIR fir = new FIR();
        
        CrimeDescription cd = new CrimeDescription();
        int crime_id = cd.getCrimeDescription_ID(crime);

        int user_id = ReadUserID.readUserIdFromFile("user_id.txt");

        fir.addFIR(sqlDate, sqlTime, tfloc, desc, evidence, crime_id, user_id);
    }

    public class ReadUserID {
        public static void main(String[] args) {
            String filePath = "user_id.txt";
            int userId = readUserIdFromFile(filePath);
            System.out.println("User ID: " + userId);
        }

        public static int readUserIdFromFile(String filePath) {
            int userId = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line = reader.readLine();
                if (line != null) {
                    userId = Integer.parseInt(line.trim());
                }
            } catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
            return userId;
        }
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

}
