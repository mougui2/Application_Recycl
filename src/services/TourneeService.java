/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.TourneeDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author morga
 */
public class TourneeService {

    public List<TourneeDto> getTournees() {
        List<TourneeDto> tourneeList = new ArrayList<TourneeDto>();
        try {
            String response = DataBaseTools.GetJsonResponse(new URL("http://51.254.38.176/tournees"));
            
            JSONArray json = new JSONArray(response.toString());

            Gson gson = new Gson();

            List<TourneeDto> temp = new ArrayList<TourneeDto>();
            temp = gson.fromJson(json.toString(), temp.getClass());

            for (int i = 0; i < json.length(); i++) {
                JSONObject tourneeJson = json.getJSONObject(i);
                tourneeList.add(gson.fromJson(tourneeJson.toString(), TourneeDto.class));
            }

//            for (int i = 0; i < json.length(); i++) {
//                JSONObject item = json.getJSONObject(i);
//                if (item.getString("login").equals(login)) {
//                    Gson gson = new Gson();
//                    EmployeDto _loggedEmp = gson.fromJson(item.toString(), EmployeDto.class);
//                    if (_loggedEmp.getTentative() >= 3) {
//                        //Rejecter le user -> afficher le pannel et return null
//                    } else if (item.getString("motDePasse").equals(password)) {
//                        _loggedEmp.setTentative(0);
//                        loggedEmp = _loggedEmp;
//                    } else {
//                        //Rejecter le user -> afficher le pannel et return null
//                        _loggedEmp.setTentative(_loggedEmp.getTentative() + 1);
//                    }
//                    break;
//                }
//            }
        } catch (Exception ex) {

        }
        return tourneeList;
    }
    
    public List<Integer> getAllIdEmploye(){
        List<Integer> idsEmploye = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/tournees"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                idsEmploye.add(item.getInt("idEmploye"));
            }
        } catch (MalformedURLException | JSONException ex) {
        }

        return idsEmploye;
    }

}
