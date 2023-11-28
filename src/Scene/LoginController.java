package Scene;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

import CMS.User;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField tfpassword;

    @FXML
    private TextField tfusername;

    @FXML
    public void LoginClicked(ActionEvent event) throws IOException {
        String username = tfusername.getText();
        String password = tfpassword.getText();
        System.out.println("Username: " + tfusername.getText());
        System.out.println("Password: " + tfpassword.getText());
        User user = new User();
        int user_id = user.getUserID(username, password);
        System.out.println("User ID: " + user_id);
        if (user_id > 0) {
            root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void Registerbtnclicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}