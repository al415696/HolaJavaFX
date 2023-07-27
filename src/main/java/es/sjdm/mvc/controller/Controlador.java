package es.sjdm.mvc.controller;

import es.sjdm.mvc.view.InformaVista;
import javafx.stage.Stage;

public class Controlador implements Controller{

    private InformaVista vista;
    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    public void AbreVentana(String cod){
        vista.cierraVentana();
        Stage stage = new Stage();
        vista.decoraVentana(stage,cod);
    }
}
