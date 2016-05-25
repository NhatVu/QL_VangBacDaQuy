package MVCViews;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class PhieuDichVuView {

    private JFrame frame;
    private JTextField textMaPhieu;
    private JTextField textMaKH;
    private JTextField textHoTen;
    private JTextField textDiaChi;
    private JTextField textTongCong;
    private JTable tableCTP_MH;

    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    public PhieuDichVuView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU DỊCH VỤ");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(139, 68, 86, 20);
        textMaPhieu.setColumns(10);

        JLabel lblNgayMua = new JLabel("Ngày đăng ký :");
        lblNgayMua.setBounds(45, 111, 80, 14);

        JLabel lblNgyThanhTon = new JLabel("Ngày giao :");
        lblNgyThanhTon.setBounds(360, 111, 99, 14);

        JLabel labelMaKH = new JLabel("Mã Khách :");
        labelMaKH.setBounds(45, 158, 67, 14);

        textMaKH = new JTextField();
        textMaKH.setBounds(139, 155, 86, 20);
        textMaKH.setColumns(10);

        JLabel lblHTn = new JLabel("Họ tên :");
        lblHTn.setBounds(372, 158, 67, 14);

        textHoTen = new JTextField();
        textHoTen.setBounds(449, 155, 137, 20);
        textHoTen.setColumns(10);

        JLabel lblaCh = new JLabel("Địa chỉ :");
        lblaCh.setBounds(40, 208, 74, 14);

        textDiaChi = new JTextField();
        textDiaChi.setBounds(136, 205, 450, 20);
        textDiaChi.setColumns(10);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblPhiuMuaHng);
        frame.getContentPane().add(lblSPhiu);
        frame.getContentPane().add(textMaPhieu);
        frame.getContentPane().add(lblNgayMua);
        frame.getContentPane().add(lblNgyThanhTon);
        frame.getContentPane().add(labelMaKH);
        frame.getContentPane().add(textMaKH);
        frame.getContentPane().add(lblHTn);
        frame.getContentPane().add(textHoTen);
        frame.getContentPane().add(lblaCh);
        frame.getContentPane().add(textDiaChi);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Chi tiết phiếu dịch vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(39, 231, 703, 137);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        tableCTP_MH = new JTable();
        tableCTP_MH.setBounds(105, 70, 1, 1);
        panel_1.add(tableCTP_MH);

        JLabel lblTngCng = new JLabel("Tổng cộng :");
        lblTngCng.setBounds(475, 386, 67, 14);
        frame.getContentPane().add(lblTngCng);

        textTongCong = new JTextField();
        textTongCong.setBounds(562, 383, 148, 20);
        frame.getContentPane().add(textTongCong);
        textTongCong.setColumns(10);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setBounds(88, 411, 89, 23);
        frame.getContentPane().add(btnLuu);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBounds(309, 411, 89, 23);
        frame.getContentPane().add(btnXoa);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBounds(531, 411, 89, 23);
        frame.getContentPane().add(btnThoat);

        JDateChooser dateNgayDK = new JDateChooser();
        dateNgayDK.setBounds(139, 105, 91, 20);
        frame.getContentPane().add(dateNgayDK);

        JDateChooser dateNgayGiao = new JDateChooser();
        dateNgayGiao.setBounds(450, 105, 136, 20);
        frame.getContentPane().add(dateNgayGiao);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public JFrame getFrame() {
        return frame;
    }
    
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public JTextField getTextMaPhieu() {
        return textMaPhieu;
    }
    
    public void setTextMaPhieu(JTextField textMaPhieu) {
        this.textMaPhieu = textMaPhieu;
    }
    
    public JTextField getTextMaKH() {
        return textMaKH;
    }
    
    public void setTextMaKH(JTextField textMaKH) {
        this.textMaKH = textMaKH;
    }
    
    public JTextField getTextHoTen() {
        return textHoTen;
    }
    
    public void setTextHoTen(JTextField textHoTen) {
        this.textHoTen = textHoTen;
    }
    
    public JTextField getTextDiaChi() {
        return textDiaChi;
    }
    
    public void setTextDiaChi(JTextField textDiaChi) {
        this.textDiaChi = textDiaChi;
    }
    
    public JTextField getTextTongCong() {
        return textTongCong;
    }
    
    public void setTextTongCong(JTextField textTongCong) {
        this.textTongCong = textTongCong;
    }
    
    public JTable getTableCTP_MH() {
        return tableCTP_MH;
    }
    
    public void setTableCTP_MH(JTable tableCTP_MH) {
        this.tableCTP_MH = tableCTP_MH;
    }
//</editor-fold>
    
    
}
