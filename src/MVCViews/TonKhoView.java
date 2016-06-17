package MVCViews;

//import MVCControllers.TonKhoController;
import MVCControllers.TonKhoController;
import table.CT_TonKhoTableModel;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TonKhoView {

    private JFrame frmTnKho;
    private JTextField textMaPhieu;
    private JTable tableTK;
    private JDateChooser dateNgayBaoCao;
    private CT_TonKhoTableModel tableModel;


    private TonKhoController controller = null;
    private JButton btnLuu;

    /**
     * Create the application.
     */
    public TonKhoView(TonKhoController controller) {
        initialize();
        this.controller = controller;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmTnKho = new JFrame();
        frmTnKho.setTitle("Tồn kho");
        frmTnKho.setBounds(100, 100, 792, 484);
        frmTnKho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTnKho.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                controller.frameWindowOpened(e);
            }

        });
        JLabel lblPhiuMuaHng = new JLabel("BÁO CÁO TỒN KHO");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(154, 68, 108, 20);
        textMaPhieu.setColumns(10);
        textMaPhieu.setEditable(false);

        JLabel lblNgayMua = new JLabel("Ngày báo cáo :");
        lblNgayMua.setBounds(45, 111, 94, 14);
        frmTnKho.getContentPane().setLayout(null);
        frmTnKho.getContentPane().add(lblPhiuMuaHng);
        frmTnKho.getContentPane().add(lblSPhiu);
        frmTnKho.getContentPane().add(textMaPhieu);
        frmTnKho.getContentPane().add(lblNgayMua);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Chi tiết phiếu tồn kho", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(37, 177, 703, 181);
        frmTnKho.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 16, 680, 154);
        panel_1.add(scrollPane);

        tableModel = new CT_TonKhoTableModel();
        tableTK = new JTable(tableModel);
        scrollPane.setViewportView(tableTK);
        

        btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnLuuActionPerformed(arg0);
            }
        });
        btnLuu.setBounds(88, 411, 89, 23);
        frmTnKho.getContentPane().add(btnLuu);

        JButton btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.btnThoatActionEvent(e);
            }
        });
        btnThoat.setBounds(531, 411, 89, 23);
        frmTnKho.getContentPane().add(btnThoat);

        dateNgayBaoCao = new JDateChooser();
        dateNgayBaoCao.setBounds(154, 105, 108, 20);
        frmTnKho.getContentPane().add(dateNgayBaoCao);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public JFrame getFrame() {
        return frmTnKho;
    }

    public void setFrame(JFrame frame) {
        this.frmTnKho = frame;
    }

    public JTextField getTextMaPhieu() {
        return textMaPhieu;
    }

    public void setTextMaPhieu(JTextField textMaPhieu) {
        this.textMaPhieu = textMaPhieu;
    }

    

    public JDateChooser getDateNgayBaoCao() {
        return dateNgayBaoCao;
    }

    public void setDateNgayBaoCao(JDateChooser dateNgayBaoCao) {
        this.dateNgayBaoCao = dateNgayBaoCao;
    }

    public CT_TonKhoTableModel getTableModel() {
        return tableModel;
    }

    public JButton getBtnLuu() {
        return btnLuu;
    }
    
    
    
}
