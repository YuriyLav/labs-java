package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class Sample2Controller {
    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    void initialize(){
        label1.setText("Описание: " + Sample1Controller.getT1());
        label2.setText("Время: "+Sample1Controller.getT2());
        label3.setText("Важность: "+ Sample1Controller.getT3());
    }
}
