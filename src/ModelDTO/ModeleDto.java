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
public class ModeleDto {
    int id;
    String libelle;
    MarqueDto marque;

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

    public MarqueDto getMarque() {
        return marque;
    }

    public void setMarque(MarqueDto marque) {
        this.marque = marque;
    }

    public ModeleDto(int id, String libelle, MarqueDto marque) {
        this.id = id;
        this.libelle = libelle;
        this.marque = marque;
    }
    
    
            
}
