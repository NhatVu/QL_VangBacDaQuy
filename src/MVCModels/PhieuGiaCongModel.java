/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCModels;

import java.util.ArrayList;

import DTO.CTP_GiaCongDTO;
import DTO.HangGiaCongDTO;
import DTO.P_GiaCongDTO;
import DataAcessLayer.CTP_GiaCongDAO;
import DataAcessLayer.HangGiaCongDAO;
import DataAcessLayer.P_GiaCongDAO;

/**
 *
 * @author Administrator
 */
public class PhieuGiaCongModel {
    private HangGiaCongDAO mHangGiaCong;
    private P_GiaCongDAO mPhieuGiaCong;
    private CTP_GiaCongDAO mCTPGiaCong;

    public PhieuGiaCongModel() {
        mHangGiaCong = new HangGiaCongDAO();
        mPhieuGiaCong= new P_GiaCongDAO();
        mCTPGiaCong = new CTP_GiaCongDAO();
    }
    
    public ArrayList<HangGiaCongDTO> getAllHangGiaCong() {
        return mHangGiaCong.getAllHangGiaCong();
    }

    public int getNextIdOfPhieuGiaCong() {
        return mPhieuGiaCong.getNexId();
    }

    public void insertP_GiaCong(P_GiaCongDTO pGiaCong) {
        mPhieuGiaCong.insert(pGiaCong);
    }
    
    public int getNextIdOfCTPGC()
    {
        return mCTPGiaCong.getNexId();
    }

    public void insertCTP_GiaCong(CTP_GiaCongDTO ctp) {
        mCTPGiaCong.insert(ctp);
    }
    
}
