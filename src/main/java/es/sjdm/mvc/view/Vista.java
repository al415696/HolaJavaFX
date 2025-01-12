package es.sjdm.mvc.view;

import es.sjdm.mvc.controller.Controller;
import es.sjdm.mvc.model.InterrogaModelo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.time.LocalDate;

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

    @Override
    public void cierraVentana(){
        currentStage.close();
    }
    public void startStartingWindow(Stage startingStage){
        creaGUIa(startingStage);
    }


    Label labelRegistro;
    @Override
    public void anyadidoRegistro(int codEstado, String nombre) {
        switch (codEstado){
            case 0:
                labelRegistro.setText(nombre + " ha sido añadid@ correctamente");
                break;
            case 1:
                labelRegistro.setText(nombre + " no se ha podido añadir");
                break;

            case 2:
                labelRegistro.setText("No se ha podido crear el fichero del año correspondiente");
                break;
            case 3:
                labelRegistro.setText("No se ha podido crear la hoja del mes correspondiente");
                break;
            case 4:
                labelRegistro.setText("No se ha podido formatear la hoja del mes correspondiente");
                break;

        }
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
            controlador.abreVentana("b1");
            //controlador.selectAlgorithm(0);
            //setIfReady();
        });
        estilizadoVista.estilizaBotonGrande(regEntButton);
        HBox hBox = new HBox(librosButton,sociosButton,regEntButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(60);

        Button estadButton = new Button("Estadisticas");
        estadButton.setOnAction(e -> modelo.prueba());
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
        anyadirButton.setOnAction(e -> controlador.abreVentana("b2"));
        estilizadoVista.estilizaBotonGrande(anyadirButton);
        Button anyadirAvanzadoButton = new Button("Añadir\navanzado");
        anyadirAvanzadoButton.setTextAlignment(TextAlignment.CENTER);
        anyadirAvanzadoButton.setOnAction(e -> controlador.abreVentana("b3"));
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
        currentStage.setOnCloseRequest(e-> controlador.abreVentana("a"));


    }

    private void creaGUIb2(Stage currentStage){
        this.currentStage = currentStage;
        currentStage.setTitle("Añadir al registro de hoy");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        //estilizadoVista.estilizaBotonGrande(aceptarButton);
        TextField textField = new TextField();
        Button aceptarButton = new Button("Aceptar");
        aceptarButton.setOnAction(e-> {
            if(textField.getText().length() > 0){

                controlador.anyadeARegistro(textField.getText(), LocalDate.now());
                textField.setText("");
            }
        });
        HBox hBox = new HBox(textField,aceptarButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        hBox.setPadding(new Insets(0, 0, 0, 0));


        labelRegistro = new Label("Esperando para añadir...");
        VBox vBox = new VBox(hBox, labelRegistro);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);


        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 350, 250);
        currentStage.setScene(scene);

        currentStage.show();
        currentStage.setOnCloseRequest(e-> controlador.abreVentana("b1"));
    }
    private void creaGUIb3(Stage currentStage){
        this.currentStage = currentStage;
        currentStage.setTitle("Añadir al registro de cualquier dia");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        //estilizadoVista.estilizaBotonGrande(aceptarButton);
        TextField textFieldNombre = new TextField();
        DatePicker datePicker = new DatePicker(LocalDate.now());
        Button aceptarButton = new Button("Aceptar");
        aceptarButton.setOnAction(e-> {
            if(textFieldNombre.getText().length() > 0){

                controlador.anyadeARegistro(textFieldNombre.getText(), datePicker.getValue());
                textFieldNombre.setText("");
            }
        });
        HBox hBox = new HBox(textFieldNombre,aceptarButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        hBox.setPadding(new Insets(0, 0, 0, 0));


        labelRegistro = new Label("Esperando para añadir...");
        VBox vBox = new VBox(hBox,datePicker, labelRegistro);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);


        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 350, 250);
        currentStage.setScene(scene);

        currentStage.show();
        currentStage.setOnCloseRequest(e-> controlador.abreVentana("b1"));
    }
    @Override
    public void decoraVentana(Stage stage, String cod) {
    switch (cod){
        case "a":
            creaGUIa(stage);
            break;
        case "b1":
            creaGUIb1(stage);
            break;
        case "b2":
            creaGUIb2(stage);
            break;
        case "b3":
            creaGUIb3(stage);
            break;

    }
    }
}
