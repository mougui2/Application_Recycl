/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.CamionDto;
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
public class CamionServices {

    public List<CamionDto> getAll() {
        List<CamionDto> camions = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/camions?per-page=1000"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                CamionDto camion = new Gson().fromJson(item.toString(), CamionDto.class);
                camion.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(item.getInt("idTypeDechet")));
                camion.setModele(new ModeleService().getOneByIdModele(item.getInt("idModele")));
                camions.add(camion);
            }
        } catch (JSONException | MalformedURLException ex) {
            Logger.getLogger(CamionServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return camions;
    }

    public List<CamionDto> getAllFromIdTypeDechet(int idTypeDechet) {
        List<CamionDto> camionsFiltred = new ArrayList<>();
        List<CamionDto> camions = getAll();

        for (int i = 0; i < camions.size(); i++) {
            CamionDto camion = camions.get(i);
            if (camion.getTypeDechet().getId() == idTypeDechet) {
                camionsFiltred.add(camion);
            }
        }

        return camionsFiltred;
    }

    public CamionDto getOneByIdCamion(int idCamion) {
        CamionDto camion = null;

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/camions/" + String.valueOf(idCamion)));
            JSONObject json = new JSONObject(str);
            camion = new Gson().fromJson(json.toString(), CamionDto.class);
            camion.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(json.getInt("idTypeDechet")));
            camion.setModele(new ModeleService().getOneByIdModele(json.getInt("idModele")));
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(CamionServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return camion;
    }

}
