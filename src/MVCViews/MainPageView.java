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

public class MainPageView {

    private JFrame frame;

    /**
     * Create the application.
     */
    public MainPageView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("CỬA HÀNG VÀNG BẠC ĐÁ QUÝ");
        lblPhiuMuaHng.setBounds(279, 31, 180, 14);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblPhiuMuaHng);

        JButton btnBanHang = new JButton("BÁN HÀNG");
        btnBanHang.setBounds(104, 109, 157, 41);
        frame.getContentPane().add(btnBanHang);

        JButton btnHangGiaCong = new JButton("HÀNG GIA CÔNG");
        btnHangGiaCong.setBounds(104, 189, 157, 41);
        frame.getContentPane().add(btnHangGiaCong);

        JButton btnChiTien = new JButton("CHI TIỀN");
        btnChiTien.setBounds(104, 272, 157, 41);
        frame.getContentPane().add(btnChiTien);

        JButton btnTonKho = new JButton("TỒN KHO");
        btnTonKho.setBounds(104, 352, 157, 41);
        frame.getContentPane().add(btnTonKho);

        JButton btnMuaHang = new JButton("MUA HÀNG");
        btnMuaHang.setBounds(456, 109, 157, 41);
        frame.getContentPane().add(btnMuaHang);

        JButton btnDichVu = new JButton("DỊCH VỤ");
        btnDichVu.setBounds(456, 189, 157, 41);
        frame.getContentPane().add(btnDichVu);

        JButton btnNo = new JButton("NỢ");
        btnNo.setBounds(456, 272, 157, 41);
        frame.getContentPane().add(btnNo);

        JButton btnKetThuc = new JButton("KẾT THÚC");
        btnKetThuc.setBounds(456, 352, 157, 41);
        frame.getContentPane().add(btnKetThuc);
    }

    /*
     * Getters and Setters
     */
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

}
