/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Shipment;
import Model.ShipmentInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author yzeed
 */
public class MoreDetailsConroller implements Initializable {   
     @FXML
    private Label ItemReceived;

    @FXML
    private ListView<String> StatusList;

    @FXML
    private Label Tracking_number;

    @FXML
    private Label Website;
 

     public void SetShipment(Shipment shipment) {
        Website.setText(shipment.getWeblink());
        Tracking_number.setText(shipment.getTracking_number());
        ItemReceived.setText(shipment.getItemReceived());
        for (ShipmentInterface shipment_statu : shipment.getShipment_status()) {

            StatusList.getItems().addAll(shipment_statu.toString());

        }  
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     StatusList.refresh();
    }    
    
}
