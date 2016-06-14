/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCModels;

import DTO.CTP_DichVuDTO;
import DTO.DichVuDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_DichVuDTO;
import DTO.P_ThuDTO;
import DataAcessLayer.CTP_DichVuDAO;
import DataAcessLayer.DichVuDAO;
import DataAcessLayer.KhachHangDAO;
import DataAcessLayer.NguoiDAO;
import DataAcessLayer.P_DichVuDAO;
import DataAcessLayer.P_ThuDAO;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PhieuDichVuModel {
    private P_DichVuDAO mPhieuDichVuDAO;
    private KhachHangDAO mKhachHangDAO;
    private DichVuDAO mDichVu;
    private CTP_DichVuDAO mCTPDV;
    private NguoiDAO mNguoiDAO;
    private P_ThuDAO mPhieuThuDAO;
    

    public PhieuDichVuModel() {
        mPhieuDichVuDAO = new P_DichVuDAO();
        mKhachHangDAO = new KhachHangDAO();
        mDichVu = new DichVuDAO();
        mCTPDV = new CTP_DichVuDAO();
        mNguoiDAO = new NguoiDAO();
        mPhieuThuDAO = new P_ThuDAO();
    }
    
    public String getNextIdOfPhieuDichVu()
    {
        return mPhieuDichVuDAO.getNexId();
    }
    
    public String getNextIdOfKhachHang()
    {
        return mKhachHangDAO.getNexId();
    }
    
    public String getNextIdOfNguoi()
    {
        return mNguoiDAO.getNexId();
    }
    
    public String getNextIdOfPhieuThu()
    {
        return mPhieuThuDAO.getNexId();
    }
    
    public String getNextIdOfCTPDV()
    {
        return mCTPDV.getNexId();
    }
    
    public NguoiDTO kiemtraKhachQuen(int shortId)
    {
        return mKhachHangDAO.checkKhachHangQuen(shortId);
    }
    
    public ArrayList<DichVuDTO> getAllDichVu()
    {
        return mDichVu.getAllDichVu();
    }
    
    public void insertCTPDichVu(CTP_DichVuDTO ctp_DV)
    {
        mCTPDV.insert(ctp_DV);
    }
    
    public void insertP_DichVu(P_DichVuDTO p_DV)
    {
        mPhieuDichVuDAO.insert(p_DV);
    }
    
    public void insertKhachHang(KhachHangDTO kh,NguoiDTO nguoi)
    {
    	mNguoiDAO.insert(nguoi);
        mKhachHangDAO.insert(kh);
    }
    
    public void insertP_Thu(P_ThuDTO pThu)
    {
        mPhieuThuDAO.insert(pThu);
    }
    
    public String getMaKhByName(int id)
    {
        return mKhachHangDAO.getMaKhachHangByName(id);
    }
    

}
