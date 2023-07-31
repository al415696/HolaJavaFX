package es.sjdm.mvc.model;

//import org.jopendocument.dom.spreadsheet.Sheet;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.jopendocument.sample.SpreadSheetCreation;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Modelo implements InterrogaModelo,CambiaModelo {
    private Sheet registro;
    File file;
    public Modelo() throws IOException {
        file = new File("src"+File.separator+"files"+File.separator+"REGISTRO2023.ods");
        System.out.println(file.getPath());


    }
    public void anyadeARegistro(String nombre, Calendar fecha){

    }
    public void prueba(){

        try {
            registro = SpreadSheet.createFromFile(file).getSheet(0);
            System.out.println(registro.getCellAt("A1").getValue());
            System.out.println("Ha aparecido");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
