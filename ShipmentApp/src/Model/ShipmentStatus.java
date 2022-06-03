/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class ShipmentStatus implements ShipmentInterface{
    private String Location;
    private String Current_status;
    private String Time;

    protected ShipmentStatus(String Location, String Current_status_code, String Current_status, String Time) {
        this.Location = Location;
        this.Current_status = Current_status;
        this.Time = Time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

   

    

    public String getCurrent_status() {
        return Current_status;
    }

    public void setCurrent_status(String Current_status) {
        this.Current_status = Current_status;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    @Override
    public String toString() {
        return "Current Location : " + Location + ", Current Status : " + Current_status + ", Time : " + Time;
    }

    @Override
    public void print() {
        System.out.println("---- Shipment Status ----");
        System.out.println("Location : "+Location);
        System.out.println("Current_status : "+Current_status);
        System.out.println("Time : "+Time);
    }


    
    
    
    
    
}
