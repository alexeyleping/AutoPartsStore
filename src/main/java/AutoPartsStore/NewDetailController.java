package AutoPartsStore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewDetailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    private Button addDetail;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'NewDetailWindow.fxml'.";

        closeButton.setOnAction(event -> ((Stage) (closeButton.getScene().getWindow())).close());

        DatabaseHandler dbHandler = new DatabaseHandler();
        addDetail.setOnAction(e -> {
            dbHandler.newDetail(nameTextField.getText(), priceTextField.getText());


                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/NewDetailOK.fxml"));
                try {
                    loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

        });
    }
}
