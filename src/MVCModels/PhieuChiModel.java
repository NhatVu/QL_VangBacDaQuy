/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCModels;

import DTO.P_ChiDTO;
import DataAcessLayer.P_ChiDAO;

/**
 *
 * @author Minh Nhat
 */
public class PhieuChiModel {

    P_ChiDAO p_ChiDAO = new P_ChiDAO();

    public void insert(P_ChiDTO p_ChiDTO) {
        p_ChiDAO.insert(p_ChiDTO);
    }

    public String getLastID() {
        return p_ChiDAO.getLastID();
    }

}
