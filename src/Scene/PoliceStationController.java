package Scene;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import CMS.PoliceStation;
import CMS.DBHandler.PoliceStationHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PoliceStationController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> Stationchoice;

    @FXML
    private Text txtNumber;

    @FXML
    private Text txtloc;

    @FXML
    private Text txtname;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PoliceStationHandler policeStationHandler = new PoliceStationHandler();
        try {
            Stationchoice.getItems().addAll(policeStationHandler.getPoliceStation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Stationchoice.setOnAction(e -> getPoliceStationDetails());
    }

    public void getPoliceStationDetails() {
        PoliceStationHandler policeStationHandler = new PoliceStationHandler();
        String policeStationName = Stationchoice.getValue();
        PoliceStation policeStation = policeStationHandler.getPoliceStationDetails(policeStationName);
        txtname.setText(policeStation.getName());
        txtloc.setText(policeStation.getLocation());
        txtNumber.setText(policeStation.getPhone());
    }


    @FXML
    void backbtnclicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    void createFIRScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateFIR.fxml"));
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

}
