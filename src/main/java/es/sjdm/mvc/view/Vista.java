package es.sjdm.mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista implements InterrogaVista, InformaVista {
    private final Stage startingStage;
    public Vista(Stage mainStage) {
        this.startingStage = mainStage;
    }
    public void creaGUIa(){
        startingStage.setTitle("Menú Principal");
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        StackPane root = new StackPane();

        Button librosButton = new Button("Libros");
        estilizadoVista.estilizaBotonGrande(librosButton);
        Button sociosButton = new Button("Socios");
        estilizadoVista.estilizaBotonGrande(sociosButton);
        Button regEntButton = new Button("Registro\nentrada");
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
        startingStage.setScene(scene);

        startingStage.show();
    }
}
