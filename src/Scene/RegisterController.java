package Scene;

import java.io.IOException;

import CMS.User;
import DBHandler.UserLoginHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class RegisterController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text nhihai;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    UserLoginHandler user = new UserLoginHandler();

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
        
        if (newuser.length() == 0 || newpass.length() == 0) {
            nhihai.setText("Username or password cannot be empty");
        }

        else if (user.checkUser(newuser)) {
            nhihai.setText("Username already exists");
        }
        else{
            user.insertUser(newuser, newpass);
        }

        System.out.println("New user added");
    }

}
