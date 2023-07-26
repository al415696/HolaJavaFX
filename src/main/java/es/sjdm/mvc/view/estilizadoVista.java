package es.sjdm.mvc.view;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class estilizadoVista {
    protected static void estilizaBotonGrande(Button boton){
        boton.setMinSize(170,120);
        boton.setMaxSize(290,390);
        boton.setFont(Font.font(30));
    }
}
