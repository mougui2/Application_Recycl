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
public class TypeDechetDto {
    int id;
    String libelle;
    float tarifForfaitaire;
    float tarifParLot;
    int nivDanger;

    public TypeDechetDto(int id, String libelle, float tarifForfaitaire, float tarifParLot, int nivDanger) {
        this.id = id;
        this.libelle = libelle;
        this.tarifForfaitaire = tarifForfaitaire;
        this.tarifParLot = tarifParLot;
        this.nivDanger = nivDanger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getTarifForfaitaire() {
        return tarifForfaitaire;
    }

    public void setTarifForfaitaire(float tarifForfaitaire) {
        this.tarifForfaitaire = tarifForfaitaire;
    }

    public float getTarifParLot() {
        return tarifParLot;
    }

    public void setTarifParLot(float tarifParLot) {
        this.tarifParLot = tarifParLot;
    }

    public int getNivDanger() {
        return nivDanger;
    }

    public void setNivDanger(int nivDanger) {
        this.nivDanger = nivDanger;
    }
}
