package AutoPartsStore;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppMain extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("First Application");
        primaryStage.setWidth(300);
        primaryStage.setHeight(250);
        primaryStage.show();
        System.out.println("Hello!");
    }
}
