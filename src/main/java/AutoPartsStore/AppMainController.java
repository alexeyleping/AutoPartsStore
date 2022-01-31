// Старый контроллер, не участвует в работе

package AutoPartsStore;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button editDetailBt;

    @FXML
    private Button DetailBt;

    @FXML
    private Button deleteNewDetailBt;

    @FXML
    void initialize() {
        assert editDetailBt != null : "fx:id=\"editDetailBt\" was not injected: check your FXML file 'AppMainWindows.fxml'.";
        assert DetailBt != null : "fx:id=\"DetailBt\" was not injected: check your FXML file 'AppMainWindows.fxml'.";
        assert deleteNewDetailBt != null : "fx:id=\"deleteNewDetailBt\" was not injected: check your FXML file 'AppMainWindows.fxml'.";

        DetailBt.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/NewDetailWindow.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.showAndWait();


        });
    }
}