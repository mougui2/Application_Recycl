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
public class CamionDto {
    int id;
    ModeleDto modele;
    TypeDechetDto typeDechet;

    public CamionDto(int id, ModeleDto modele, TypeDechetDto typeDechet) {
        this.id = id;
        this.modele = modele;
        this.typeDechet = typeDechet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModeleDto getModele() {
        return modele;
    }

    public void setModele(ModeleDto modele) {
        this.modele = modele;
    }

    public TypeDechetDto getTypeDechet() {
        return typeDechet;
    }

    public void setTypeDechet(TypeDechetDto typeDechet) {
        this.typeDechet = typeDechet;
    }
    
    @Override
    public String toString() { 
        return String.format(modele.getLibelle() + " " + modele.getMarque().getLibelle() + " " + typeDechet.getLibelle()); 
    }
}
