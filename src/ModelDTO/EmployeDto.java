/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDTO;

import java.util.Date;

/**
 *
 * @author morga
 */
public class EmployeDto {
    int id;
    String nom;
    String prenom;
    Date dateNaissance;    
    Date dateEmbauche;
    Date dateExpiration;
    String login;
    String motDePasse;
    int tentative;
    FonctionDto fonction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getTentative() {
        return tentative;
    }

    public void setTentative(int tentative) {
        this.tentative = tentative;
    }

    public FonctionDto getFonction() {
        return fonction;
    }

    public void setFonction(FonctionDto fonction) {
        this.fonction = fonction;
    }

    public EmployeDto(int id, String nom, String prenom, Date dateNaissance, Date dateEmbauche, Date dateExpiration, String login, String motDePasse, int tentative, FonctionDto fonction) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.dateExpiration = dateExpiration;
        this.login = login;
        this.motDePasse = motDePasse;
        this.tentative = tentative;
        this.fonction = fonction;
    }

    public EmployeDto(int id, String nom, String prenom, Date dateNaissance, Date dateEmbauche, Date dateExpiration, String login, int tentative, FonctionDto fonction) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.dateExpiration = dateExpiration;
        this.login = login;
        this.tentative = tentative;
        this.fonction = fonction;
    }
    
    @Override
    public String toString() { 
        return String.format(prenom + " " + nom); 
    }

}
