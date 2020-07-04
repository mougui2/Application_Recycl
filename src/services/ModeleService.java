/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.ModeleDto;
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
public class ModeleService {
    
    public ModeleDto getOneByIdModele(int idModele) {
        ModeleDto modele = null;
        
        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/modeles/" + String.valueOf(idModele)));
            JSONObject json = new JSONObject(str);
            modele = new Gson().fromJson(json.toString(), ModeleDto.class);
            modele.setMarque(new MarqueService().getOneByIdMarque(json.getInt("idMarque")));
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(FonctionService.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return modele;
    }
    
}
