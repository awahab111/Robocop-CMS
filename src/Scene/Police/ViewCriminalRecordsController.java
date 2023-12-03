package Scene.Police;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CMS.CriminalRecord;
import DBHandler.CriminalRecordHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewCriminalRecordsController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label address;

    @FXML
    private Label birthplace;

    @FXML
    private Label cnic;

    @FXML
    private Pane dapane;

    @FXML
    private Label fathername;

    @FXML
    private Label history;

    @FXML
    private Label name_label;

    @FXML
    private Pane viewpane;

      @FXML
    void AddCriminalRecord_btn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/PoliceScene/CreateCriminalRecords.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AddNotificationbtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/PoliceScene/AddNotifi.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AssignedFIRbtn(ActionEvent event) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/PoliceScene/ViewAssignedFIR.fxml"));
        root =  loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ViewCriminalRecordsbtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../Resources/PoliceScene/ViewCriminalRecords.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Handle exception
            System.err.println("Failed to load the FXML file: " + e.getMessage());
        }
    }

    @FXML
    void backbtnclicked(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("../Resources/PoliceScene/PoliceView.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Handle exception
            System.err.println("Failed to load the FXML file: " + e.getMessage());
        }
    }   

    @FXML
    void updateFIRbtn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Resources/PoliceScene/UpdateFIRScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backRecordview(ActionEvent event) {
        dapane.setOpacity(1);
        dapane.disableProperty().set(false);
        viewpane.setOpacity(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewpane.setOpacity(0);

        CriminalRecordHandler crh = new CriminalRecordHandler();
        ArrayList<CriminalRecord> allcriminalList = crh.getAllRecords();

        int pages = (int) Math.ceil(allcriminalList.size() / 10.0); // Round up the pages variable

        Pagination pagination = new Pagination(pages, 0); // Create a Pagination control with the rounded up pages, starting at page 0

        pagination.setPageFactory((Integer pageIndex) -> {
        VBox vbox = new VBox(); // Declare and initialize vbox

        int start = pageIndex * 10;
        int end = Math.min(start + 10, allcriminalList.size());
        for (int i = start; i < end; i++) {
            GridPane gridPane = new GridPane(); // Create a new GridPane for each post

            gridPane.prefWidthProperty().bind(pagination.widthProperty());

            Button button = new Button("Criminal "+ allcriminalList.get(i).getCriminal_id() +" Details >");
            GridPane.setConstraints(button, 1, 0);
            button.prefWidthProperty().bind(gridPane.widthProperty());

            button.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button sourceButton = (Button) event.getSource(); // Get the button that was clicked
                    System.out.println("Button clicked: " + sourceButton.getText());
                    int criminal_id = Integer.parseInt(sourceButton.getText().split(" ")[1]);
                    
                    CriminalRecord  desiredCriminal = allcriminalList.stream()
                        .filter(criminal -> criminal.getCriminal_id() == criminal_id)
                        .findFirst()
                        .orElse(null);

                    dapane.setOpacity(0);
                    dapane.disableProperty().set(true);
                    viewpane.setOpacity(1);
                    RecordData(desiredCriminal);
                                                        
                }
            });

            gridPane.getChildren().addAll(button);

            gridPane.prefWidthProperty().bind(dapane.widthProperty().subtract(2));

            button.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10; -fx-background-color: white; -fx-text-fill: black;");

            button.setOnMouseEntered(e -> button.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10; -fx-background-color: #BBBFCA; -fx-text-fill: black;"));
            button.setOnMouseExited(e -> button.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-padding: 10; -fx-background-color: #E8E8E8; -fx-text-fill: black;"));
           
            vbox.getChildren().add(gridPane);
            
        }

        return new ScrollPane(vbox); // Return the vbox inside a ScrollPane for each page
        });
        dapane.getChildren().add(pagination);
        viewpane.setStyle("-fx-background-color: #D0D0D0; -fx-border-width: 10; -fx-background-radius: 10; -fx-border-radius: 10;");
        pagination.setStyle("-fx-border-width: 10;");
        pagination.prefWidthProperty().bind(dapane.widthProperty());
        pagination.prefHeightProperty().bind(dapane.heightProperty());
    }

    public void RecordData(CriminalRecord criminal){
        System.out.println(criminal.getName());

        cnic.setText(criminal.getCnic());
        fathername.setText(criminal.getFatherName());
        birthplace.setText(criminal.getBirthplace());
        address.setText(criminal.getAddress());
        name_label.setText(criminal.getName());
        ArrayList<String> crimes = criminal.getCrimes();
        String historyString = "";
        for(int j = 0; j < crimes.size(); j++){
            historyString += crimes.get(j) + "\n";
        }
        System.out.println(historyString);
        history.setText(historyString);

    }

}
