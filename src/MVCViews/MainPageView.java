package MVCViews;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import MVCControllers.MainPageController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageView {
    
    private JFrame frmCaHngVng;
    private MainPageController controller;

    /**
     * Create the application.
     */
    public MainPageView(MainPageController controller) {
        initialize();
        this.controller = controller;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmCaHngVng = new JFrame();
        frmCaHngVng.setTitle("Cửa hàng vàng bạc đá quý");
        frmCaHngVng.setBounds(100, 100, 792, 484);
        frmCaHngVng.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel lblPhiuMuaHng = new JLabel("CỬA HÀNG VÀNG BẠC ĐÁ QUÝ");
        lblPhiuMuaHng.setBounds(279, 31, 180, 14);
        frmCaHngVng.getContentPane().setLayout(null);
        frmCaHngVng.getContentPane().add(lblPhiuMuaHng);
        
        JButton btnBanHang = new JButton("BÁN HÀNG");
        btnBanHang.setBounds(104, 109, 157, 41);
        frmCaHngVng.getContentPane().add(btnBanHang);
        btnBanHang.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnBanHangActionPerformed(e);
            }
        });
        
        JButton btnHangGiaCong = new JButton("HÀNG GIA CÔNG");
        btnHangGiaCong.setBounds(104, 189, 157, 41);
        frmCaHngVng.getContentPane().add(btnHangGiaCong);
        btnHangGiaCong.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnGiaCongActionPerfomed(e);
            }
        });
        
        JButton btnChiTien = new JButton("CHI TIỀN");
        btnChiTien.setBounds(104, 272, 157, 41);
        frmCaHngVng.getContentPane().add(btnChiTien);
        btnChiTien.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnChiActionPerfomed(e);
            }
        });
        
        JButton btnTonKho = new JButton("TỒN KHO");
        btnTonKho.setBounds(104, 352, 157, 41);
        frmCaHngVng.getContentPane().add(btnTonKho);
        btnTonKho.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnTonKhoActionPerformed(e);
            }
        });
        
        JButton btnMuaHang = new JButton("MUA HÀNG");
        btnMuaHang.setBounds(456, 109, 157, 41);
        frmCaHngVng.getContentPane().add(btnMuaHang);
        btnMuaHang.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnMuaHangActionPerformed(e);
            }
        });
        
        JButton btnDichVu = new JButton("DỊCH VỤ");
        btnDichVu.setBounds(456, 189, 157, 41);
        frmCaHngVng.getContentPane().add(btnDichVu);
        btnDichVu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnDichVuActionPerformed(e);
            }
        });
        
        JButton btnNo = new JButton("NỢ");
        btnNo.setBounds(456, 272, 157, 41);
        frmCaHngVng.getContentPane().add(btnNo);
        btnNo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnNoActionPerformed(e);                        
            }
        });
        
        JButton btnKetThuc = new JButton("KẾT THÚC");
        btnKetThuc.setBounds(456, 352, 157, 41);
        frmCaHngVng.getContentPane().add(btnKetThuc);
        btnKetThuc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnThoatActionPerformed(e);
            }
        });
    }

    /*
     * Getters and Setters
     */
    public JFrame getFrame() {
        return frmCaHngVng;
    }
    
    public void setFrame(JFrame frame) {
        this.frmCaHngVng = frame;
    }
    
}
