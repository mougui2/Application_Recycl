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
public class PriseEnChargeDto {
    CentreTraitementDto centreTraitement;
    TypeDechetDto typeDechet;
    int capaciteStockage;

    public PriseEnChargeDto(CentreTraitementDto centreTraitement, TypeDechetDto typeDechet, int capaciteStockage) {
        this.centreTraitement = centreTraitement;
        this.typeDechet = typeDechet;
        this.capaciteStockage = capaciteStockage;
    }

    public CentreTraitementDto getCentreTraitement() {
        return centreTraitement;
    }

    public void setCentreTraitement(CentreTraitementDto centreTraitement) {
        this.centreTraitement = centreTraitement;
    }

    public TypeDechetDto getTypeDechet() {
        return typeDechet;
    }

    public void setTypeDechet(TypeDechetDto typeDechet) {
        this.typeDechet = typeDechet;
    }

    public int getCapaciteStockage() {
        return capaciteStockage;
    }

    public void setCapaciteStockage(int capaciteStockage) {
        this.capaciteStockage = capaciteStockage;
    }
}
