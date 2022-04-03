package com.mycompany.cpit252_project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SATTAM
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection{
  private final String url;
  private final int port;
  public final String dbName;
  private Connection connection;

  private static DBConnection instance;

  private DBConnection() throws SQLException {
     
    this.dbName = "shipment_info";
    this.port = 3306;
    this.url = "jdbc:mysql://localhost:" + Integer.toString(this.port) + "/" + this.dbName;
    Properties props = new Properties();
    props.setProperty("user","root");
    props.setProperty("password","123456");
    props.setProperty("ssl","false");
    this.connection = DriverManager.getConnection(url, props);
  }

    public String getDbName() {
        return dbName;
    }

  public Connection getConnection() {
    return this.connection;
  }

  public static DBConnection getInstance() throws SQLException {
    if(instance == null){
      instance = new DBConnection();
    }
    else if (instance.getConnection().isClosed()) {
      instance = new DBConnection();
    }
    return instance;
  }
}