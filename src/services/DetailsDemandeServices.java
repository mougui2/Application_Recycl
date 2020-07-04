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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author eddy.parisi
 */
public class DetailsDemandeServices {
    
    public DetailsDemandeDto getOneById(int id) {
        DetailsDemandeDto detailsDemande = null;
        
        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/detailsdemandes/" + String.valueOf(id)));
            JSONObject json = new JSONObject(str);
            detailsDemande = new Gson().fromJson(json.toString(), DetailsDemandeDto.class);
            detailsDemande.setPoubelle(new PoubelleService().getOneById(json.getInt("idPoubelle")));
            detailsDemande.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(json.getInt("idTypeDechet")));
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(DetailsDemandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return detailsDemande;
    }
    
}
