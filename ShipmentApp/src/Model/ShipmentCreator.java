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
import java.util.concurrent.TimeoutException;

/**
 *
 * @author yzeed
 */
public class ShipmentCreator extends Shipment{
    
   
    final String APIKEY = ("APIKEY");

   private JsonNode node;
    
    
    public ShipmentCreator(String ShipmentNumber,String CarrierCode) {
        super();
        SendRequest(ShipmentNumber, CarrierCode);
        ParsShipment(node);
        
        
        
    }

 
    
    
    
    
    
    private void Get_status(JsonNode node ){
        
         for (int i = 0; i < node.get("data").findValue("trackinfo").size(); i++) {    
             
             
             
             if(i==0){
            String Date=node.get("data").findValue("trackinfo").get(0).get("Date").textValue();
            String StatusDescription=node.get("data").findValue("trackinfo").get(0).get("StatusDescription").textValue(); 
            String Details=node.get("data").findValue("trackinfo").get(0).get("Details").textValue(); 
            String checkpoint_status=node.get("data").findValue("trackinfo").get(0).get("checkpoint_status").textValue(); 
            String substatus=node.get("data").findValue("trackinfo").get(0).get("substatus").textValue(); 
            ShipmentStatus status=new ShipmentStatus(Details, substatus, substatus, Date);
            super.setLastStatus(status);
            super.insertStatus(status);
            continue;
             }
             
             
             
             
             
             
            String Date=node.get("data").findValue("trackinfo").get(i).get("Date").textValue();
            String StatusDescription=node.get("data").findValue("trackinfo").get(i).get("StatusDescription").textValue(); 
            String Details=node.get("data").findValue("trackinfo").get(i).get("Details").textValue(); 
            String checkpoint_status=node.get("data").findValue("trackinfo").get(i).get("checkpoint_status").textValue(); 
            String substatus=node.get("data").findValue("trackinfo").get(i).get("substatus").textValue(); 
            ShipmentInterface Status=new ShipmentStatus(Details, substatus, substatus, Date);
            super.insertStatus(Status);  
            
        }
       
        
    }
    private  void SendRequest(String ShipmentNumber,String CarrierCode){
         //Some of this code is taken from lab2
          String code;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.tracktry.com/v1/trackings/"+CarrierCode+"/"+ShipmentNumber))
                    .header("Content-Type", "application/json")
                    .header("Tracktry-Api-Key", APIKEY)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).
                    thenApply(HttpResponse::body).join();
            ObjectMapper maper=new ObjectMapper();
             node=maper.readTree(response.body());
             code=node.get("meta").findValue("code").asText();
            if(!"200".equals(code)){
               throw new TimeoutException("Error While Calling the api");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        } catch (TimeoutException ex) {
            System.out.println(ex.getMessage());
            System.out.println(node.get("meta"));
       }
        
         
        
        
    }
    private void ParsShipment(JsonNode node){
        
        super.id=node.get("data").findValue("id").textValue();
        super.tracking_number=node.get("data").findValue("tracking_number").textValue();
        super.carrier_code=node.get("data").findValue("carrier_code").textValue();
        super.lastUpdateTime=node.get("data").findValue("lastUpdateTime").textValue();
        super.ItemReceived=node.get("data").findValue("ItemReceived").textValue();
        super.weblink=node.get("data").findValue("weblink").textValue();
        super.updated_at=node.get("data").findValue("updated_at").textValue();
        super.status=node.get("data").findValue("status").textValue();
        
        Get_status(node);
        
    }
    
    
    
    
    
}
