/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.DemandeDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
