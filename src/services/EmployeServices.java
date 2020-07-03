/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.EmployeDto;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author eddy.parisi
 */
public class EmployeServices {

    public EmployeDto save(EmployeDto employe) {

        try {
            // Recuperation de tous les users en JSONArray
            URL url = new URL("http://hadrixserver.ddns.net:32780/employes/" + String.valueOf(employe.getId()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = "motDePasse=" + employe.getMotDePasse() + "&tentative=" + employe.getTentative();
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);
            connection.getInputStream();
        } catch (IOException e) {
            Logger.getLogger(AuthServices.class.getName()).log(Level.SEVERE, null, e);
        }

        return employe;
    }

    public Boolean save(int id, String password) {

        try {
            // Recuperation de tous les users en JSONArray
            URL url = new URL("http://hadrixserver.ddns.net:32780/employes/" + String.valueOf(id));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = "motDePasse=" + password + "&tentative=" + 0;
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);
            connection.getInputStream();
            return true;
        } catch (IOException e) {
            Logger.getLogger(AuthServices.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

}
