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

public class TonKhoView {

    private JFrame frame;
    private JTextField textMaPhieu;
    private JTable tableCTP_MH;

    /**
     * Create the application.
     */
    public TonKhoView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("BÁO CÁO TỒN KHO");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(154, 68, 108, 20);
        textMaPhieu.setColumns(10);

        JLabel lblNgayMua = new JLabel("Ngày báo cáo :");
        lblNgayMua.setBounds(45, 111, 94, 14);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblPhiuMuaHng);
        frame.getContentPane().add(lblSPhiu);
        frame.getContentPane().add(textMaPhieu);
        frame.getContentPane().add(lblNgayMua);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Chi tiết phiếu tồn kho", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(37, 177, 703, 181);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        tableCTP_MH = new JTable();
        tableCTP_MH.setBounds(105, 70, 1, 1);
        panel_1.add(tableCTP_MH);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setBounds(88, 411, 89, 23);
        frame.getContentPane().add(btnLuu);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBounds(309, 411, 89, 23);
        frame.getContentPane().add(btnXoa);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.setBounds(531, 411, 89, 23);
        frame.getContentPane().add(btnThoat);

        JDateChooser dateNgayBaoCao = new JDateChooser();
        dateNgayBaoCao.setBounds(154, 105, 108, 20);
        frame.getContentPane().add(dateNgayBaoCao);
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
    
    public JTable getTableCTP_MH() {
        return tableCTP_MH;
    }
    
    public void setTableCTP_MH(JTable tableCTP_MH) {
        this.tableCTP_MH = tableCTP_MH;
    }
    
//</editor-fold>
    

}
