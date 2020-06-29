package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Controller {

    @FXML
    private Text output;
    private long num = 0;

    private boolean start = true;
    private String delete = "";
    private String ok = "";

    private Model model = new Model();


    @FXML
    private void num(ActionEvent event){
        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);

    }


    @FXML
    private void processOk(ActionEvent event){
        String value = output.getText();
        readName();
        start = true;
    }

    @FXML
    private void processDelete(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if("delete".equals(value)){
            output.setText("");
            start = true;
        }
    }

    @FXML
    private void initialize(){

    }

    public void readName(){
        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream("сотрудники.xls"));
            for (int i = 0; i < 20 ; i++) {
               if(wb.getSheet("Лист1")
                       .getRow(i).getCell(0).equals(output)){
                   System.out.println(wb.getSheet("Лист1").getRow(i)
                   .getCell(1));
               } else System.out.println("сотрудник не найден");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
