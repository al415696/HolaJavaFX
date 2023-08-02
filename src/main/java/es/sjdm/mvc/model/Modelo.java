package es.sjdm.mvc.model;

//import org.jopendocument.dom.spreadsheet.Sheet;

import org.jopendocument.dom.ODPackage;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.NoSuchElementException;

public class Modelo implements InterrogaModelo,CambiaModelo {
    private Sheet registroActual;
    private SpreadSheet registro;
    File file;
    public Modelo() throws IOException {
        //Direccion del registro
        /*
        file = new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_2023.ods");
        //ODPackage od = new ODPackage(new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_2023.ods"));
        //registro = SpreadSheet.get(od);


//        System.out.println(registro.getFirstSheet().getCellAt(0,0).getValue());
//        System.out.println(registro.getFirstSheet().getCellAt(0,1).getValue());
//        System.out.println(registro.getFirstSheet().getCellAt(1,0).getValue());
//        System.out.println(registro.getFirstSheet().getCellAt(1,1).getValue());
        /*System.out.println(registro.getFirstSheet().getCellAt("A1").isEmpty());
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
        /*
        System.out.println("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_"+"2023" +".ods");
        System.out.println(new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_"+"2023" +".ods").exists());
        registro = SpreadSheet.createFromFile(file);
         //registro = SpreadSheet.get(new ODPackage(new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_2023.ods")));

        // registroActual = registro.getSheet("AGOSTO");

         registroActual = registro.getFirstSheet();
         //registroActual.setRowCount(31);

        //registroActual.setValueAt("Hola",0,0);
        //formatizaSheet(LocalDate.now());
         //registro.addSheet("Prueba");


        existsSheet(LocalDate.now());

        */
    }
    public void anyadeARegistro(String nombre, LocalDate fecha){
        getSheetFor(fecha);
        int dom = fecha.getDayOfMonth()-1;
        int i = 1;
        //BUSCA UN ESPACIO LIBRE Y ESCRIBE AHI EL NOMBRE
        //while (!registroActual.getCellAt(dom,i).isEmpty()){
        while (!registroActual.getCellAt(dom,i).isEmpty()){
            i++;
            if (i > 2000) throw new RuntimeException();
        }
        registroActual.getCellAt(dom,i).setValue(nombre);
        try{
            registroActual.getSpreadSheet().saveAs(file);
        } catch (IOException e ){

        }

    }
    private void getSheetFor(LocalDate fecha){
        //SI NO EXISTE EL FICHERO, LO CREA
        if (!new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_"+fecha.getYear() +".ods").exists()){
            System.out.println("no existe el archivo");
            try {

            TableModel model = new DefaultTableModel();
            file = new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_"+fecha.getYear() +".ods");
            SpreadSheet.createEmpty(model).saveAs(file);

            //Sheet sheet = SpreadSheet.get(new ODPackage(file)).getFirstSheet();
            registro = SpreadSheet.createFromFile(file);
            registroActual = registro.getFirstSheet();
            registroActual.setName(getNameOfMonth(fecha));
            formatizaSheetRegistro(fecha);
            registroActual.getSpreadSheet().saveAs(file);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("No se pudo crear fichero");
                throw new RuntimeException(e);
            }
        }
        //CARGA LA SPREADSHEET EN LA VARIABLE
        try {
            file = new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_"+fecha.getYear() +".ods");
            registro = SpreadSheet.createFromFile(file);
            //registro = SpreadSheet.get(new ODPackage(new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_"+fecha.getYear() +".ods")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo encontrar Sheet");
            throw new RuntimeException(e);
        }
        //SI NO EXISTE LA SHEET, CREALA (Y FORMATIZALA)
        if (!existsSheetRegistro(fecha)){
            System.out.println("No existe la sheet");
            registro.addSheet(getNameOfMonth(fecha));
            registroActual = registro.getSheet(getNameOfMonth(fecha));
            //formatizaSheet(registro.getSheet(getNameOfMonth(fecha)),fecha);
            formatizaSheetRegistro(fecha);
        }
        //CARGA LA SHEET EN MEMORIA, COMPLETANDO LA FUNCIÓN DEL MÉTODO
        //System.out.println("registro concedido");
        //System.out.println(registro.getSheet(getNameOfMonth(fecha)).getName() + "existe");
        registroActual = registro.getSheet(getNameOfMonth(fecha));

    }
    private boolean existsSheetRegistro(LocalDate fecha) {
        try {
            registro.getSheet(getNameOfMonth(fecha),true);

            //registro.getSheet("Amogus", true);
            System.out.println("En efecto existe");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("En efecto no existe");
            return false;
        }
    }
    private void formatizaSheetRegistro(LocalDate fecha){

        YearMonth yearMonthObject = YearMonth.of(fecha.getYear(), fecha.getMonth());
        int daysInMonth = yearMonthObject.lengthOfMonth();
        //System.out.println(registroActual.getName());
        //System.out.println("Header column: " + registroActual.getHeaderColumnCount());

        registroActual.ensureRowCount(50);
        //System.out.println(daysInMonth);
        //System.out.println(registroActual.getColumnCount());
        for (int i = 0; i < daysInMonth; i++) {
            try{
                registroActual.setColumnCount(daysInMonth);
               // System.out.println(registroActual.getCellAt(i,0).getValue());
                registroActual.getCellAt(i,0).setValue( i+1 );
                //System.out.println(registroActual.getCellAt(i,0).getValue());
                //System.out.println("Funciona");
            }
            catch (Exception e){

                System.out.println("Datos:");
                System.out.println(registroActual.getName());
                System.out.println("colCountAntes?: "+registroActual.getColumnCount());
                //registroActual.setColumnCount(daysInMonth);
                System.out.println("colCount: "+registroActual.getColumnCount());
                System.out.println("rowCount: "+registroActual.getRowCount());
                System.out.println("valida?: "+registroActual.getCellAt(i,0).isValid());
                System.out.println("vacia?: "+registroActual.getCellAt(i,0).isEmpty());
                //registroActual.getCellAt(i,0).setValue(i+1);
                registro.getSheet("AGOSTO").setValueAt(4,i,0);
                //registroActual.setValueAt(i+1,i,0);
            }

        }

    }
    private String getNameOfMonth(LocalDate date){
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
        /*
        try {
            file = new File("src/files/prueba.ods");
            registroActual = SpreadSheet.createFromFile(file).getSheet(0);
            System.out.println("preColumn: " +registroActual.getColumnCount());
            System.out.println("preRow: " + registroActual.getRowCount());

            registroActual.setRowCount(50);
            try{
                registroActual.setColumnCount(31);
            } catch(Exception e){
                registroActual.setColumnCount(31);
            }


            System.out.println("postColumn: " +registroActual.getColumnCount());
            System.out.println("postRow: " + registroActual.getRowCount());

            System.out.println(registroActual.getCellAt("A1").getValue());
            System.out.println("Ha aparecido");
            registroActual.getCellAt("A1").setValue("prueba");
            System.out.println(registroActual.getCellAt("A1").getValue());
            System.out.println("POR FIN!!!!!!");
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            System.out.println("el error es:");
            e.printStackTrace();
            //throw new RuntimeException(e);
        }

         */
        try {
            LocalDate fecha = LocalDate.now();
            TableModel model = new DefaultTableModel();
            final File file = new File("src"+File.separator+"files"+File.separator+"REGISTRO_AUTO_"+fecha.getYear() +".ods");
            SpreadSheet.createEmpty(model).saveAs(file);

            Sheet sheet = SpreadSheet.createFromFile(file).getFirstSheet();
            sheet.setName(getNameOfMonth(fecha));
            registro = sheet.getSpreadSheet();
            Sheet temporal = registroActual;
            registroActual = sheet;
            formatizaSheetRegistro(fecha);
            registroActual = temporal;
            registro.addSheet("prueba");

            sheet.getSpreadSheet().saveAs(file);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo crear fichero");
            throw new RuntimeException(e);
        }

    }
}
