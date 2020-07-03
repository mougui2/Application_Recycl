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
public class DetailsTourneeDto {
    TourneeDto tournee;
    DetailsDemandeDto detailsDemande;
    TypeDechetDto typeDechet;

    public DetailsTourneeDto(TourneeDto tournee, DetailsDemandeDto detailsDemande, TypeDechetDto typeDechet) {
        this.tournee = tournee;
        this.detailsDemande = detailsDemande;
        this.typeDechet = typeDechet;
    }

    public TourneeDto getTournee() {
        return tournee;
    }

    public void setTournee(TourneeDto tournee) {
        this.tournee = tournee;
    }

    public DetailsDemandeDto getDetailsDemande() {
        return detailsDemande;
    }

    public void setDetailsDemande(DetailsDemandeDto detailsDemande) {
        this.detailsDemande = detailsDemande;
    }

    public TypeDechetDto getTypeDechet() {
        return typeDechet;
    }

    public void setTypeDechet(TypeDechetDto typeDechet) {
        this.typeDechet = typeDechet;
    }
}
