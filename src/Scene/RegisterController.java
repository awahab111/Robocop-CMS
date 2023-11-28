package Scene;

import java.io.IOException;

import CMS.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class RegisterController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void LoginSceneSwitchbtn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void RegisterbtnClicked(ActionEvent event) {
        String newuser = username.getText();
        String newpass = password.getText();
        
        User user = new User();
        user.addUser(newuser, newpass);
        System.out.println("New user added");
    }
}
