/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.cpit252_project;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author yzeed
 */
public class CPIT252_PROJECT {

    public static void main(String[] args) {
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.tracktry.com/v1/trackings/zajil/Z8000543"))
                    .header("Content-Type", "application/json")
                    .header("Tracktry-Api-Key", "7802c747-567c-42aa-b5aa-fc311647fd31")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).
                    thenApply(HttpResponse::body).thenApply(CPIT252_PROJECT::pars).join();

            Shipment s = create_shipment(pars(response.body()));
            System.out.println(s.toString());

            DBConnection db = DBConnection.getInstance();
            

           
            
            s.insertShipment();
            
            s.retrieveShipment();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(CPIT252_PROJECT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(CPIT252_PROJECT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static StringTokenizer pars(String body) {
        body = "[" + body + "]";
        JSONArray d = new JSONArray(body);

        JSONObject a = d.getJSONObject(0);

        String s = a.toMap().get("data").toString();

        StringTokenizer t = new StringTokenizer(s, ",{}");
        return t;

    }

    public static Shipment create_shipment(StringTokenizer t) {

        ArrayList<Shipment_status> shipment_status = new ArrayList<>();

        String tracking_number = null, id = null, carrier_code = null, status = null, lastUpdateTime = null, ItemReceived = null, created_at = null, weblink = null, updated_at = null;

        while (t.hasMoreTokens()) {

            String l = t.nextToken();

            if (l.startsWith(" tracking_number")) {
                tracking_number = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" id")) {
                id = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" carrier_code")) {
                carrier_code = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" status")) {
                status = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" lastUpdateTime")) {
                lastUpdateTime = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" ItemReceived")) {
                ItemReceived = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" created_at")) {
                created_at = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" weblink")) {
                weblink = (l.substring(l.indexOf("=")).replace("=", ""));
            }
            if (l.startsWith(" updated_at")) {
                updated_at = (l.substring(l.indexOf("=")).replace("=", ""));
            }

            if (l.startsWith("checkpoint_status")) {
                l = t.nextToken();
                if (l.startsWith(" ItemNode")) {
                    l = t.nextToken();
                }
                if (l.startsWith(" Details")) {
                    String Location, Current_status_code, Current_status, Time;

                    Location = l.substring(l.indexOf("=")).replace("=", "");
                    l = t.nextToken();
                    Current_status_code = l.substring(l.indexOf("=")).replace("=", "");
                    l = t.nextToken();
                    Current_status = l.substring(l.indexOf("=")).replace("=", "");
                    l = t.nextToken();
                    Time = l.substring(l.indexOf("=")).replace("=", "");
                    shipment_status.add(new Shipment_status(Location, Current_status_code, Current_status, Time));
                }

            }

        }

        for (int i = 0; i < shipment_status.size(); i++) {
            Shipment_status get = shipment_status.get(i);
            System.out.println(get.toString());
        }

        return new Shipment(tracking_number, id, carrier_code, status, lastUpdateTime, ItemReceived, created_at, weblink, updated_at);

    }

}
