package sample;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
public class Controller {
    @FXML
    private LineChart<?, ?> LineChart1;
    @FXML
    private LineChart<?, ?> LineChart2;
    @FXML
    void initialize() {
        XYChart.Series ArrayList1 = new XYChart.Series<>();
        XYChart.Series HashMap1 = new XYChart.Series<>();
        ArrayList1.getData().add(new XYChart.Data<>("10", 1310));
        ArrayList1.getData().add(new XYChart.Data<>("100", 1295));
        ArrayList1.getData().add(new XYChart.Data<>("1000", 1141));
        ArrayList1.getData().add(new XYChart.Data<>("10000", 623));
        ArrayList1.getData().add(new XYChart.Data<>("100000", 377));
        HashMap1.getData().add(new XYChart.Data<>("10", 1790));
        HashMap1.getData().add(new XYChart.Data<>("100", 1220));
        HashMap1.getData().add(new XYChart.Data<>("1000", 1040));
        HashMap1.getData().add(new XYChart.Data<>("10000", 891));
        HashMap1.getData().add(new XYChart.Data<>("100000", 618));
        ArrayList1.setName("ArrayList");
        HashMap1.setName("HashMap");
        LineChart1.getData().addAll(ArrayList1, HashMap1);
        XYChart.Series ArrayList3 = new XYChart.Series<>();
        XYChart.Series HashMap3 = new XYChart.Series<>();
        ArrayList3.getData().add(new XYChart.Data<>("1", 1660));
        ArrayList3.getData().add(new XYChart.Data<>("10", 4750));
        ArrayList3.getData().add(new XYChart.Data<>("100", 1324));
        ArrayList3.getData().add(new XYChart.Data<>("1000", 1306));
        ArrayList3.getData().add(new XYChart.Data<>("10000", 1151));
        HashMap3.getData().add(new XYChart.Data<>("1", 15900));
        HashMap3.getData().add(new XYChart.Data<>("10", 2400));
        HashMap3.getData().add(new XYChart.Data<>("100", 8715));
        HashMap3.getData().add(new XYChart.Data<>("1000", 1879));
        HashMap3.getData().add(new XYChart.Data<>("10000", 1876));
        ArrayList3.setName("ArrayList");
        HashMap3.setName("HashMap");
        LineChart2.getData().addAll(ArrayList3, HashMap3);
    }
}
