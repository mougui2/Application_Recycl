/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.TypeDechetDto;
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
public class TypeDechetService {

    public List<TypeDechetDto> getAll() {
        List<TypeDechetDto> typesDechet = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/typedechets"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                TypeDechetDto typeDechet = new Gson().fromJson(item.toString(), TypeDechetDto.class);
                typesDechet.add(typeDechet);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(FonctionService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(TypeDechetService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return typesDechet;
    }
    
    public TypeDechetDto getOneByIdTypeDechet(int idTypeDechet) {
        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/typedechets/" + String.valueOf(idTypeDechet)));
            JSONObject item = new JSONObject(str);
            return new Gson().fromJson(item.toString(), TypeDechetDto.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FonctionService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(TypeDechetService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
