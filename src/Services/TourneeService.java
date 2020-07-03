/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ModelDTO.TourneeDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author morga
 */
public class TourneeService {

    public static List<TourneeDto> getTournees() {
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

}
