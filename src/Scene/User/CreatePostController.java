package Scene.User;

import java.io.IOException;

import CMS.User;
import CMS.Forum.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CreatePostController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    User user = User.getInstance();

    @FXML
    private TextArea post_description;

    @FXML
    void OK_btn(ActionEvent event) {
        String desc = post_description.getText();
        Post post = new Post();
        post.createPost(desc, user.getUser_ID());
    }

   @FXML
    void createFIRScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Resources/UserScene/CreateFIR.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void policestation_btn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Resources/UserScene/PoliceStations.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void forum_btn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Resources/UserScene/Forum.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backbtnclicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Resources/UserScene/MainView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ViewFIR_btn(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/UserScene/ViewFIR.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
