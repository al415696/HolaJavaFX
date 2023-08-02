package es.sjdm;

import es.sjdm.mvc.controller.Controlador;
import es.sjdm.mvc.model.Modelo;
import es.sjdm.mvc.view.Vista;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Initializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    /*
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hola, JavaFX");
        Scene scene = new Scene(label, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
    */
    @Override
    public void start(Stage stage) throws IOException {
        Controlador controlador = new Controlador();
        Modelo modelo = new Modelo();
        Vista vista = new Vista(stage);/*
        stage.setTitle("Menú Principal");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        Button librosButton = new Button("Libros");

        Button sociosButton = new Button("Socios");
        Button regEntButton = new Button("Registro\nentrada");
        HBox hBox = new HBox(librosButton,sociosButton,regEntButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15);

        Button estadButton = new Button("Estadisticas");
        HBox hBoxEstad = new HBox(estadButton);
        hBoxEstad.setAlignment(Pos.BOTTOM_RIGHT);

        VBox vBox = new VBox(hBox, hBoxEstad);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(200);
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 700, 500);
        stage.setScene(scene);

        stage.show();
*/
        modelo.setVista(vista);

        controlador.setVista(vista);
        controlador.setModelo(modelo);

        vista.setControlador(controlador);
        vista.setModelo(modelo);
        vista.startStartingWindow(stage);
    }
}
