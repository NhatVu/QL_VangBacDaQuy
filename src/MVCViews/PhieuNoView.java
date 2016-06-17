package MVCViews;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import MVCControllers.PhieuNoController;
import table.CT_TonKhoTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class PhieuNoView {

    private JFrame frmPhiuN;
    private JTextField textMaPhieuNo;
    private JTextField textMaKH;
    private JTextField textHoTen;
    private JTextField textSoTienNo;
    private JTextField textSoTienTra;
    private JTextField textConLai;
    private JTextField textMaPhieuBan;
    private JDateChooser dateNgayNo;
    private JDateChooser dateNgayTra;

    private PhieuNoController controller = null;
    /**
     * Create the application.
     */
    public PhieuNoView(PhieuNoController controller) {
        initialize();
        this.controller = controller;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmPhiuN = new JFrame();
        frmPhiuN.setTitle("Phiếu nợ");
        frmPhiuN.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowOpened(WindowEvent arg0) {
                    controller.frameWindowOpened(arg0);
        	}
        });
        frmPhiuN.setBounds(100, 100, 792, 484);
        frmPhiuN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU NỢ");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieuNo = new JTextField();
        textMaPhieuNo.setBounds(122, 68, 111, 20);
        textMaPhieuNo.setColumns(10);
        textMaPhieuNo.setEditable(false);

        JLabel lblNgayMua = new JLabel("Mã khách :");
        lblNgayMua.setBounds(45, 132, 67, 14);
        frmPhiuN.getContentPane().setLayout(null);
        frmPhiuN.getContentPane().add(lblPhiuMuaHng);
        frmPhiuN.getContentPane().add(lblSPhiu);
        frmPhiuN.getContentPane().add(textMaPhieuNo);
        frmPhiuN.getContentPane().add(lblNgayMua);

        JButton btnLuu = new JButton("Lưu"); 
        btnLuu.setBounds(88, 411, 89, 23);
        frmPhiuN.getContentPane().add(btnLuu);
        btnLuu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.btnLuuActionPerformed(e);
            }
        });

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBounds(309, 411, 89, 23);
        frmPhiuN.getContentPane().add(btnXoa);
        btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.btnXoaActionPerformed(e);
			}
		});

        JButton btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.btnThoatActionPerformed(e);
        	}
        });
        btnThoat.setBounds(531, 411, 89, 23);
        frmPhiuN.getContentPane().add(btnThoat);

        textMaKH = new JTextField();
        textMaKH.setColumns(10);
        textMaKH.setBounds(122, 129, 111, 20);
        textMaKH.setEditable(false);
        frmPhiuN.getContentPane().add(textMaKH);

        JLabel lblTnKhch = new JLabel("Tên khách :");
        lblTnKhch.setBounds(413, 132, 76, 14);
        frmPhiuN.getContentPane().add(lblTnKhch);

        textHoTen = new JTextField();
        textHoTen.setColumns(10);
        textHoTen.setBounds(499, 126, 148, 20);
        textHoTen.setEditable(false);
        frmPhiuN.getContentPane().add(textHoTen);

        JLabel lblNgyN = new JLabel("Ngày nợ :");
        lblNgyN.setBounds(45, 187, 67, 14);
        frmPhiuN.getContentPane().add(lblNgyN);

        JLabel lblSTinN = new JLabel("Số tiền nợ :");
        lblSTinN.setBounds(413, 184, 67, 14);
        frmPhiuN.getContentPane().add(lblSTinN);

        textSoTienNo = new JTextField();
        textSoTienNo.setColumns(10);
        textSoTienNo.setBounds(499, 181, 148, 20);
        textSoTienNo.setEditable(false);
        frmPhiuN.getContentPane().add(textSoTienNo);

        JLabel lblNgyTr = new JLabel("Ngày trả :");
        lblNgyTr.setBounds(45, 246, 67, 14);
        frmPhiuN.getContentPane().add(lblNgyTr);

        JLabel lblSTinN_1 = new JLabel("Số tiền trả :");
        lblSTinN_1.setBounds(413, 243, 67, 14);
        frmPhiuN.getContentPane().add(lblSTinN_1);

        textSoTienTra = new JTextField();
        textSoTienTra.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
                    controller.textSoTienTraFocusLost(e);
        	}
        });
        textSoTienTra.setColumns(10);
        textSoTienTra.setBounds(499, 243, 148, 20);
        frmPhiuN.getContentPane().add(textSoTienTra);

        JLabel lblCnLi = new JLabel("Còn lại :");
        lblCnLi.setBounds(413, 304, 67, 14);
        frmPhiuN.getContentPane().add(lblCnLi);

        textConLai = new JTextField();
        textConLai.setColumns(10);
        textConLai.setBounds(499, 301, 148, 20);
        textConLai.setEditable(false);
        frmPhiuN.getContentPane().add(textConLai);

        dateNgayNo = new JDateChooser();
        dateNgayNo.setBounds(122, 181, 116, 20);
        frmPhiuN.getContentPane().add(dateNgayNo);
        dateNgayNo.setDate(new Date());
        dateNgayNo.setEnabled(false);

        dateNgayTra = new JDateChooser();
        dateNgayTra.setBounds(122, 246, 116, 20);
        frmPhiuN.getContentPane().add(dateNgayTra);
        
        JLabel lblMPhiuBn = new JLabel("Mã phiếu bán :");
        lblMPhiuBn.setBounds(413, 68, 89, 14);
        frmPhiuN.getContentPane().add(lblMPhiuBn);
        
        textMaPhieuBan = new JTextField();
        textMaPhieuBan.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				controller.textMaPhieuBanFocusLost(e);
			}
			
			
		});
        textMaPhieuBan.setColumns(10);
        textMaPhieuBan.setBounds(499, 68, 148, 20);
        frmPhiuN.getContentPane().add(textMaPhieuBan);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public JFrame getFrame() {
        return frmPhiuN;
    }
    
    public void setFrame(JFrame frame) {
        this.frmPhiuN = frame;
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

    public JTextField getTextMaPhieuNo() {
        return textMaPhieuNo;
    }

    public void setTextMaPhieuNo(JTextField textMaPhieuNo) {
        this.textMaPhieuNo = textMaPhieuNo;
    }

    public JTextField getTextMaPhieuBan() {
        return textMaPhieuBan;
    }

    public void setTextMaPhieuBan(JTextField textMaPhieuBan) {
        this.textMaPhieuBan = textMaPhieuBan;
    }

    public JDateChooser getDateNgayNo() {
        return dateNgayNo;
    }

    public void setDateNgayNo(JDateChooser dateNgayNo) {
        this.dateNgayNo = dateNgayNo;
    }

    public JDateChooser getDateNgayTra() {
        return dateNgayTra;
    }

    public void setDateNgayTra(JDateChooser dateNgayTra) {
        this.dateNgayTra = dateNgayTra;
    }
       
    
}
