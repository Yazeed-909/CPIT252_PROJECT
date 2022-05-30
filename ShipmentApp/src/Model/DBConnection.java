package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection{
  private final String url;
  private final int port;
  public final String dbName;
  private Connection connection;

  private static DBConnection instance;

  private DBConnection() throws SQLException {
  
    this.dbName = "sys";
    this.port = 3307;
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
  
  
  
  public void insertShipment(String tracking_number,String id,String carrier_code,String status,String lastUpdateTime,String ItemReceived,String created_at,String weblink,String updated_at){
        try {
            CreateTable();
            PreparedStatement insertStmt =
            connection.prepareStatement("INSERT INTO Shipments (tracking_number, id, carrier_code, status, lastUpdateTime, ItemReceived, created_at, weblink, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            insertStmt.setString(1, tracking_number);
            insertStmt.setString(2, (id));
            insertStmt.setString(3, (carrier_code));
            insertStmt.setString(4, (status));
            insertStmt.setString(5, (lastUpdateTime));
            insertStmt.setString(6, (ItemReceived));
            insertStmt.setString(7, (created_at));
            insertStmt.setString(8, (weblink));
            insertStmt.setString(9, (updated_at));
            
            int rows = insertStmt.executeUpdate();
            System.out.println("Number of Rows affected: " + rows);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
  public void CreateTable(){

      java.sql.Statement stm = null;
      try {
          stm = connection.createStatement();
          stm.executeUpdate("CREATE TABLE IF NOT EXISTS Shipments "
                    + "(tracking_number varchar(250) primary key , id varchar(250) NOT NULL,"
                  + " carrier_code varchar(250) NOT NULL, status varchar(50) NOT NULL,"
                  + " lastUpdateTime varchar(50) NOT NULL,"
                  + " ItemReceived varchar(50) NOT NULL,created_at varchar(50) NOT NULL,"
                  + "weblink varchar(100) NOT NULL,updated_at varchar(100) NOT NULL) ");
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
      
      
      
      
      
  }

  
      public void retrieveShipment(){
      try {
          String query = "SELECT * FROM new_table";
          java.sql.Statement stm=null;
          ResultSet rs = stm.executeQuery(query);
          while(rs.next()){
              
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
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }

    }

  
  
}