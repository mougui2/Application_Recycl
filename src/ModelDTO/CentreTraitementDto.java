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
  
    public CentreTraitementDto(int id, int numAdresse, String rueADresse, int codePostal, String ville) {
        super(id, numAdresse, rueADresse, codePostal, ville);
    }
    
}
