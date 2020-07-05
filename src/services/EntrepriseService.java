/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.EntrepriseDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author eddy.parisi
 */
public class EntrepriseService {
    
    public Boolean create(EntrepriseDto newEntreprise) {
        try {
            // Recuperation de tous les users en JSONArray
            URL url = new URL("http://hadrixserver.ddns.net:32780/entreprises");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = "siret=" + Long.toString(newEntreprise.getSiret()) + 
                    "&raisonSociale=" + newEntreprise.getRaisonSociale()+
                    "&numAdresse=" + String.valueOf(newEntreprise.getNumAdresse()) +
                    "&rueAdresse=" + newEntreprise.getRueAdresse() +
                    "&codePostal=" + String.valueOf(newEntreprise.getCodePostal()) +
                    "&ville=" + newEntreprise.getVille() +
                    "&telephone=" + String.valueOf(newEntreprise.getTelephone()) +
                    "&contact=" + newEntreprise.getContact();
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
    
    public EntrepriseDto getOneById(long id) {
        EntrepriseDto entreprise = null;

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/entreprises/" + String.valueOf(id)));
            JSONObject json = new JSONObject(str);
            entreprise = new Gson().fromJson(json.toString(), EntrepriseDto.class);
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(EntrepriseService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entreprise;
    }
    
}
