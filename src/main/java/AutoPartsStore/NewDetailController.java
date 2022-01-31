package AutoPartsStore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;



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
    void addRow(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert closeButton != null : "fx:id=\"closeButton\" was not injected: check your FXML file 'NewDetailWindow.fxml'.";

        closeButton.setOnAction(event -> ((Stage) (closeButton.getScene().getWindow())).close());


    }

    public void AddRoww(){

        try {
            String nameText = nameTextField.getText();
            String priceText = priceTextField.getText();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AutoParts","root","12345");
            PreparedStatement statement = connection.prepareStatement("INSERT autoparts(name, price) VALUES(?,?)");
            statement.setString(1, nameText);
            statement.setString(2, priceText);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    }
}
