/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxsample2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author kkeuser
 */
public class FXMLDocumentController extends BaseController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        showChart();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void showChart() {
        try {
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(_stage);

                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                                "Chart.fxml"));
                Parent root = (Parent) loader.load();
                ChartController controller = (ChartController) loader
                                .getController();
                controller.setStageAndSetupListeners(stage);

                stage.setTitle("JavaFX サンプル２");
                stage.setScene(new Scene(root, 700, 700));
                stage.show();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
}
