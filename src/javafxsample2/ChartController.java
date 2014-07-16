/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxsample2;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author kkeuser
 */
public class ChartController extends BaseController  implements Initializable{
    @FXML private NumberAxis yAxis1;
    @FXML private NumberAxis yAxis2;
    @FXML private CategoryAxis xAxis1;
    @FXML private CategoryAxis xAxis2;
    @FXML private StackedBarChart chartApp;
    @FXML private StackedBarChart chartApp2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();

        xAxis1.setLabel("Time");
        xAxis2.setLabel("Time");
        Calendar cal1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");//"hh:mm:ss SSS"
        cal1.set(2016, 6, 30);
        Random rnd = new Random();
        ArrayList<String> datelist = new ArrayList<String>();
        for(int i=0; i< 20; i++){
        	cal1.add(Calendar.SECOND, 1);
        	String label = sdf.format(cal1.getTime());
        	datelist.add(label);
        }
        xAxis1.setCategories(FXCollections.<String>observableArrayList(datelist));
        xAxis2.setCategories(FXCollections.<String>observableArrayList(datelist));
        
        yAxis1.setLabel("M bps");
        yAxis2.setLabel("なんか単位");
        series1.setName("なんとかチャート");
        series2.setName("なんかのグラフ");
        for(int i=0; i< 20; i++){
            float val = rnd.nextInt(100); 
            series1.getData().add(new XYChart.Data<String, Number>(datelist.get(i), val));
            series2.getData().add(new XYChart.Data<String, Number>(datelist.get(i), val%20));
        }
        chartApp.getData().addAll(series1);
        chartApp2.getData().addAll(series2);
    }
    
}
