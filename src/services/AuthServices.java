/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ModelDTO.EmployeDto;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.json.*;

/**
 *
 * @author eddy.parisi
 */
public class AuthServices {

    public EmployeDto login(String login, String password, JLabel errorDialogText) {
        EmployeDto loggedEmp = null;

        try {
            // Recuperation de tous les users en JSONArray
            URL url = new URL("http://hadrixserver.ddns.net:32780/employes?per-page=1000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            String basicAuth = Base64.getEncoder().encodeToString(("admin:admin").getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + basicAuth);
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            JSONArray json = new JSONArray(response.toString());

            // Recuperation du user qui essaye de se login
            for (int i = 0; i < json.length(); i++) {
                JSONObject item = json.getJSONObject(i);
                if (item.getString("login").equals(login)) {
                    Gson gson = new Gson();
                    EmployeDto _loggedEmp = gson.fromJson(item.toString(), EmployeDto.class);
                    if (_loggedEmp.getTentative() >= 3) {
                        _loggedEmp = null;
                        errorDialogText.setText("Le compte est verrouillé : Trop de tentative. Veuillez contacter votre administrateur.");
                    } else if (item.getString("motDePasse").equals(password)) {
                        _loggedEmp.setTentative(0);
                        _loggedEmp.setFonction(new FonctionService().getByIdFonction(item.getInt("idFonction")));
                    } else {
                        _loggedEmp.setTentative(_loggedEmp.getTentative() + 1);
                        errorDialogText.setText("Mot de passe erroné. Tentative restante : " + (3 - _loggedEmp.getTentative()) + ".");
                    }
                    loggedEmp = _loggedEmp;
                    break;
                }
            }
            if (loggedEmp == null && errorDialogText.getText().equals("")) {
                errorDialogText.setText("Ce compte n'existe pas.");
            }
            if (loggedEmp != null ) {
                new EmployeServices().save(loggedEmp);
            }
        } catch (IOException | JSONException e) {
            Logger.getLogger(AuthServices.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return loggedEmp;
    }

}
