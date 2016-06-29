/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCModels;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DTO.*;
import DataAcessLayer.*;

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
    List<Integer> lMaSP = null;
    Map<Integer, Integer> MaSPTongBan = new HashMap<Integer, Integer>();
    Map<Integer, Integer> MaSPTongMua = new HashMap<Integer, Integer>();
    Map<Integer, Integer> MaSPTonDauKy = new HashMap<Integer, Integer>();

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

  
    public int getNextIDOfCT_TK(){
        return ct_tkDAO.getNexId();
    }
    private void getLastRow() {
        tkDAO.getLastRow(tkDTO);
    }
    
    public int getNextID(){
        return tkDTO.getMaP_TK() + 1;
    }

    // trả về danh sách các sản phẩm cần lập báo cáo
    public List<Integer> getListMaSP() {
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

    public Map<Integer, Integer> getMaSPTongBan() {
        return MaSPTongBan;
    }

    public Map<Integer, Integer> getMaSPTongMua() {
        return MaSPTongMua;
    }

    public Map<Integer, Integer> getMaSPTonDauKy() {
        return MaSPTonDauKy;
    }

}
