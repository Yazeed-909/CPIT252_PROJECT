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
       shipmentzajil= new ShipmentCreator("Z8000543", "zajil");
       
       
       shipmentaramex= new ShipmentCreator("34320938551", "aramex");
        
       
       shipmentdhl= new ShipmentCreator("6226548731", "dhl");
    
       
        shipmentnaqel= new ShipmentCreator("55033295", "naqel");
        
       
       
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

        
