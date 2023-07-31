package es.sjdm.mvc.model;

//import org.jopendocument.dom.spreadsheet.Sheet;

import org.jopendocument.dom.ODPackage;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.NoSuchElementException;

public class Modelo implements InterrogaModelo,CambiaModelo {
    private Sheet registroActual;
    private SpreadSheet registro;
    File file;
    public Modelo() throws IOException {
        //Direccion del registro
        ODPackage od = new ODPackage(new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTOMATICO.ods"));
        registro = SpreadSheet.get(od);
        /*
        System.out.println(registro.getFirstSheet().getCellAt("A1").getValue());
        System.out.println(registro.getFirstSheet().getCellAt(0,0).getValue());
        System.out.println(registro.getFirstSheet().getCellAt("A1").isEmpty());
        System.out.println(registro.getFirstSheet().getCellAt("A2").getValue());
        System.out.println(registro.getFirstSheet().getCellAt("A3").getValue());

        System.out.println(registro.getFirstSheet().isCellValid(1,1));
        */
        /*
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().getMonthValue());
        System.out.println(LocalDate.now().getDayOfMonth());
        System.out.println(LocalDate.now().getYear());
        */
        existsSpreadSheet(LocalDate.now());
    }
    public void anyadeARegistro(String nombre, LocalDate fecha){
        if (!existsSpreadSheet(fecha)){
            //SI NO EXISTE CREALA Y HAZ QUE LA PRIMERA FILA
            // TENGA EL NÚMERO CORRECTO DE COLUMNAS NUMERADAS
        }
        registroActual = registro.getSheet(getCurrentMonth(fecha)+ "-" + fecha.getYear() ,false);
        int dom = fecha.getDayOfMonth()-1;
        int i = 1;
        //BUSCA UN ESPACIO LIBRE Y ESCRIBE AHI EL NOMBRE
        while (!registroActual.getCellAt(dom,i).isEmpty()){
            i++;
            if (i > 1000) throw new RuntimeException();
        }
        registroActual.getCellAt(dom,i).setValue(nombre);

    }
    private boolean existsSpreadSheet(LocalDate fecha) {
        try {
            registro.getSheet(getCurrentMonth(fecha)+ "-" + fecha.getYear() ,true);

            //registro.getSheet("Amogus", true);
            System.out.println("En efecto existe");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("En efecto no existe");
            return false;
        }
    }
    private String getCurrentMonth(LocalDate date){
        switch (date.getMonthValue()){
            case 1:
                return "ENERO";
            case 2:
                return "FEBRERO";
            case 3:
                return "MARZO";
            case 4:
                return "ABRIL";
            case 5:
                return "MAYO";
            case 6:
                return "JUNIO";
            case 7:
                return "JULIO";
            case 8:
                return "AGOSTO";
            case 9:
                return "SEPTIEMBRE";
            case 10:
                return "OCTUBRE";
            case 11:
                return "NOVIEMBRE";
            case 12:
                return "DICIEMBRE";
            default:
                return "EXTRA(ERROR EN CODIGO)";
        }
    }
    public void prueba(){

        try {
            registroActual = SpreadSheet.createFromFile(file).getSheet(0);
            System.out.println(registroActual.getCellAt("A1").getValue());
            System.out.println("Ha aparecido");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
