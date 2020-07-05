/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.DetailsDemandeDto;
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
public class DetailsDemandeServices {
    
    public DetailsDemandeDto create(DetailsDemandeDto detailsDemande, int idPoubelle) {
        DetailsDemandeDto _detailsDemande = null;
        
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
                    "idDemande=" + detailsDemande.getIdDemande()
                    + "&idTypeDechet=" + detailsDemande.getTypeDechet().getId()
                    + "&quantite=" + detailsDemande.getQuantite()
                    + "&idPoubelle=" + idPoubelle
            );
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);
            connection.getInputStream();
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
            _detailsDemande = new Gson().fromJson(item.toString(), DetailsDemandeDto.class);
        } catch (JSONException ex) {
            Logger.getLogger(DetailsDemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DetailsDemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return _detailsDemande;
    }

    public List<DetailsDemandeDto> getAll() {
        List<DetailsDemandeDto> detailsDemandes = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/detailsdemandes"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                DetailsDemandeDto detailsDemande = new Gson().fromJson(item.toString(), DetailsDemandeDto.class);
                detailsDemande.setPoubelle(new PoubelleService().getOneById(item.getInt("idPoubelle")));
                detailsDemande.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(item.getInt("idTypeDechet")));
                detailsDemandes.add(detailsDemande);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(DetailsDemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detailsDemandes;
    }
    
    public DetailsDemandeDto getOneById(int id) {
        DetailsDemandeDto detailsDemandeFiltred = null;
        List<DetailsDemandeDto> detailsDemandes = getAll();

        for (int i = 0; i < detailsDemandes.size(); i++) {
            DetailsDemandeDto detailsDemande = detailsDemandes.get(i);
            if (detailsDemande.getIdDemande()== id) {
                detailsDemandeFiltred = detailsDemande;
                break;
            }
        }

        return detailsDemandeFiltred;
    }
    
}
