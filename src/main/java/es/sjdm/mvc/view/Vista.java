package es.sjdm.mvc.view;

import es.sjdm.mvc.controller.Controller;
import es.sjdm.mvc.model.InterrogaModelo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
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

    public void cierraVentana(){
        currentStage.close();
    }
    public void startStartingWindow(Stage startingStage){
        creaGUIa(startingStage);
    }
    public Vista(Stage mainStage) {
        this.currentStage = mainStage;
    }
    private void creaGUIa(Stage currentStage){
        this.currentStage = currentStage;
        currentStage.setTitle("Menú Principal");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        Button librosButton = new Button("Libros");
        estilizadoVista.estilizaBotonGrande(librosButton);
        Button sociosButton = new Button("Socios");
        estilizadoVista.estilizaBotonGrande(sociosButton);
        Button regEntButton = new Button("Registro\nentrada");
        regEntButton.setOnAction(e -> {
            controlador.AbreVentana("b1");
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

    private void creaGUIb1(Stage currentStage){
        this.currentStage = currentStage;
        currentStage.setTitle("Registro de entrada");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        Button historialButton = new Button("Historial");
        estilizadoVista.estilizaBotonGrande(historialButton);
        Button anyadirButton = new Button("Añadir");
        estilizadoVista.estilizaBotonGrande(anyadirButton);
        Button anyadirAvanzadoButton = new Button("Añadir\navanzado");
        anyadirAvanzadoButton.setTextAlignment(TextAlignment.CENTER);
        estilizadoVista.estilizaBotonGrande(anyadirAvanzadoButton);
        VBox vBox = new VBox(historialButton, anyadirAvanzadoButton);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(75);
        HBox hBox = new HBox(anyadirButton,vBox);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(60);
        hBox.setPadding(new Insets(0, 0, 0, 0));

        root.getChildren().add(hBox);

        Scene scene = new Scene(root, 700, 500);
        currentStage.setScene(scene);

        currentStage.show();
        currentStage.setOnCloseRequest(e-> controlador.AbreVentana("a"));
    }

    @Override
    public void decoraVentana(Stage stage, String cod) {
    switch (cod){
        case "a":
            creaGUIa(stage);
            break;
        case "b1":
            creaGUIb1(stage);

    }
    }
}
