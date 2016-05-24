package MVCViews;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import MVCControllers.*;

public class NhapSanPhamView {

    private JFrame frame;
    private JTextField txtMaSP;
    private JTextField textTenSP;
    private JTextField textDonGiaMua;
    private JTextField textDonGiaBan;
    private JTextField textSoLuongTon;
    private JLabel lblNhpThngTin;

    private NhapSanPhamController controller ;//= new NhapSanPhamController();

    /**
     * Launch the application.
     */

    /**
     * Create the application.
     */
    public NhapSanPhamView(NhapSanPhamController controller) {
        initialize();
        this.controller = controller;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblMaSP = new JLabel("Mã sản phẩm :");
        lblMaSP.setBounds(32, 55, 96, 14);
        frame.getContentPane().add(lblMaSP);

        txtMaSP = new JTextField();
        txtMaSP.setBounds(151, 52, 117, 20);
        frame.getContentPane().add(txtMaSP);
        txtMaSP.setColumns(10);

        JLabel lblTenSP = new JLabel("Tên sản phẩm :");
        lblTenSP.setBounds(32, 98, 96, 14);
        frame.getContentPane().add(lblTenSP);

        JLabel lblDonGiaMua = new JLabel("Đơn giá mua :");
        lblDonGiaMua.setBounds(32, 149, 96, 14);
        frame.getContentPane().add(lblDonGiaMua);

        textTenSP = new JTextField();
        textTenSP.setBounds(151, 95, 117, 20);
        frame.getContentPane().add(textTenSP);
        textTenSP.setColumns(10);

        textDonGiaMua = new JTextField();
        textDonGiaMua.setBounds(151, 146, 117, 20);
        frame.getContentPane().add(textDonGiaMua);
        textDonGiaMua.setColumns(10);

        JLabel lblDonGiaBan = new JLabel("Đơn giá bán :");
        lblDonGiaBan.setBounds(32, 197, 96, 14);
        frame.getContentPane().add(lblDonGiaBan);

        JLabel lblSoLuongTon = new JLabel("Số lượng tồn :");
        lblSoLuongTon.setBounds(33, 236, 95, 14);
        frame.getContentPane().add(lblSoLuongTon);

        textDonGiaBan = new JTextField();
        textDonGiaBan.setBounds(151, 194, 117, 20);
        frame.getContentPane().add(textDonGiaBan);
        textDonGiaBan.setColumns(10);

        textSoLuongTon = new JTextField();
        textSoLuongTon.setBounds(151, 233, 117, 20);
        frame.getContentPane().add(textSoLuongTon);
        textSoLuongTon.setColumns(10);

        lblNhpThngTin = new JLabel("Nhập thông tin sản phẩm");
        lblNhpThngTin.setBounds(151, 11, 142, 14);
        frame.getContentPane().add(lblNhpThngTin);

        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	controller.btnThemActionPerformed(arg0);
            }
        });
        btnThem.setBounds(316, 51, 89, 23);
        frame.getContentPane().add(btnThem);

        JButton btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnCapNhatActionPerformed(arg0);
        	}
        });
        btnCapNhat.setBounds(316, 145, 89, 23);
        frame.getContentPane().add(btnCapNhat);
    }

    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters ">
    public JFrame getFrame() {
        return frame;
    }
    
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public JTextField getTxtMaSP() {
        return txtMaSP;
    }
    
    public void setTxtMaSP(JTextField txtMaSP) {
        this.txtMaSP = txtMaSP;
    }
    
    public JTextField getTextTenSP() {
        return textTenSP;
    }
    
    public void setTextTenSP(JTextField textTenSP) {
        this.textTenSP = textTenSP;
    }
    
    public JTextField getTextDonGiaMua() {
        return textDonGiaMua;
    }
    
    public void setTextDonGiaMua(JTextField textDonGiaMua) {
        this.textDonGiaMua = textDonGiaMua;
    }
    
    public JTextField getTextDonGiaBan() {
        return textDonGiaBan;
    }
    
    public void setTextDonGiaBan(JTextField textDonGiaBan) {
        this.textDonGiaBan = textDonGiaBan;
    }
    
    public JTextField getTextSoLuongTon() {
        return textSoLuongTon;
    }
    
    public void setTextSoLuongTon(JTextField textSoLuongTon) {
        this.textSoLuongTon = textSoLuongTon;
    }
    
    
//</editor-fold>
    
}
