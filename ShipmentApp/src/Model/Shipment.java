/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

public abstract class Shipment implements ShipmentInterface{

    protected String tracking_number;
    protected String id;
    protected String carrier_code;
    protected String status;
    protected String lastUpdateTime;
    protected String ItemReceived;
    protected String created_at;
    protected String weblink;
    protected String updated_at;
    protected ArrayList<ShipmentInterface> shipment_status=new ArrayList<>();
    protected ShipmentStatus LastStatus;

    public Shipment() {
    }
    
    
   
    
    public Shipment(String tracking_number, String id, String carrier_code, String status, String lastUpdateTime, String ItemReceived, String created_at, String weblink, String updated_at) {
        this.tracking_number = tracking_number;
        this.id = id;
        this.carrier_code = carrier_code;
        this.status = status;
        this.lastUpdateTime = lastUpdateTime;
        this.ItemReceived = ItemReceived;
        this.created_at = created_at;
        this.weblink = weblink;
        this.updated_at = updated_at;
        
    }
    

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarrier_code() {
        return carrier_code;
    }

    public void setCarrier_code(String carrier_code) {
        this.carrier_code = carrier_code;
    }

    public String getStatus() {
        return status;
    }

    public void setLastStatus(ShipmentStatus LastStatus) {
        this.LastStatus = LastStatus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

 
    public void insertStatus(ShipmentInterface shipment_status){
        
        this.shipment_status.add(shipment_status);
        
        
    }

    @Override
    public String toString() {
        return "Shipment{" + "tracking_number=" + tracking_number + ", id=" + id + ", carrier_code=" + carrier_code + ", status=" + status + ", lastUpdateTime=" + lastUpdateTime + ", ItemReceived=" + ItemReceived + ", created_at=" + created_at + ", weblink=" + weblink + ", updated_at=" + updated_at + ", shipment_status=" + shipment_status + '}';
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public String getItemReceived() {
        return ItemReceived;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public ArrayList<ShipmentInterface> getShipment_status() {
        return shipment_status;
    }

    public ShipmentStatus getLastStatus() {
        return LastStatus;
    }

    @Override
    public void print() {
        System.out.println("---- Shipment Info ----");
        System.out.println("tracking_number : "+tracking_number);
        System.out.println("id : "+id);
        System.out.println("carrier_code : "+carrier_code);
        System.out.println("status : "+status);
        System.out.println("lastUpdateTime : "+lastUpdateTime);
        System.out.println("ItemReceived : "+ItemReceived);
        System.out.println("created_at : "+created_at);
        System.out.println("weblink : "+weblink);
        System.out.println("updated_at : "+updated_at);

    }
    
    
    
 
}
