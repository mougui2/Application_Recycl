/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.DetailsDemandeDto;
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
public class DetailsDemandeServices {

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
