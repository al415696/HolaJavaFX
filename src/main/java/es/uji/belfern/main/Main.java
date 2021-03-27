package es.uji.belfern.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hola, JavaFX");
        Scene scene = new Scene(label);
        stage.setScene(scene);
        stage.show();
    }
}
