package es.sjdm.mvc.controller;

import java.time.LocalDate;
import java.util.Calendar;

public interface Controller {
    public void abreVentana(String cod);
    void anyadeARegistro(String nombre, LocalDate fecha);
}
