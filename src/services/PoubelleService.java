/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.PoubelleDto;
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
public class PoubelleService {

    public List<PoubelleDto> getAll() {
        List<PoubelleDto> poubelles = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/poubelles"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                PoubelleDto poubelle = new Gson().fromJson(item.toString(), PoubelleDto.class);
                poubelle.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(item.getInt("idTypeDechet")));
                poubelles.add(poubelle);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(PoubelleService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return poubelles;
    }

    public List<PoubelleDto> getAll_DoitEtreVidee() {
        List<PoubelleDto> poubellesAVidee = new ArrayList<>();
        List<PoubelleDto> poubelles = getAll();

        for (int i = 0; i < poubelles.size(); i++) {
            PoubelleDto poubelle = poubelles.get(i);
            if (poubelle.isDoitEtreVidee()) {
                poubellesAVidee.add(poubelle);
            }
        }

        return poubellesAVidee;
    }
    
    public List<PoubelleDto> getAll_AVidee_libelleTypeDechet(String libelleTypeDechet) {
        List<PoubelleDto> poubellesAVideeTypeDechet = new ArrayList<>();
        List<PoubelleDto> poubellesAvidee = getAll_DoitEtreVidee();

        for (int i = 0; i < poubellesAvidee.size(); i++) {
            PoubelleDto poubelle = poubellesAvidee.get(i);
            if (poubelle.getTypeDechet().getLibelle().equals(libelleTypeDechet)) {
                poubellesAVideeTypeDechet.add(poubelle);
            }
        }

        return poubellesAVideeTypeDechet;
    }

    public PoubelleDto getOneById(int id) {
        PoubelleDto poubelle = null;
        
        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/poubelles/" + String.valueOf(id)));
            JSONObject json = new JSONObject(str);
            poubelle = new Gson().fromJson(json.toString(), PoubelleDto.class);
            poubelle.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(json.getInt("idTypeDechet")));
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(PoubelleService.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return poubelle;
    }
    
}
