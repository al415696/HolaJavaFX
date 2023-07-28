package es.sjdm.mvc.model;

//import org.jopendocument.dom.spreadsheet.Sheet;

import org.jopendocument.dom.spreadsheet.Sheet;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Modelo implements InterrogaModelo,CambiaModelo {
    private Sheet registro;
    public Modelo() throws IOException {
        //File file = new File("src"+File.separator+"files"+File.separator+"REGISTRO2023.ods");
        //System.out.println(file.getPath());
        //registro = SpreadSheet.createFromFile(file).getSheet(0);
        //System.out.println(registro.getCellAt("A1"));
    }
    public void anyadeARegistro(String nombre, Calendar fecha){

    }
}
