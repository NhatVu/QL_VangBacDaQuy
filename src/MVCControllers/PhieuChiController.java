/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCControllers;

import DTO.P_ChiDTO;
import MVCModels.PhieuChiModel;
import MVCViews.PhieuChiView;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import main.CheckInput;
import main.Resource;

/**
 *
 * @author Minh Nhat
 */
public class PhieuChiController {

    PhieuChiModel model = new PhieuChiModel();
    PhieuChiView view = null;

    public void startApplication() {
        view = new PhieuChiView(this);
        view.getFrame().setVisible(true);
    }

    public void btnLuuActionPerformed(ActionEvent e) {
        P_ChiDTO p_ChiDTO = new P_ChiDTO();
        p_ChiDTO.setMaP_Chi(view.getTextMaPhieu().getText());
        p_ChiDTO.setNgayChi(new Timestamp(view.getDateNgayChi().getDate().getTime()));

//        if (!CheckInput.isCharacter(view.getTextNoiDung().getText())) {
//            JOptionPane.showMessageDialog(null, "Vui lòng không nhập ký tự đặc biệt");
//            return;
//
//        }
        p_ChiDTO.setNoiDung(view.getTextNoiDung().getText());

        if (!CheckInput.isDouble(view.getTextSoTienChi().getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin");
            return;
        }
        p_ChiDTO.setSoTienChi(Double.parseDouble(view.getTextSoTienChi().getText()));

        model.insert(p_ChiDTO);
        JOptionPane.showMessageDialog(null, "Lưu thành công");
        // xóa nọi dung, tạo lại phiếu mới
        view.getTextNoiDung().setText(null);
        view.getTextSoTienChi().setText(null);

        view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_OPENED));

    }

    public void btnThoatActionEvent(ActionEvent e) {
        view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING));
    }

    public void frameWindowOpened(WindowEvent e) {
        String lastID = model.getLastID();
        lastID = Resource.P_CHI + (Integer.parseInt(lastID.substring(Resource.P_CHI.length())) + 1);
        view.getTextMaPhieu().setText(lastID);
        view.getDateNgayChi().setDate(new Date());
    }
}
