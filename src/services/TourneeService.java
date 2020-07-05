/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.DemandeDto;
import ModelDTO.DetailsTourneeDto;
import ModelDTO.TourneeDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author morga
 */
public class TourneeService {

    public TourneeDto create(TourneeDto tournee) {
        TourneeDto _tournee = null;
        
        try {
            URL url = new URL("http://hadrixserver.ddns.net:32780/tournees");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = String.valueOf(
                    "date=" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
                    + "&idEmploye=" + tournee.getEmploye().getId()
                    + "&idCamion=" + tournee.getCamion().getId()
            );
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);
            connection.getInputStream();
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            JSONObject item = new JSONObject(response.toString());
            _tournee = new Gson().fromJson(item.toString(), TourneeDto.class);
        } catch (MalformedURLException ex) { 
            Logger.getLogger(TourneeService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(TourneeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return _tournee;
    }

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

    public List<TourneeDto> getAll() {
        List<TourneeDto> tournees = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/tournees"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                TourneeDto tournee = new Gson().fromJson(item.toString(), TourneeDto.class);
                tournee.setCamion(new CamionServices().getOneByIdCamion(item.getInt("idCamion")));
                tournee.setEmploye(new EmployeServices().getOneByIdEmploye(item.getInt("idEmploye")));
                tournee.setDetailsTourneeList(new DetailsTourneeServices().getAllByIdTournee(item.getInt("id")));
                tournees.add(tournee);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(TourneeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tournees;
    }

    public List<TourneeDto> getAllFromIdEmploye(int idEmploye) {
        List<TourneeDto> tourneesFiltred = new ArrayList<>();
        List<TourneeDto> tournees = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/tournees"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                TourneeDto tournee = new Gson().fromJson(item.toString(), TourneeDto.class);
                tournee.setCamion(new CamionServices().getOneByIdCamion(item.getInt("idCamion")));
                tournee.setEmploye(new EmployeServices().getOneByIdEmploye(item.getInt("idEmploye")));
                List<DetailsTourneeDto> temp = new DetailsTourneeServices().getAllByIdTournee(item.getInt("id"));
                tournee.setDetailsTourneeList(temp);
                tournees.add(tournee);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(TourneeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < tournees.size(); i++) {
            TourneeDto tournee = tournees.get(i);
            if (tournee.getEmploye().getId() == idEmploye) {
                tourneesFiltred.add(tournee);
            }
        }

        return tourneesFiltred;
    }

    public List<Integer> getAllIdEmploye() {
        List<Integer> idsEmploye = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/tournees"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                idsEmploye.add(item.getInt("idEmploye"));
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(TourneeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idsEmploye;
    }

    public TourneeDto getOneById(int id) {
        TourneeDto tournee = null;

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/tournees/" + String.valueOf(id)));
            JSONObject json = new JSONObject(str);
            tournee = new Gson().fromJson(json.toString(), TourneeDto.class);
            tournee.setCamion(new CamionServices().getOneByIdCamion(json.getInt("idCamion")));
            tournee.setEmploye(new EmployeServices().getOneByIdEmploye(json.getInt("idEmploye")));
            //tournee.setDetailsTourneeList(new DetailsTourneeServices().getAllByIdTournee(json.getInt("id")));
        } catch (JSONException | MalformedURLException ex) {
            Logger.getLogger(TourneeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tournee;
    }
}
