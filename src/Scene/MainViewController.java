package Scene;

import java.io.IOException;

import CMS.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewController {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    User user;

    @FXML
    void createFIRScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateFIR.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        CreateFIRController createFIRController = loader.getController();
        createFIRController.setUser(user);
        stage.show();
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

        CreatePostController createPostController = loader.getController();
        createPostController.setUser(user);


        stage.setScene(scene);
        stage.show();
    }

    
    public void setUser(User u) {
        user = new User(u);

        System.out.println("User set");
        System.out.println(user.getUsername());
    }


}
