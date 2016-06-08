/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCControllers;

import DTO.CT_TonKhoDTO;
import DTO.TonKhoDTO;
import MVCModels.TonKhoModel;
import MVCViews.TonKhoView;
import table.CT_TonKhoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import main.Resource;

/**
 *
 * @author Minh Nhat
 */
public class TonKhoController {
    TonKhoModel model = new TonKhoModel();
    TonKhoView view = null;
    
    /*
    Khi vừa  load form, thì tất cả các thông tin đều đã được hiện thị lên.
    Gồm : Mã phiếu tồn kho, ngày báo cáo. 
    */
    public void startApplication(){
        view = new TonKhoView(this);
        view.getFrame().setVisible(true);
    }
    
    /*
    1. Intent
        - Lưu bảng tồn kho 
        - lưu chi tiết tồn kho
    */
    public void btnLuuActionPerformed(ActionEvent e){
        TonKhoDTO tkDTO = new TonKhoDTO();
        tkDTO.setMaP_TK(view.getTextMaPhieu().getText());
        tkDTO.setNgayBaoCao(new Timestamp(view.getDateNgayBaoCao().getDate().getTime()));
        
        model.insertTonKho(tkDTO);
        List<CT_TonKhoDTO> lCT_TK = view.getTableModel().getCT_TonKhoDTOList();
        for(int i = 0; i<lCT_TK.size(); i++){
            String lastID = model.getLastIDOfCT_TK();
            lastID = Resource.CT_TONKHO + (Integer.parseInt(lastID.substring(Resource.CT_TONKHO.length())) + 1);
            lCT_TK.get(i).setMaCTP_TK(lastID);
            lCT_TK.get(i).setMaP_TK(tkDTO.getMaP_TK());
            model.insertCT_TonKho(lCT_TK.get(i));
        }
        
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        view.getBtnLuu().setEnabled(false);
    }
    
    public void btnThoatActionEvent(ActionEvent e){
        view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING));
    }
    
    public void frameWindowOpened(WindowEvent e){
        view.getDateNgayBaoCao().setDate(new Date());
        model.init(new Timestamp(view.getDateNgayBaoCao().getDate().getTime()));
        
        String mMaP_TK = model.getLastID();
        mMaP_TK = Resource.TONKHO + (Integer.parseInt(mMaP_TK.substring(Resource.TONKHO.length())) + 1);
        view.getTextMaPhieu().setText(mMaP_TK);
        
        fillDataToTableModel();
        
    }
    
    /*
    1. điền dữ liệu vào lsCTP_TK
    2. load dữ liệu này lên bảng
    */
    private void fillDataToTableModel(){
        String maSP;
        int tonDauKy, soLuongBan, soLuongMua;
        CT_TonKhoDTO tct_tk = null;
        for(int i = 0; i < model.getListMaSP().size(); i++){
            maSP = model.getListMaSP().get(i);
            tonDauKy = model.getMaSPTonDauKy().get(maSP);
            soLuongBan = model.getMaSPTongBan().get(maSP);
            soLuongMua = model.getMaSPTongMua().get(maSP);
        
            tct_tk = new CT_TonKhoDTO();
            tct_tk.setMaHang(maSP);
            tct_tk.setTonDauKy(tonDauKy);
            tct_tk.setSoLuongBan(soLuongBan);
            tct_tk.setSoLuongMua(soLuongMua);
            tct_tk.setTonCuoiKy(tonDauKy + soLuongMua - soLuongBan);
            
            view.getTableModel().addRow(tct_tk);            
        }
    }
    
}
