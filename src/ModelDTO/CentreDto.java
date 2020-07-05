/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDTO;

/**
 *
 * @author morga
 */
public class CentreDto {
    int id;
    int numAdresse;
    String rueAdresse;
    int codePostal;
    String ville;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumAdresse() {
        return numAdresse;
    }

    public void setNumAdresse(int numAdresse) {
        this.numAdresse = numAdresse;
    }

    public String getRueAdresse() {
        return rueAdresse;
    }

    public void setRueAdresse(String rueAdresse) {
        this.rueAdresse = rueAdresse;
    }
    

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public CentreDto(int id, int numAdresse, String rueADresse, int codePostal, String ville) {
        this.id = id;
        this.numAdresse = numAdresse;
        this.rueAdresse = rueADresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    
}
