package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Sample1Controller implements Initializable {

    public ComboBox<String> comboBox;
    @FXML
    private TextField priority;

    @FXML
    private TextField text;

    @FXML
    private TextField time;

    @FXML
    private AnchorPane window;

    @FXML
    private Button task;

    private static String t1, t2, t3;

    public static String getT1() {
        return t1;
    }

    public static String getT2() {
        return t2;
    }

    public static String getT3() {
        return t3;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){
        comboBox.getItems().setAll("Белый", "Черный", "Красный");
        task.setOnAction(event -> {
            if(text.getText().equals("") || time.getText().equals("") || priority.getText().equals("")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/sample3.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Ошибка");
                stage.showAndWait();
            }
            else {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/sample2.fxml"));
                t1 = text.getText();
                t2 = time.getText();
                t3 = priority.getText();
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Задача создана");
                stage.showAndWait();
            }
        });
    }

    public void changeColour(ActionEvent actionEvent) {
        String selectedValue = comboBox.getSelectionModel().getSelectedItem();
        if(selectedValue.equals("Белый")){
            window.setStyle("-fx-background-color: #fafafa");
        }
        if(selectedValue.equals("Черный")){
            window.setStyle("-fx-background-color: #000000");
        }
        if(selectedValue.equals("Красный")){
            window.setStyle("-fx-background-color: #FF0000");
        }
    }
}
