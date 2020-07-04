/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.DetailsTourneeDto;
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
public class DetailsTourneeServices {
 
    public List<DetailsTourneeDto> getAll() {
        List<DetailsTourneeDto> detailsTournees = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/detailstournees"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                DetailsTourneeDto detailsTournee = new Gson().fromJson(item.toString(), DetailsTourneeDto.class);
                detailsTournee.setTournee(new TourneeService().getOneById(item.getInt("idTournee")));
                detailsTournee.setTypeDechet(new TypeDechetService().getOneByIdTypeDechet(item.getInt("idTypeDechet")));
                detailsTournee.setDetailsDemande(new DetailsDemandeServices().getOneById(item.getInt("idDetailsDemande")));
                detailsTournees.add(detailsTournee);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(DetailsTourneeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return detailsTournees;
    }
 
    public List<DetailsTourneeDto> getAllByIdTournee(int idTournee) {
        List<DetailsTourneeDto> detailsTourneesFiltred = new ArrayList<>();
        List<DetailsTourneeDto> detailsTournees = getAll();

        for (int i = 0; i < detailsTournees.size(); i++) {
            DetailsTourneeDto detailsTournee = detailsTournees.get(i);
            if (detailsTournee.getTournee().getId() == idTournee) {
                detailsTourneesFiltred.add(detailsTournee);
            }
        }
        
        return detailsTourneesFiltred;
    }
    
}
