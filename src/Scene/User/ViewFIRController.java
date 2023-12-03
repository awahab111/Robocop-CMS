package Scene.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CMS.User;
import CMS.DBHandler.FIRHandler;
import CMS.DBHandler.ForumHandler;
import CMS.FIR.FIR;
import CMS.Forum.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFIRController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    User  user = User.getInstance();
    
    @FXML
    private Label crime_type;
    @FXML
    private Label dateandtimelabel;
    @FXML
    private Label desclabel;
    @FXML
    private Label evidencelabel;
    @FXML
    private Label loclabel;
    @FXML
    private RadioButton status;


    @FXML
    private Pane dapane;

    @FXML
    private Pane viewpane;

    @FXML
    void createFIRScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/UserScene/CreateFIR.fxml"));
        root =  loader.load();
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
    void post_btn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Resources/UserScene/CreatePost.fxml"));
        loader.setClassLoader(getClass().getClassLoader());
        root = loader.load();
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
    void backFIRview(ActionEvent event) {
        dapane.setOpacity(1);
        dapane.disableProperty().set(false);
        viewpane.setOpacity(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewpane.setOpacity(0);

        FIRHandler fh = new FIRHandler();
        ArrayList<Integer> allfirs = fh.getFIRs(user.getUser_ID());

        int pages = (int) Math.ceil(allfirs.size() / 10.0); // Round up the pages variable

        Pagination pagination = new Pagination(pages, 0); // Create a Pagination control with the rounded up pages, starting at page 0

        pagination.setPageFactory((Integer pageIndex) -> {
        VBox vbox = new VBox(); // Declare and initialize vbox

        int start = pageIndex * 10;
        int end = Math.min(start + 10, allfirs.size());
        for (int i = start; i < end; i++) {
            GridPane gridPane = new GridPane(); // Create a new GridPane for each post

            // gridPane.setStyle("-fx-border-color: black;");
            // vbox.setStyle("-fx-border-color: black;");

            gridPane.prefWidthProperty().bind(pagination.widthProperty());

            Button button = new Button("FIR "+ allfirs.get(i) +" Details >");
            GridPane.setConstraints(button, 1, 0);
            button.prefWidthProperty().bind(gridPane.widthProperty());

            button.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button sourceButton = (Button) event.getSource(); // Get the button that was clicked
                    System.out.println("Button clicked: " + sourceButton.getText());
                    int fir_id = Integer.parseInt(sourceButton.getText().split(" ")[1]);
                    dapane.setOpacity(0);
                    dapane.disableProperty().set(true);
                    viewpane.setOpacity(1);
                    FIRDetails(fir_id);
                }
            });

            gridPane.getChildren().addAll(button);

            gridPane.prefWidthProperty().bind(dapane.widthProperty().subtract(2));

            button.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10; -fx-background-color: white; -fx-text-fill: black;");

            button.setOnMouseEntered(e -> button.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10; -fx-background-color: rgb(0, 159,228); -fx-text-fill: white;"));
            button.setOnMouseExited(e -> button.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10; -fx-background-color: white; -fx-text-fill: black;"));
           
            vbox.getChildren().add(gridPane);
            
        }

        return new ScrollPane(vbox); // Return the vbox inside a ScrollPane for each page
        });
        dapane.getChildren().add(pagination);
        pagination.setStyle("-fx-border-width: 10;");
        pagination.prefWidthProperty().bind(dapane.widthProperty());
        pagination.prefHeightProperty().bind(dapane.heightProperty());
    }

    public void FIRDetails(int fir_id){
        FIRHandler fh = new FIRHandler();
        FIR fir = fh.getFIR(fir_id);

        crime_type.setText(fir.getCrime_desc());
        dateandtimelabel.setText(fir.getDate() + " " + fir.getTime());
        dateandtimelabel.setStyle("-fx-text-fill: grey; -fx-font-style: italic; -fx-font-size: 10px;");
        desclabel.setText(fir.getDescription());
        desclabel.setStyle("-fx-border-color: black;");
        evidencelabel.setText(fir.getEvidence());
        evidencelabel.setStyle("-fx-border-color: black;");
        loclabel.setText(fir.getLocation());
        status.setSelected(fir.getStatus());

    }


}
