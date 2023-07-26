package es.sjdm.mvc.view;

import es.sjdm.mvc.controller.Controller;
import es.sjdm.mvc.model.InterrogaModelo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista implements InterrogaVista, InformaVista {
    private Controller controlador;
    public void setControlador(final Controller controlador) {
        this.controlador = controlador;
    }
    private InterrogaModelo modelo;

    public void setModelo(final InterrogaModelo modelo) {
        this.modelo = modelo;
    }
    private Stage currentStage;
    public Vista(Stage mainStage) {
        this.currentStage = mainStage;
    }
    public void creaGUIa(Stage currentStage){
        currentStage.setTitle("Menú Principal");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        Button librosButton = new Button("Libros");
        estilizadoVista.estilizaBotonGrande(librosButton);
        Button sociosButton = new Button("Socios");
        estilizadoVista.estilizaBotonGrande(sociosButton);
        Button regEntButton = new Button("Registro\nentrada");
        regEntButton.setOnAction(e -> {
            //controlador.selectAlgorithm(0);
            //setIfReady();
        });
        estilizadoVista.estilizaBotonGrande(regEntButton);
        HBox hBox = new HBox(librosButton,sociosButton,regEntButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(60);

        Button estadButton = new Button("Estadisticas");
        HBox hBoxEstad = new HBox(estadButton);
        hBoxEstad.setAlignment(Pos.BOTTOM_RIGHT);

        VBox vBox = new VBox(hBox, hBoxEstad);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(200);
        //vBox.setPadding(new Insets(0, 0, 0, 0));

        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 700, 500);
        currentStage.setScene(scene);

        currentStage.show();
    }

    public void creaGUIb1(Stage currentStage){
        currentStage.setTitle("Menú Principal");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        Button librosButton = new Button("A");
        estilizadoVista.estilizaBotonGrande(librosButton);
        Button sociosButton = new Button("B");
        estilizadoVista.estilizaBotonGrande(sociosButton);
        Button regEntButton = new Button("C\nA");
        estilizadoVista.estilizaBotonGrande(regEntButton);
        HBox hBox = new HBox(librosButton,sociosButton,regEntButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(60);

        Button estadButton = new Button("Estadisticas");
        HBox hBoxEstad = new HBox(estadButton);
        hBoxEstad.setAlignment(Pos.BOTTOM_RIGHT);

        VBox vBox = new VBox(hBox, hBoxEstad);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(200);
        //vBox.setPadding(new Insets(0, 0, 0, 0));

        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 700, 500);
        currentStage.setScene(scene);

        currentStage.show();
    }

    @Override
    public void decoraVentana(Stage stage, String cod) {

    }
}
