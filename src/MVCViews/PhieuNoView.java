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

public class PhieuNoView {

    private JFrame frame;
    private JTextField textMaPhieu;
    private JTextField textMaKH;
    private JTextField textHoTen;
    private JTextField textSoTienNo;
    private JTextField textSoTienTra;
    private JTextField textConLai;

    /**
     * Create the application.
     */
    public PhieuNoView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU NỢ");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(122, 68, 111, 20);
        textMaPhieu.setColumns(10);

        JLabel lblNgayMua = new JLabel("Mã khách :");
        lblNgayMua.setBounds(45, 132, 67, 14);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblPhiuMuaHng);
        frame.getContentPane().add(lblSPhiu);
        frame.getContentPane().add(textMaPhieu);
        frame.getContentPane().add(lblNgayMua);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setBounds(88, 411, 89, 23);
        frame.getContentPane().add(btnLuu);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBounds(309, 411, 89, 23);
        frame.getContentPane().add(btnXoa);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBounds(531, 411, 89, 23);
        frame.getContentPane().add(btnThoat);

        textMaKH = new JTextField();
        textMaKH.setColumns(10);
        textMaKH.setBounds(122, 129, 111, 20);
        frame.getContentPane().add(textMaKH);

        JLabel lblTnKhch = new JLabel("Tên khách :");
        lblTnKhch.setBounds(413, 132, 76, 14);
        frame.getContentPane().add(lblTnKhch);

        textHoTen = new JTextField();
        textHoTen.setColumns(10);
        textHoTen.setBounds(499, 126, 148, 20);
        frame.getContentPane().add(textHoTen);

        JLabel lblNgyN = new JLabel("Ngày nợ :");
        lblNgyN.setBounds(45, 187, 67, 14);
        frame.getContentPane().add(lblNgyN);

        JLabel lblSTinN = new JLabel("Số tiền nợ :");
        lblSTinN.setBounds(413, 184, 67, 14);
        frame.getContentPane().add(lblSTinN);

        textSoTienNo = new JTextField();
        textSoTienNo.setColumns(10);
        textSoTienNo.setBounds(499, 181, 148, 20);
        frame.getContentPane().add(textSoTienNo);

        JLabel lblNgyTr = new JLabel("Ngày trả :");
        lblNgyTr.setBounds(45, 246, 67, 14);
        frame.getContentPane().add(lblNgyTr);

        JLabel lblSTinN_1 = new JLabel("Số tiền trả :");
        lblSTinN_1.setBounds(413, 243, 67, 14);
        frame.getContentPane().add(lblSTinN_1);

        textSoTienTra = new JTextField();
        textSoTienTra.setColumns(10);
        textSoTienTra.setBounds(499, 243, 148, 20);
        frame.getContentPane().add(textSoTienTra);

        JLabel lblCnLi = new JLabel("Còn lại :");
        lblCnLi.setBounds(413, 304, 67, 14);
        frame.getContentPane().add(lblCnLi);

        textConLai = new JTextField();
        textConLai.setColumns(10);
        textConLai.setBounds(499, 301, 148, 20);
        frame.getContentPane().add(textConLai);

        JDateChooser dateNgayNo = new JDateChooser();
        dateNgayNo.setBounds(117, 187, 116, 20);
        frame.getContentPane().add(dateNgayNo);

        JDateChooser dateNgayTra = new JDateChooser();
        dateNgayTra.setBounds(117, 246, 116, 20);
        frame.getContentPane().add(dateNgayTra);
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
    
    public JTextField getTextSoTienNo() {
        return textSoTienNo;
    }
    
    public void setTextSoTienNo(JTextField textSoTienNo) {
        this.textSoTienNo = textSoTienNo;
    }
    
    public JTextField getTextSoTienTra() {
        return textSoTienTra;
    }
    
    public void setTextSoTienTra(JTextField textSoTienTra) {
        this.textSoTienTra = textSoTienTra;
    }
    
    public JTextField getTextConLai() {
        return textConLai;
    }
    
    public void setTextConLai(JTextField textConLai) {
        this.textConLai = textConLai;
    }
    
//</editor-fold>
    

}
