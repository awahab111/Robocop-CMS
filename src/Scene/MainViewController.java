package Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import CMS.*;
import CMS.DBHandler.NotificationHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainViewController implements Initializable  {

    
    @FXML
    private Pane dapane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    SharedData sharedData = SharedData.getInstance();

    User user = User.getInstance();

    
    @FXML
    void ViewFIR_btn(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewFIR.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createFIRScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateFIR.fxml"));
        root =  loader.load();
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
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logoutbtnclicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NotificationHandler notifHandler = new NotificationHandler();
        ArrayList<Notification> allnotifi = notifHandler.getAllNotifications(); // Get all notifications from the database

        int pages = (int) Math.ceil(allnotifi.size() / 5.0);
    

        Pagination pagination = new Pagination(pages, 0); // Create a Pagination control with the rounded up pages, starting at page 0

        pagination.setPageFactory((Integer pageIndex) -> {
            VBox vbox = new VBox(); // Declare and initialize vbox
            int start = pageIndex * 5;
            int end = Math.min(start + 5, pages);

            for (int i = start; i < end; i++) {            
                GridPane gridPane = new GridPane(); // Create a new GridPane for each post
                gridPane.setHgap(10);
                gridPane.setVgap(1);


                Label not_typeLabel = new Label(allnotifi.get(i).getType());
                not_typeLabel.prefWidthProperty().bind(dapane.widthProperty().subtract(150));
                not_typeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13px; -fx-underline: true;");
                GridPane.setConstraints(not_typeLabel, 0, 0); // Place at top left

                Label dateTimeLabel = new Label(allnotifi.get(i).getDate() + " " + allnotifi.get(i).getTime()); 
                GridPane.setConstraints(dateTimeLabel, 1, 0); // Place at top right
                dateTimeLabel.setStyle("-fx-text-fill: grey; -fx-font-style: italic; -fx-font-size: 10px;");


                Label contentLabel = new Label(allnotifi.get(i).getMessage());
                contentLabel.setWrapText(true);
                contentLabel.maxWidthProperty().bind(dapane.widthProperty().subtract(30)); 
                GridPane.setConstraints(contentLabel, 0, 1, 2, 1); // Place at bottom, spanning 2 columns

                gridPane.getChildren().addAll(not_typeLabel, dateTimeLabel, contentLabel);
                gridPane.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10;");
                gridPane.prefWidthProperty().bind(dapane.widthProperty().subtract(2));

                vbox.getChildren().add(gridPane);
                
            }

            return new ScrollPane(vbox); // Return the vbox inside a ScrollPane for each page
        });
        dapane.getChildren().add(pagination);

        pagination.prefWidthProperty().bind(dapane.widthProperty());
        pagination.prefHeightProperty().bind(dapane.heightProperty());

    }

}
