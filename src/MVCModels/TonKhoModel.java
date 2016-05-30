/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCModels;

import DataAcessLayer.*;
import DTO.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Minh Nhat
 */
public class TonKhoModel { 

    SanPhamDAO spDAO = new SanPhamDAO();
    TonKhoDAO tkDAO = new TonKhoDAO();
    CT_TonKhoDAO ct_tkDAO = new CT_TonKhoDAO();
    P_BanHangDAO bhDAO = new P_BanHangDAO();
    P_MuaHangDAO mhDAO = new P_MuaHangDAO();

    TonKhoDTO tkDTO = new TonKhoDTO();
    List<String> lMaSP = null;
    Map<String, Integer> MaSPTongBan = new HashMap<String, Integer>();
    Map<String, Integer> MaSPTongMua = new HashMap<String, Integer>();
    Map<String, Integer> MaSPTonDauKy = new HashMap<String, Integer>();

    public void init(Timestamp newNgayBC) {
        lMaSP = spDAO.getMaSP();
        // cài đặt giá trị ban đầu cho các map
        MaSPTonDauKy.clear();
        MaSPTongBan.clear();
        MaSPTongMua.clear();
        for (int i = 0; i < lMaSP.size(); i++) {
            MaSPTonDauKy.put(lMaSP.get(i), 0);
            MaSPTongBan.put(lMaSP.get(i), 0);
            MaSPTongMua.put(lMaSP.get(i), 0);

        }
        getLastRow();
        getTonDauKy();
        getMaSPTongBan(newNgayBC);
        getMaSPTongMua(newNgayBC);
    }

    public void insertTonKho(TonKhoDTO tk) {
        tkDAO.insert(tk);
    }

    public void insertCT_TonKho(CT_TonKhoDTO ct_tk) {
        
        ct_tkDAO.insert(ct_tk);
    }

    public String getLastIDOfCT_TK(){
        return ct_tkDAO.getLastID();
    }
    private void getLastRow() {
        tkDAO.getLastRow(tkDTO);
        if (tkDTO.getMaP_TK() == null) {
            tkDTO.setMaP_TK("0");
        }
        if (tkDTO.getNgayBaoCao() == null) {
            tkDTO.setNgayBaoCao(new Timestamp(1432876790));
        }
    }

    public String getLastID() {
        return tkDTO.getMaP_TK();
    }

    // trả về danh sách các sản phẩm cần lập báo cáo
    public List<String> getListMaSP() {
        return lMaSP;
    }

    private void getTonDauKy() {
        tkDAO.getMaSPTonCuoiKyByMaTK(tkDTO.getMaP_TK(), MaSPTonDauKy);
    }

    private void getMaSPTongBan(Timestamp newNgayBC) {
        bhDAO.getMaSPTongBan(tkDTO.getNgayBaoCao(), newNgayBC, MaSPTongBan);
    }

    private void getMaSPTongMua(Timestamp newNgayBC) {
        mhDAO.getMaSPTongMua(tkDTO.getNgayBaoCao(), newNgayBC, MaSPTongMua);
    }

    public Map<String, Integer> getMaSPTongBan() {
        return MaSPTongBan;
    }

    public Map<String, Integer> getMaSPTongMua() {
        return MaSPTongMua;
    }

    public Map<String, Integer> getMaSPTonDauKy() {
        return MaSPTonDauKy;
    }

}
