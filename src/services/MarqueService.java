/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.MarqueDto;
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
public class MarqueService {
    
    public MarqueDto getOneByIdMarque(int idMarque) {
        MarqueDto marque = null;
        
        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/marques/" + String.valueOf(idMarque)));
            JSONObject json = new JSONObject(str);
            marque = new Gson().fromJson(json.toString(), MarqueDto.class);
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(MarqueService.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return marque;
    }
    
}
