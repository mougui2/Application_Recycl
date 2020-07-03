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
public class TourneeDto {
    int id;
    Date date;
    EmployeDto employe;
    CamionDto camion;

    public CamionDto getCamion() {
        return camion;
    }

    public void setCamion(CamionDto camion) {
        this.camion = camion;
    }

    public List<DetailsTourneeDto> getDetailsTourneeList() {
        return detailsTourneeList;
    }

    public void setDetailsTourneeList(List<DetailsTourneeDto> detailsTourneeList) {
        this.detailsTourneeList = detailsTourneeList;
    }
    List<DetailsTourneeDto> detailsTourneeList;

    public TourneeDto(int id, Date date, EmployeDto employe, CamionDto camion) {
        this.id = id;
        this.date = date;
        this.employe = employe;
        this.camion = camion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EmployeDto getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDto employe) {
        this.employe = employe;
    }
}
