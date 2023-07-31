package es.sjdm.mvc.controller;

import es.sjdm.mvc.model.CambiaModelo;
import es.sjdm.mvc.view.InformaVista;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Calendar;

public class Controlador implements Controller{

    private InformaVista vista;
    public void setVista(InformaVista vista) {
        this.vista = vista;
    }

    private CambiaModelo modelo;

    public void setModelo(CambiaModelo modelo) {
        this.modelo = modelo;
    }

    public void abreVentana(String cod){
        vista.cierraVentana();
        Stage stage = new Stage();
        vista.decoraVentana(stage,cod);
    }

    public void anyadeARegistro(String nombre, LocalDate fecha){
        //fecha.getMonth();
        modelo.anyadeARegistro(nombre, fecha);
        }
}
