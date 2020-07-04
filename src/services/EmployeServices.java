/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.EmployeDto;
import Tools.DataBaseTools;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
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
public class EmployeServices {

    public EmployeDto save(EmployeDto employe) {

        try {
            // Recuperation de tous les users en JSONArray
            URL url = new URL("http://hadrixserver.ddns.net:32780/employes/" + String.valueOf(employe.getId()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = "motDePasse=" + employe.getMotDePasse() + "&tentative=" + employe.getTentative();
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);
            connection.getInputStream();
        } catch (IOException e) {
            Logger.getLogger(AuthServices.class.getName()).log(Level.SEVERE, null, e);
        }

        return employe;
    }

    public Boolean save(int id, String password) {

        try {
            // Recuperation de tous les users en JSONArray
            URL url = new URL("http://hadrixserver.ddns.net:32780/employes/" + String.valueOf(id));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            String urlParameters = "motDePasse=" + password + "&tentative=0";
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(postData);
            connection.getInputStream();
            return true;
        } catch (IOException e) {
            Logger.getLogger(AuthServices.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }

    public List<EmployeDto> getAll() {
        List<EmployeDto> employes = new ArrayList<>();

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/employes"));
            JSONArray json = new JSONArray(str);
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                EmployeDto employe = new Gson().fromJson(item.toString(), EmployeDto.class);
                employe.setFonction(new FonctionService().getByIdFonction(item.getInt("idFonction")));
                employes.add(employe);
            }
        } catch (MalformedURLException | JSONException ex) {
            Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employes;
    }

    public List<EmployeDto> getAllChauffeursLibres() {
        List<EmployeDto> employesLibre = new ArrayList<>();
        List<EmployeDto> employes = getAll();
        List<Integer> idsEmployeOccupés = new TourneeService().getAllIdEmploye();

        for (int i = 0; i < employes.size(); i++) {
            EmployeDto emp = employes.get(i);
            Boolean isOccupe = false;
            for (int j = 0; j < idsEmployeOccupés.size(); j++) {
                if (emp.getId() == idsEmployeOccupés.get(j)) {
                    isOccupe = true;
                }
            }
            if (!isOccupe) {
                employesLibre.add(emp);
            }
        }
        //On garde que le rôle Employe, grace à normalisation du login
        Stream<EmployeDto> streamEmpLibre = employesLibre.stream().filter(
                empLibre -> empLibre.getLogin().substring(0, 1).equals("E"));

        return streamEmpLibre.collect(Collectors.toList());
    }

    public EmployeDto getOneByIdEmploye(int idEmploye) {
        EmployeDto employe = null;

        try {
            String str = DataBaseTools.GetJsonResponse(new URL("http://hadrixserver.ddns.net:32780/employes/" + String.valueOf(idEmploye)));
            JSONObject json = new JSONObject(str);
            employe.setFonction(new FonctionService().getByIdFonction(json.getInt("idFonction")));
            employe = new Gson().fromJson(json.toString(), EmployeDto.class);
        } catch (JSONException | MalformedURLException ex) {
            Logger.getLogger(EmployeServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employe;
    }

}
