package Scene;



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

import java.io.IOException;
import CMS.User;
import java.io.FileWriter;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Text nhihai;
    
    @FXML
    private PasswordField tfpassword;

    @FXML
    private TextField tfusername;

    User u = User.getInstance();

    SharedData sharedData = SharedData.getInstance();

    @FXML
    public void LoginClicked(ActionEvent event) throws IOException {
        String username = tfusername.getText();
        String password = tfpassword.getText();

        if (username.length() == 0 || password.length() == 0) {
            nhihai.setText("Username or password cannot be empty");
            return;
        }
        System.out.println("Username: " + tfusername.getText());
        System.out.println("Password: " + tfpassword.getText());

        u.getUserID(username, password);
        if (u.getUser_ID() > 0) {
            // Create a file and insert the user_id into it
            FileWriter fileWriter = new FileWriter("user_id.txt");
            fileWriter.write(String.valueOf(u.getUser_ID()));
            fileWriter.close();
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resources/UserScene/MainView.fxml"));
            root = loader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            nhihai.setText("Invalid username or password");
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

    
    @FXML
    void PoliceLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PoliceLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}