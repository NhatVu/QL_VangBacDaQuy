package MVCControllers;

import DTO.P_NoDTO;
import MVCViews.*;
import MVCModels.*;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import main.CheckInput;
import main.Resource;

public class PhieuNoController implements Controller {

    private PhieuNoModel model = new PhieuNoModel();
    private PhieuNoView view = null;
    private Controller parent;

    public void start() {
        view = new PhieuNoView(this);
        view.getFrame().setVisible(true);
        setParentVisiableFalse();
    }

    /*
     1. Intent
     - Xử lý sự kiện khi nút Lưu được bấm
     - Kiểm tra thông tin trên form đã điền đầy đủ chưa ? Chỉ kiểm tra đầy đủ, k kiểm tra tính đúng đắn
     - Insert phiếu nợ vào database. 
     - Tự động xóa các thông tin trên form, và lấy mã phiếu mới.
     */
    public void btnLuuActionPerformed(ActionEvent arg) {
        if (view.getDateNgayNo().getDate() == null || view.getDateNgayTra().getDate() == null
                || view.getTextConLai().getText() == "" || view.getTextHoTen().getText() == null
                || view.getTextMaKH().getText() == null || view.getTextMaPhieuNo().getText() == null
                || view.getTextMaPhieuBan().getText() == null || view.getTextMaPhieuNo().getText() == null
                || view.getTextSoTienNo().getText() == null || view.getTextSoTienTra().getText() == null
                || view.getDateNgayNo().getDate().getTime() > view.getDateNgayTra().getDate().getTime()) // nếu 1 trường không được điền, hoặc điền rỗng => thống báo phải điền đủ
        {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra thông tin");
        } else if (!CheckInput.isDouble(view.getTextSoTienNo().getText())
                || !CheckInput.isDouble(view.getTextSoTienTra().getText())
                || !CheckInput.isDouble(view.getTextConLai().getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số");
        } else if(CheckInput.isStringMax50(view.getTextMaKH().getText()) ||
                CheckInput.isStringMax50(view.getTextSoTienNo().getText())
                || CheckInput.isStringMax50(view.getTextSoTienTra().getText())
                || CheckInput.isStringMax50(view.getTextConLai().getText())){
            JOptionPane.showMessageDialog(null, "Kiểm tra lại độ dài của thông tin. Max 50 ký tự.");
        }else {
            P_NoDTO noDTO = new P_NoDTO();
            noDTO.setMaP_No(Integer.parseInt(view.getTextMaPhieuNo().getText()));
            noDTO.setMaP_Thu(model.getMaP_Thu());
            noDTO.setNgayNo(model.getLastNgayTra());
            noDTO.setNgayTra(new Timestamp(view.getDateNgayTra().getDate().getTime()));
            noDTO.setSoTienNo(model.getLastConLai());
            noDTO.setSoTienTra(Double.parseDouble(view.getTextSoTienTra().getText()));

            model.insert(noDTO);
            JOptionPane.showMessageDialog(null, "Lưu thành công");
            btnXoaActionPerformed(arg);
            view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_OPENED));
        }

    }

    /*
     1. Intent
     - Xóa các thông tin trên form, trừ Mã phiếu nợ. 
     */
    public void btnXoaActionPerformed(ActionEvent arg) {
        view.getTextConLai().setText(null);
        view.getTextHoTen().setText(null);
        view.getTextMaKH().setText(null);
        view.getTextMaPhieuBan().setText(null);
        view.getTextSoTienNo().setText(null);
        view.getTextSoTienTra().setText(null);
        view.getDateNgayNo().setDate(null);
        view.getDateNgayTra().setDate(null);
    }

    /*
     1. Intent
     - Thoát khỏi form Phiếu nợ.
     */
    public void btnThoatActionPerformed(ActionEvent arg) {
        JFrame mFrame = view.getFrame();
        //mFrame.dispatchEvent(new WindowEvent(mFrame, WindowEvent.WINDOW_CLOSING));
        mFrame.setVisible(false);
        setParentVisiableTrue();
    }

    /*
     1. Intent
     - Xử lý sự kiện khi textField Mã phiếu bán mất focus
     1.1. Xóa tất cả thông tin, trừ phiếu bán và mã phiếu nợ. 
     1.2. Lấy thông tin cần thiết và load lên form. 
     */
    public void textMaPhieuBanFocusLost(FocusEvent e) {
        //btnXoaActionPerformed(null);
        view.getTextConLai().setText(null);
        view.getTextHoTen().setText(null);
        view.getTextMaKH().setText(null);
        view.getTextSoTienNo().setText(null);
        view.getTextSoTienTra().setText(null);
        view.getDateNgayNo().setDate(null);
        view.getDateNgayTra().setDate(null);

        JTextField mMaP_BH = view.getTextMaPhieuBan();
        // lấy thông tin liên quan đến mã phiếu bán hàng: phiếu thu, ngày trả, còn lại, mã khách hàng, họ tên
        model.getInformationByMaP_BH(Integer.parseInt(mMaP_BH.getText()));
        if (model.getLastConLai() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin khách hàng!");
            btnXoaActionPerformed(null);
        } else {
            view.getTextMaKH().setText(String.valueOf(model.getMaKH()));
            view.getTextHoTen().setText(model.getHoTen());
            view.getDateNgayNo().setDate(new Date(model.getLastNgayTra().getTime()));
            view.getTextSoTienNo().setText(model.getLastConLai().toString());
        }
    }

    /*
     1. Intent
     - Tính số còn lại, khi đã có số tiền trả và số tiên nợ.
     */
    public void textSoTienTraFocusLost(FocusEvent e) {
        if (!CheckInput.isDouble(view.getTextSoTienNo().getText())
                || !CheckInput.isDouble(view.getTextSoTienTra().getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số");
            return;
        }
        double mTienNo = Double.parseDouble(view.getTextSoTienNo().getText());
        double mTienTra = Double.parseDouble(view.getTextSoTienTra().getText());
        double conlai = mTienNo - mTienTra;
        view.getTextConLai().setText(String.valueOf(conlai));
    }

    /*
     1. Intent
     - khi form load lên, load mã phiếu nợ sẽ thêm tiếp theo.
     */
    public void frameWindowOpened(WindowEvent arg) {
        view.getTextMaPhieuNo().setText(String.valueOf(model.getNextID()));
    }

    @Override
    public void setParent(Controller parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    @Override
    public void setParentVisiableFalse() {
        this.parent.setParentVisiableFalse();
    }

    @Override
    public void setParentVisiableTrue() {
        this.parent.setParentVisiableTrue();
    }

    @Override
    public void addChild(Controller child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dipose() {
        view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING));
    }
}
