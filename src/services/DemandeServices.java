/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.DemandeDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author eddy.parisi
 */
public class DemandeServices {
    
    public DemandeDto create(DemandeDto demande) {
        DemandeDto _demande = null;
        
        try {
            URL url = new URL("http://hadrixserver.ddns.net:32780/demandes");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = String.valueOf(
                    "remarque=" + demande.getRemarque()
                    + "&dateDemande=" + new SimpleDateFormat("yyyy-MM-dd").format(demande.getDateDemande())
                    + "&dateEnlevement=" + new SimpleDateFormat("yyyy-MM-dd").format(demande.getDateEnlevement())
                    + "&idEntreprise=" + demande.getEntreprise().getSiret()
                    + "&idCentreRecycl=" + demande.getCentreRecycl().getId()
            );
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            JSONObject item = new JSONObject(response.toString());
            _demande = getOneById(item.getInt("id"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return _demande;
    }
    
    public List<DemandeDto> getAll() {
        List<DemandeDto> demandes = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/demandes"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                DemandeDto demande = new Gson().fromJson(item.toString(), DemandeDto.class);
                demande.setCentreRecycl(new CentreRecyclServices().getOneById(item.getInt("idCentreRecycl")));
                demande.setEntreprise(new EntrepriseService().getOneById(item.getLong("idEntreprise")));
                demandes.add(demande);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return demandes;
    }

    public DemandeDto getOneById(int id) {
        DemandeDto demande = null;

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/demandes/" + String.valueOf(id)));
            JSONObject json = new JSONObject(str);
            demande = new Gson().fromJson(json.toString(), DemandeDto.class);
            //demande.setCentreRecycl(new CentreRecyclServices().getOneById(json.getInt("idCentreRecycl")));
            demande.setEntreprise(new EntrepriseService().getOneById(json.getLong("idEntreprise")));
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(DemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return demande;
    }
    
}
