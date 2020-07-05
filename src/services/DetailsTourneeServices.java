/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.DetailsDemandeDto;
import ModelDTO.DetailsTourneeDto;
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
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author eddy.parisi
 */
public class DetailsTourneeServices {
    
    public DetailsTourneeDto create(DetailsTourneeDto detailsTournee) {
        DetailsTourneeDto _detailsTournee = null;
        
        try {
            URL url = new URL("http://hadrixserver.ddns.net:32780/detailstournees");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = String.valueOf(
                    "idTournee=" + detailsTournee.getTournee().getId()
                    + "&idDetailsDemande=" + detailsTournee.getDetailsDemande().getIdDemande()
                    + "&idTypeDechet=" + detailsTournee.getTypeDechet().getId()
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
            _detailsTournee = new Gson().fromJson(item.toString(), DetailsTourneeDto.class);
        } catch (JSONException | IOException ex) {
            Logger.getLogger(DetailsTourneeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return _detailsTournee;
    }
 
    public List<DetailsTourneeDto> getAll() {
        List<DetailsTourneeDto> detailsTournees = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/detailstournees"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                DetailsTourneeDto detailsTournee = new Gson().fromJson(item.toString(), DetailsTourneeDto.class);
                detailsTournee.setTournee(new TourneeService().getOneById(item.getInt("idTournee")));
                detailsTournee.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(item.getInt("idTypeDechet")));
                detailsTournee.setDetailsDemande(new DetailsDemandeServices().getOneById(item.getInt("idDetailsDemande")));
                detailsTournees.add(detailsTournee);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(DetailsTourneeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detailsTournees;
    }
 
    public List<DetailsTourneeDto> getAllByIdTournee(int idTournee) {
        List<DetailsTourneeDto> detailsTourneesFiltred = new ArrayList<>();
        List<DetailsTourneeDto> detailsTournees = getAll();

        for (int i = 0; i < detailsTournees.size(); i++) {
            DetailsTourneeDto detailsTournee = detailsTournees.get(i);
            if (detailsTournee.getTournee().getId() == idTournee) {
                detailsTourneesFiltred.add(detailsTournee);
            }
        }
        
        return detailsTourneesFiltred;
    }
    
}
