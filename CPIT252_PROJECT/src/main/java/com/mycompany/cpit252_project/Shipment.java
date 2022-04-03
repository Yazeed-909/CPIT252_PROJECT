/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit252_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author yzeed
 */
public class Shipment {
    
private String tracking_number;
private String id;
private String carrier_code;
private String status;
private String lastUpdateTime;
private String ItemReceived;
private String created_at;
private String weblink;
private String updated_at;
private ArrayList<Shipment_status> shipment_status; 











public void insertShipment(){
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            
            
           
            
            PreparedStatement insertStmt =
            dbConnection.prepareStatement("INSERT INTO new_table (tracking_number, id, carrier_code, status, lastUpdateTime, ItemReceived, created_at, weblink, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            insertStmt.setString(1, this.tracking_number);
            insertStmt.setString(2, (this.id));
            insertStmt.setString(3, (this.carrier_code));
            insertStmt.setString(4, (this.status));
            insertStmt.setString(5, (this.lastUpdateTime));
            insertStmt.setString(6, (this.ItemReceived));
            insertStmt.setString(7, (this.created_at));
            insertStmt.setString(8, (this.weblink));
            insertStmt.setString(9, (this.updated_at));
            
            int rows = insertStmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveShipment(){
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
           
            String query = "SELECT tracking_number, id, carrier_code, status, lastUpdateTime, ItemReceived, created_at, weblink, updated_at FROM new_table";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                //Display values
                String row = "tracking_number: " + rs.getString("tracking_number") +
                "id: " + rs.getString("id") +
                "carrier_code: " + rs.getString("carrier_code") +
                "status: " + rs.getString("status") +
                "lastUpdateTime: " + rs.getString("lastUpdateTime") +
                "ItemReceived: " + rs.getString("ItemReceived") +
                "created_at: " + rs.getString("created_at") +
                "weblink: " + rs.getString("weblink") +
                "updated_at: " + rs.getString("updated_at");
                             
                System.out.print(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   

    public String toString(){
        return "tracking_number,id,carrier_code,status,lastUpdateTime,ItemReceived,created_at,weblink,updated_at";
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getItemReceived() {
        return ItemReceived;
    }

    public void setItemReceived(String ItemReceived) {
        this.ItemReceived = ItemReceived;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    
}
