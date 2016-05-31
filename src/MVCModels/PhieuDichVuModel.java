/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCModels;

import DTO.NguoiDTO;
import DataAcessLayer.KhachHangDAO;
import DataAcessLayer.P_DichVuDAO;

/**
 *
 * @author Administrator
 */
public class PhieuDichVuModel {
    private P_DichVuDAO mPhieuDichVuDAO;
    private KhachHangDAO mKhachHangDAO;

    public PhieuDichVuModel() {
        mPhieuDichVuDAO = new P_DichVuDAO();
        mKhachHangDAO = new KhachHangDAO();
    }
    
    
    
    
    
    public String getLastId()
    {
        return mPhieuDichVuDAO.getLastID();
    }
    
    public NguoiDTO kiemtraKhachQuen(int shortId)
    {
        return mKhachHangDAO.checkKhachHangQuen(shortId);
    }
    
}
