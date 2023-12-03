package Scene;

import java.io.IOException;

import DBHandler.PoliceOfficerHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Text nhihai;

    @FXML
    private TextField tfbadge;

    @FXML
    private PasswordField tfpassword;

    @FXML
    private TextField rank;


    @FXML
    void PoliceLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PoliceLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Registerbtnclicked(ActionEvent event) {
        PoliceOfficerHandler user = new PoliceOfficerHandler();

        String badge = tfbadge.getText();
        String newpass = tfpassword.getText();
        String newrank = rank.getText();
        
        if (badge.length() == 0 || newpass.length() == 0 || newrank.length() == 0) {
            nhihai.setText("Fields cannot be empty");
        }

        else if (user.checkPoliceOfficer(Integer.parseInt(badge))) {
            nhihai.setText("Already exists");
        }
        else{
            user.insertPoliceOfficer(Integer.parseInt(badge), newpass, newrank);
        }

        System.out.println("New officer added");
    }
}
