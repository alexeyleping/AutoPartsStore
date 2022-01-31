package AutoPartsStore;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewDetailOKController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okButton;

    @FXML
    void initialize() {
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'NewDetailOK.fxml'.";
        okButton.setOnAction(event -> {

            ((Stage) (okButton.getScene().getWindow())).close();
        });


    }
}
