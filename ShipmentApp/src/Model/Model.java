/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author yzeed
 */
public class Model {

   private Shipment shipmentzajil;
   private Shipment shipmentaramex;
   private Shipment shipmentdhl;
   private Shipment shipmentnaqel;
   
   private static Model model=null;
   
   private ArrayList<Shipment> shipments=new ArrayList<>(); 
    private Model() {
       ShipmentCreator s = new ShipmentCreator("Z8000543", "zajil");
       shipmentzajil=s.getShipment();
       
       ShipmentCreator s2= new ShipmentCreator("34320938551", "aramex");
       shipmentaramex=s2.getShipment(); 
       
       ShipmentCreator s3= new ShipmentCreator("6226548731", "dhl");
       shipmentdhl=s3.getShipment(); 
       
       ShipmentCreator s4= new ShipmentCreator("55033295", "naqel");
       shipmentnaqel=s4.getShipment();
       
       
       shipments.add(shipmentzajil);
       shipments.add(shipmentdhl);
       shipments.add(shipmentnaqel);
       shipments.add(shipmentaramex);
       
    }
   
    public static Model getModel(){
        if(model==null){
            model=new Model();
        }
        return model;
        
        
    }
    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

  
}

        
