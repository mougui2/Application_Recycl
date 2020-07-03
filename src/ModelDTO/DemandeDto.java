/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author morga
 */
public class DemandeDto {
    int id;
    String remarque;
    Date dateDemande;
    Date dateEnlevement;
    EntrepriseDto entreprise;
    CentreRecyclDto centreRecycl;
    List<DetailsDemandeDto> detailsDemandeList;

    public List<DetailsDemandeDto> getDetailsDemandeList() {
        return detailsDemandeList;
    }

    public void setDetailsDemandeList(List<DetailsDemandeDto> detailsDemandeList) {
        this.detailsDemandeList = detailsDemandeList;
    }
    
    
    public DemandeDto(int id, String remarque, Date dateDemande, EntrepriseDto entreprise, CentreRecyclDto centreRecycl) {
        this.id = id;
        this.remarque = remarque;
        this.dateDemande = dateDemande;
        this.entreprise = entreprise;
        this.centreRecycl = centreRecycl;
    }

    public DemandeDto(int id, String remarque, Date dateDemande, Date dateEnlevement, EntrepriseDto entreprise, CentreRecyclDto centreRecycl) {
        this.id = id;
        this.remarque = remarque;
        this.dateDemande = dateDemande;
        this.dateEnlevement = dateEnlevement;
        this.entreprise = entreprise;
        this.centreRecycl = centreRecycl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Date getDateEnlevement() {
        return dateEnlevement;
    }

    public void setDateEnlevement(Date dateEnlevement) {
        this.dateEnlevement = dateEnlevement;
    }

    public EntrepriseDto getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(EntrepriseDto entreprise) {
        this.entreprise = entreprise;
    }

    public CentreRecyclDto getCentreRecycl() {
        return centreRecycl;
    }

    public void setCentreRecycl(CentreRecyclDto centreRecycl) {
        this.centreRecycl = centreRecycl;
    }
    
}
