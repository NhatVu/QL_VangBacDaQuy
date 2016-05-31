package MVCViews;

import MVCControllers.PhieuChiController;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhieuChiView {

    private JFrame frame;
    private JTextField textMaPhieu;
    private JTextField textSoTienChi;
    private JTextArea textNoiDung;
    private JDateChooser dateNgayChi;

    private PhieuChiController controller;
    /**
     * Create the application.
     */
    public PhieuChiView(PhieuChiController controller) {
        initialize();
        this.controller = controller;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU CHI");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setEditable(false);
        textMaPhieu.setBounds(122, 68, 128, 20);
        textMaPhieu.setColumns(10);

        JLabel lblNgayMua = new JLabel("Ngày chi :");
        lblNgayMua.setBounds(45, 111, 67, 14);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblPhiuMuaHng);
        frame.getContentPane().add(lblSPhiu);
        frame.getContentPane().add(textMaPhieu);
        frame.getContentPane().add(lblNgayMua);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                controller.frameWindowOpened(e);
            }
            
});

        JButton btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                    controller.btnLuuActionPerformed(arg0);
        	}
        });
        btnLuu.setBounds(88, 367, 89, 23);
        frame.getContentPane().add(btnLuu);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                    controller.btnThoatActionEvent(e);
        	}
        });
        btnThoat.setBounds(531, 367, 89, 23);
        frame.getContentPane().add(btnThoat);

        dateNgayChi = new JDateChooser();
        dateNgayChi.setBounds(123, 105, 127, 20);
        frame.getContentPane().add(dateNgayChi);
        
        textNoiDung = new JTextArea();
        textNoiDung.setBounds(122, 151, 420, 82);
        frame.getContentPane().add(textNoiDung);
        
        JLabel lblNiDung = new JLabel("Nội dung :");
        lblNiDung.setBounds(45, 156, 67, 14);
        frame.getContentPane().add(lblNiDung);
        
        JLabel lblSTinChi = new JLabel("Số tiền chi :");
        lblSTinChi.setBounds(45, 275, 67, 14);
        frame.getContentPane().add(lblSTinChi);
        
        textSoTienChi = new JTextField();
        textSoTienChi.setColumns(10);
        textSoTienChi.setBounds(122, 272, 148, 20);
        frame.getContentPane().add(textSoTienChi);
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

    public JTextField getTextSoTienChi() {
        return textSoTienChi;
    }

    public JTextArea getTextNoiDung() {
        return textNoiDung;
    }

    public JDateChooser getDateNgayChi() {
        return dateNgayChi;
    }
    
    
    
    
}
