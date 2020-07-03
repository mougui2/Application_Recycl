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
public class EntrepriseDto {
    long siret;
    String raisonSociale;
    int numAdresse;
    String rueAdresse;
    String ville;
    int codePostal;
    int telephone;
    String contact;

    public EntrepriseDto(long siret, String raisonSociale, int numAdresse, String rueAdresse, String ville, int codePostal, int telephone, String contact) {
        this.siret = siret;
        this.raisonSociale = raisonSociale;
        this.numAdresse = numAdresse;
        this.rueAdresse = rueAdresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.contact = contact;
    }

    public long getSiret() {
        return siret;
    }

    public void setSiret(int siret) {
        this.siret = siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
