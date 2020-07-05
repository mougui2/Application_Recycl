/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDTO;

import java.util.List;

/**
 *
 * @author morga
 */
public class CentreTraitementDto extends CentreDto {
    List<PriseEnChargeDto> priseEnChargeList;

    public List<PriseEnChargeDto> getPriseEnChargeList() {
        return priseEnChargeList;
    }

    public void setPriseEnChargeList(List<PriseEnChargeDto> priseEnChargeList) {
        this.priseEnChargeList = priseEnChargeList;
    }
  
    public CentreTraitementDto(int id, int numAdresse, String rueAdresse, int codePostal, String ville) {
        super(id, numAdresse, rueAdresse, codePostal, ville);
    }
    
    @Override
    public String toString() { 
        return String.format(id + " : " + numAdresse + ", " + rueAdresse + ". " + codePostal + " " + ville + "."); 
    }
    
}
