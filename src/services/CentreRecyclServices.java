/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.CentreDto;
import ModelDTO.CentreRecyclDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONArray;
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

    public List<CentreRecyclDto> getAll() {
        List<CentreRecyclDto> centresRecycl = new ArrayList<>();
        List<CentreRecyclDto> centresRecyclPotentiel = new ArrayList<>();
        List<Integer> idsCentresRecycl = getAllIds();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/centres"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                CentreRecyclDto centre = new Gson().fromJson(item.toString(), CentreRecyclDto.class);
                centresRecyclPotentiel.add(centre);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(CentreRecyclServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < idsCentresRecycl.size(); i++) {
            int id = idsCentresRecycl.get(i);
            CentreRecyclDto _centre = centresRecyclPotentiel.stream().filter(centre -> centre.getId() == id).collect(Collectors.toList()).get(0);
            centresRecycl.add(_centre);
        }
        

        return centresRecycl;
    }

    public List<Integer> getAllIds() {
        List<Integer> centresRecycl = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/centrerecycls"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                CentreRecyclDto centre = new Gson().fromJson(item.toString(), CentreRecyclDto.class);
                centresRecycl.add(centre.getId());
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(CentreRecyclServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return centresRecycl;
    }

}
