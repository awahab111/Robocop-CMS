package Scene;

import java.io.IOException;

import CMS.PoliceOfficer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PoliceLoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField tfbadgenumber;

    @FXML
    private TextField tfpassword;

    PoliceOfficer pawlice = PoliceOfficer.getInstance();


    @FXML
    void PoliceLoginClicked(ActionEvent event) throws IOException {
        String badgenumber = tfbadgenumber.getText();
        String password = tfpassword.getText();
        System.out.println("Badge Number: " + tfbadgenumber.getText());
        System.out.println("Password: " + tfpassword.getText());

        if (badgenumber.isEmpty() || password.isEmpty()) {
            
        }
        else{

            root = FXMLLoader.load(getClass().getResource("PoliceView.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


        // pawlice.login(Integer.parseInt(badgenumber), password);

    }

}
