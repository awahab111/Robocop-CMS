package Scene;

import java.io.IOException;

import CMS.PoliceOfficer;
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

public class PoliceLoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text nhihai;
    
    @FXML
    private TextField tfbadgenumber;

    @FXML
    private PasswordField tfpassword;

    PoliceOfficer pawlice = PoliceOfficer.getInstance();


    @FXML
    void PoliceLoginClicked(ActionEvent event) throws IOException {
        String badgenumber = tfbadgenumber.getText();
        String password = tfpassword.getText();

        if (badgenumber.equals("admin") && password.equals("admin")) {
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            return;
        }

        System.out.println("Badge Number: " + tfbadgenumber.getText());
        System.out.println("Password: " + tfpassword.getText());

        try {
            Integer.parseInt(badgenumber);
            if (badgenumber.length() == 0 || password.length() == 0) {
                nhihai.setText("Invalid Badge Number or Password");
            }
        } catch (NumberFormatException e) {
            nhihai.setText("Badge Number must be a number");
            return;
        }

        pawlice.login(Integer.parseInt(badgenumber), password);
    
        if (pawlice.getOfficerID() >= 0) {
            root = FXMLLoader.load(getClass().getResource("Resources/PoliceScene/PoliceView.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            nhihai.setText("Invalid Badge Number or Password");
        }

    }

    @FXML
    void LoginSceneSwitchbtn(ActionEvent event) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
