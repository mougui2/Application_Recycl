/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.CentreRecyclDto;
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
public class CentreRecyclServices {
    
    public CentreRecyclDto getOneById(int id) {
        CentreRecyclDto centreRecycl = null;

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/centrerecycls/" + String.valueOf(id)));
            JSONObject json = new JSONObject(str);
            centreRecycl = new Gson().fromJson(json.toString(), CentreRecyclDto.class);
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(CentreRecyclServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return centreRecycl;
    }
    
}
