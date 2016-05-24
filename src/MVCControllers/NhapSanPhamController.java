package MVCControllers;

import java.awt.JobAttributes;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import MVCModels.*;
import MVCViews.*;
import DTO.*;

public class NhapSanPhamController {
    NhapSanPhamModel model = new NhapSanPhamModel();
    NhapSanPhamView view ;//= new NhapSanPhamView();
    public void startApplication(){
        view = new NhapSanPhamView(this);
        view.getFrame().setVisible(true);
    }
    
    public void btnThemActionPerformed(ActionEvent arg0){
    	
    	SanPhamDTO sanPhamDTO = new SanPhamDTO();
    	sanPhamDTO.setMaSP(view.getTxtMaSP().getText());
    	sanPhamDTO.setTenSP(view.getTextTenSP().getText());
    	sanPhamDTO.setDonGiaBan(Double.parseDouble(view.getTextDonGiaBan().getText()));
    	sanPhamDTO.setDonGiaMua(Double.parseDouble(view.getTextDonGiaMua().getText()));
    	sanPhamDTO.setSoLuongTon(Integer.parseInt(view.getTextSoLuongTon().getText()));
    	
    	model.insert(sanPhamDTO);
    	JOptionPane.showMessageDialog(null, "Thêm thành công vào database !");

    }
    
    public void btnCapNhatActionPerformed(ActionEvent arg){
    	SanPhamDTO sanPhamDTO = new SanPhamDTO();
    	sanPhamDTO.setMaSP(view.getTxtMaSP().getText());
    	sanPhamDTO.setTenSP(view.getTextTenSP().getText());
    	sanPhamDTO.setDonGiaBan(Double.parseDouble(view.getTextDonGiaBan().getText()));
    	sanPhamDTO.setDonGiaMua(Double.parseDouble(view.getTextDonGiaMua().getText()));
    	sanPhamDTO.setSoLuongTon(Integer.parseInt(view.getTextSoLuongTon().getText()));
    	
    	model.update(sanPhamDTO);
    	JOptionPane.showMessageDialog(null, "Câp nhật thành công vào database !");
    }
}
