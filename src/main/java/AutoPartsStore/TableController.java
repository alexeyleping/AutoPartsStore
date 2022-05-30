//Контроллер AppMain

package AutoPartsStore;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;




public class TableController implements Initializable {




    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, Integer> col_id;
    @FXML
    private TableColumn<ModelTable, String> col_name;
    @FXML
    private TableColumn<ModelTable, String> col_price;

    ObservableList<ModelTable> oL = FXCollections.observableArrayList();

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPrice;

    @FXML
    private Button refreshBt;

    @FXML
    void refresh(ActionEvent event) {
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button editDetailBt;

    @FXML
    private Button DetailBt;

    @FXML
    private Button deleteDetailBt;

    @FXML
    void deleteRow(ActionEvent event) {
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            Connection con = DBConnector.getConnection();
            ResultSet rS = con.createStatement().executeQuery("select * from AutoParts");

            while (rS.next()){
                oL.add(new ModelTable(rS.getString("idautopartstable"), rS.getString("name"), rS.getString("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    col_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
    col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

    table.setItems(oL);
        

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


        editDetailBt.setOnAction(event -> {
            try {
                String idText = tfID.getText();
                String nameText = tfName.getText();
                String priceText = tfPrice.getText();
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AutoParts","root","12345");
                PreparedStatement statement = connection.prepareStatement("UPDATE autoparts SET name=?, price=? where idautopartstable=?");
                statement.setString(1, nameText);
                statement.setString(2, priceText);
                statement.setString(3, idText);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


        refreshBt.setOnAction(event -> {

            oL.clear();

            try {
                Connection con = DBConnector.getConnection();
                ResultSet rS = con.createStatement().executeQuery("select * from AutoParts");

                while (rS.next()){
                    oL.add(new ModelTable(rS.getString("idautopartstable"), rS.getString("name"), rS.getString("price")));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


            col_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

            table.setItems(oL);

        });


    }

    public void deleteRows(){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/AutoParts","root","12345");
            String tab = table.getSelectionModel().getSelectedItem().getID();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM AutoParts WHERE idautopartstable = " + tab);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    }

    public void onTableSelectItem(){
        ModelTable mD;
        mD = table.getSelectionModel().getSelectedItem();
        tfID.setText(mD.getID());
        tfName.setText(mD.getName());
        tfPrice.setText(mD.getPrice());
    }
    
}
