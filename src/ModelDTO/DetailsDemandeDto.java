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
public class DetailsDemandeDto {
    int idDemande;
    TypeDechetDto typeDechet;
    int quantite;
    PoubelleDto poubelle;

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public TypeDechetDto getTypeDechet() {
        return typeDechet;
    }

    public void setTypeDechet(TypeDechetDto typeDechet) {
        this.typeDechet = typeDechet;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PoubelleDto getPoubelle() {
        return poubelle;
    }

    public void setPoubelle(PoubelleDto poubelle) {
        this.poubelle = poubelle;
    }

    public DetailsDemandeDto(int idDemande, TypeDechetDto typeDechet, int quantite, PoubelleDto poubelle) {
        this.idDemande = idDemande;
        this.typeDechet = typeDechet;
        this.quantite = quantite;
        this.poubelle = poubelle;
    }
    
}
