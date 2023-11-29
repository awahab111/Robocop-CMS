package Scene;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import CMS.Forum.Forum;
import CMS.Forum.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForumController implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Pane dapane;

    @FXML
    void createFIRScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateFIR.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Forum forum = new Forum();  
        forum.getAllPosts();

        List<Post> posts = forum.getPosts();

        int pages = (int) Math.ceil(posts.size() / 5.0); // Round up the pages variable

        Pagination pagination = new Pagination(pages, 0); // Create a Pagination control with the rounded up pages, starting at page 0

       pagination.setPageFactory((Integer pageIndex) -> {
        VBox vbox = new VBox(); // Declare and initialize vbox
        vbox.setSpacing(50); // Set spacing between nodes

        for (Post post : posts) {
            GridPane gridPane = new GridPane(); // Create a new GridPane for each post
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            


            Label userIdLabel = new Label(String.valueOf("awahab"));
            GridPane.setConstraints(userIdLabel, 0, 0); // Place at top left

            Label dateTimeLabel = new Label("Amongus");
            GridPane.setConstraints(dateTimeLabel, 1, 0); // Place at top right
            // GridPane.setHalignment(dateTimeLabel, HPos.RIGHT); // Align to the right

            Label contentLabel = new Label("hgcvsdhgnbdvfhsavdfs csdvjhdbhjfavd ffahvdhafcb adcvsdjd vcshdvjhsvbdjf sdfhjvbdfhj dfjsvhdf sg dfcjsvcs dcsh cds chs dcvsc hs dcvs cvsd chs cvsd cgwvhjwrjhg rhg wefhwlfhiwufbw rfwevfbhwjef wlevfhlwjebf wlfvwifwb fwjh fwjf \n dhejldbqwefwjhebfefjlbrhbfwjhbf whjrf hwbefhb hef");
            GridPane.setConstraints(contentLabel, 0, 1, 2, 1); // Place at bottom, spanning 2 columns

            gridPane.getChildren().addAll(userIdLabel, dateTimeLabel, contentLabel);
            gridPane.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10;");
            gridPane.prefWidthProperty().bind(dapane.widthProperty());

            vbox.getChildren().add(gridPane);
        }

        return new ScrollPane(vbox); // Return the vbox inside a ScrollPane for each page
        });
        dapane.getChildren().add(pagination);

        pagination.prefWidthProperty().bind(dapane.widthProperty());
        pagination.prefHeightProperty().bind(dapane.heightProperty());

    }
}
