/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.FonctionDto;
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
public class FonctionService {

    public FonctionDto getByIdFonction(int idFonction) {
        FonctionDto fonction = null;
        
        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/fonctions/" + String.valueOf(idFonction)));
            JSONObject json = new JSONObject(str);
            fonction = new Gson().fromJson(json.toString(), FonctionDto.class);
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(FonctionService.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return fonction;
    }
}
