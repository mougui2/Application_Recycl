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
public class DetailsDepotDto {
    TourneeDto tournee;
    CentreTraitementDto centreTraitement;
    int quantite;

    public TourneeDto getTournee() {
        return tournee;
    }

    public void setTournee(TourneeDto tournee) {
        this.tournee = tournee;
    }

    public CentreTraitementDto getCentreTraitement() {
        return centreTraitement;
    }

    public void setCentreTraitement(CentreTraitementDto centreTraitement) {
        this.centreTraitement = centreTraitement;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public DetailsDepotDto(TourneeDto tournee, CentreTraitementDto centreTraitement, int quantite) {
        this.tournee = tournee;
        this.centreTraitement = centreTraitement;
        this.quantite = quantite;
    }
}
