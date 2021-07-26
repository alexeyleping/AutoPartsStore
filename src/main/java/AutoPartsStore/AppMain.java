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
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(100);   // установка положения надписи по оси X

        Group group = new Group(text);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First Application");
        primaryStage.setWidth(300);
        primaryStage.setHeight(250);
        primaryStage.show();
    }
}
