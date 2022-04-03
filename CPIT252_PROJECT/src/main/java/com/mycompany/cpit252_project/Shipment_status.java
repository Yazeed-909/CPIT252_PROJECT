/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit252_project;

/**
 *
 * @author yzeed
 */
public class Shipment_status {
    private String Location;
    private String Current_status_code;
    private String Current_status;

    @Override
    public String toString() {
        return "Shipment_status{" + "Location=" + Location + ", Current_status_code=" + Current_status_code + ", Current_status=" + Current_status + ", Time=" + Time + '}';
    }
    private String Time;

    public Shipment_status(String Location, String Current_status_code, String Current_status, String Time) {
        this.Location = Location;
        this.Current_status_code = Current_status_code;
        this.Current_status = Current_status;
        this.Time = Time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getCurrent_status_code() {
        return Current_status_code;
    }

    public void setCurrent_status_code(String Current_status_code) {
        this.Current_status_code = Current_status_code;
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
    
    
    
    
    
    
}
