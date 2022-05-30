/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import Model.Model;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author yzeed
 */
public class MainController implements Initializable {

    
    @FXML
    private TilePane Pane;
    @FXML
    private AnchorPane Box1, Box2, Box3, Box4, Main_scene;
    @FXML
    private Label Last_location1 = new Label(), Last_location2 = new Label(), Last_location3 = new Label(), Last_location4 = new Label(), Status_1 = new Label(), Status_2 = new Label(), Status_3 = new Label(),
    Status_4 = new Label(), Tracking_1 = new Label(), Tracking_2 = new Label(), Tracking_3 = new Label(), Tracking_4 = new Label();
    private int counter;
    private Model model = Model.getModel();

    @FXML
    public void Shipment_Status() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/MoreDetails.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MoreDetailsConroller Conroller2 = fxmlLoader.getController();
            if (Box1.isPressed()) {
                Conroller2.SetShipment(model.getShipments().get(0));
                
            }
            if (Box2.isPressed()) {
                Conroller2.SetShipment(model.getShipments().get(1));
            }
            if (Box3.isPressed()) {
                Conroller2.SetShipment(model.getShipments().get(2));
            }
            if (Box4.isPressed()) {
                Conroller2.SetShipment(model.getShipments().get(3));
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {

        }

    }

   



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SetShipmentsLables(0, Last_location1, Status_1, Tracking_1);
        SetShipmentsLables(1, Last_location2, Status_2, Tracking_2);
        SetShipmentsLables(2, Last_location3, Status_3, Tracking_3);
        SetShipmentsLables(3, Last_location4, Status_4, Tracking_4);
    }

    public void SetShipmentsLables(int i, Label Last_location, Label Status, Label tracking) {

        Last_location.setText(model.getShipments().get(i).getLastStatus().getLocation());
        Status.setText(model.getShipments().get(i).getStatus());
        tracking.setText(model.getShipments().get(i).getTracking_number());

    }

}
