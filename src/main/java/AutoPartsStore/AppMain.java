package AutoPartsStore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/AppMainWindows.fxml"));
        Scene scene = new Scene(root, 400, 180);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Список запчастей");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }

}
