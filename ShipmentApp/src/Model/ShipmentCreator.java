/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author yzeed
 */
public class ShipmentCreator {

    
   private Shipment shipment;
   private JsonNode node;
    
    
    public ShipmentCreator(String ShipmentNumber,String CarrierCode) {
        
        SendRequest(ShipmentNumber, CarrierCode);
        ParsShipment(node);
        
        
    }

    public Shipment getShipment() {
        return shipment;
    }
    
    
    
    
    
    
    private void Get_status(JsonNode node,Shipment shipment ){
        
         for (int i = 0; i < node.get("data").findValue("trackinfo").size(); i++) {    
             
             
             
             if(i==0){
            String Date=node.get("data").findValue("trackinfo").get(0).get("Date").textValue();
            String StatusDescription=node.get("data").findValue("trackinfo").get(0).get("StatusDescription").textValue(); 
            String Details=node.get("data").findValue("trackinfo").get(0).get("Details").textValue(); 
            String checkpoint_status=node.get("data").findValue("trackinfo").get(0).get("checkpoint_status").textValue(); 
            String substatus=node.get("data").findValue("trackinfo").get(0).get("substatus").textValue(); 
            ShipmentStatus status=new ShipmentStatus(Details, substatus, substatus, Date);
            shipment.setLastStatus(status);
            shipment.insertStatus(status);
            continue;
             }
             
             
             
             
             
             
            String Date=node.get("data").findValue("trackinfo").get(i).get("Date").textValue();
            String StatusDescription=node.get("data").findValue("trackinfo").get(i).get("StatusDescription").textValue(); 
            String Details=node.get("data").findValue("trackinfo").get(i).get("Details").textValue(); 
            String checkpoint_status=node.get("data").findValue("trackinfo").get(i).get("checkpoint_status").textValue(); 
            String substatus=node.get("data").findValue("trackinfo").get(i).get("substatus").textValue(); 
            ShipmentStatus status=new ShipmentStatus(Details, substatus, substatus, Date);
            shipment.insertStatus(status);  
            
        }
       
        
    }
    private  void SendRequest(String ShipmentNumber,String CarrierCode){
         //Some of this code is taken from lab2
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.tracktry.com/v1/trackings/"+CarrierCode+"/"+ShipmentNumber))
                    .header("Content-Type", "application/json")
                    .header("Tracktry-Api-Key", "7802c747-567c-42aa-b5aa-fc311647fd31")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).
                    thenApply(HttpResponse::body).join();
            ObjectMapper maper=new ObjectMapper();
             node=maper.readTree(response.body());
           
        } catch (IOException ex) {
           
        } catch (InterruptedException ex) {
        
        }
        
         
        
        
    }
    private void ParsShipment(JsonNode node){
        
        String id=node.get("data").findValue("id").textValue();
        String tracking_number=node.get("data").findValue("tracking_number").textValue();
        String carrier_code=node.get("data").findValue("carrier_code").textValue();
        String lastUpdateTime=node.get("data").findValue("lastUpdateTime").textValue();
        String ItemReceived=node.get("data").findValue("ItemReceived").textValue();
        String weblink=node.get("data").findValue("weblink").textValue();
        String updated_at=node.get("data").findValue("updated_at").textValue();
        String status=node.get("data").findValue("status").textValue();
        shipment=new Shipment(tracking_number, id, carrier_code, status, lastUpdateTime, ItemReceived, updated_at, weblink, updated_at);
        Get_status(node, shipment);
        
    }
    
    
    
    
    
}
