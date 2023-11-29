package Scene;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import CMS.PoliceStation;
import CMS.DBHandler.PoliceStationHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

public class PoliceStationController implements Initializable {
    
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



    
}
