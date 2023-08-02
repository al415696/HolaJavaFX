package es.sjdm.mvc.view;

import javafx.stage.Stage;

public interface InformaVista {
    //Controlador
    public void decoraVentana(Stage stage, String cod);

    void cierraVentana();

    //Modelo

    void anyadidoRegistro(int codeEstado, String nombre);
}
