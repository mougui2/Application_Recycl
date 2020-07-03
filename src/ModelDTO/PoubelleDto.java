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
public class PoubelleDto {
    int id;
    int latitude;
    int longitude;
    int tauxDeRemplissage;
    boolean doitEtreVidee;
    TypeDechetDto typeDechet;

    public PoubelleDto(int id, int latitude, int longitude, int tauxDeRemplissage, boolean doitEtreVidee, TypeDechetDto typeDechet) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tauxDeRemplissage = tauxDeRemplissage;
        this.doitEtreVidee = doitEtreVidee;
        this.typeDechet = typeDechet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getTauxDeRemplissage() {
        return tauxDeRemplissage;
    }

    public void setTauxDeRemplissage(int tauxDeRemplissage) {
        this.tauxDeRemplissage = tauxDeRemplissage;
    }

    public boolean isDoitEtreVidee() {
        return doitEtreVidee;
    }

    public void setDoitEtreVidee(boolean doitEtreVidee) {
        this.doitEtreVidee = doitEtreVidee;
    }

    public TypeDechetDto getTypeDechet() {
        return typeDechet;
    }

    public void setTypeDechet(TypeDechetDto typeDechet) {
        this.typeDechet = typeDechet;
    }
    
    
}
