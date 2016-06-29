package MVCViews;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import table.TableModel;
import table.TableScroller;
import MVCControllers.PhieuBanHangController;

import com.toedter.calendar.JDateChooser;

public class PhieuBanHangView {

    ArrayList<JTextField> mAllTextField = new ArrayList<>();
    ArrayList<JDateChooser> mAllDateChoolser = new ArrayList<>();

    private JFrame frmPhiuBnHng;
    private JTextField textMaPhieu;
    private JTextField textMaKH;
    private JTextField textHoTen;
    private JTextField textDiaChi;
    private JTextField textTongCong;
    private JTable tableCTP_BanHang;
    private TableModel tableModel;

    private static final String column1 = "Tên Sản Phẩm";
    private static final String column2 = "Số Lượng";
    private static final String column3 = "Đơn Giá Bán";
    private static final String column4 = "Thành Tiền";

    private static final boolean colum1Editable = true;
    private static final boolean colum2Editable = true;
    private static final boolean colum3Editable = false;
    private static final boolean colum4Editable = false;

    private static final String[] columnNames = new String[]{column1, column2, column3, column4};
    private static final boolean[] editColums = new boolean[]{colum1Editable, colum2Editable, colum3Editable, colum4Editable};

    private PhieuBanHangController controller = null;
    private JDateChooser dateNgayBan;
    private JDateChooser dateNgayThanhToan;
    private JButton btnCheckKhachQuen;
    private JButton btnLayMaKHTiepTheo;
    private JButton btnThm;
    private JButton btnXa;
    private JButton btnLuu;
    private JButton btnXoa;
    private JButton btnThoat;

    public PhieuBanHangView(PhieuBanHangController controller) {
        initialize();
        this.controller = controller;
    }

    public void setVisible(boolean b) {
        frmPhiuBnHng.setVisible(b);
        if (!b) {
            frmPhiuBnHng.dispose();
        }
    }

    private void initialize() {
        frmPhiuBnHng = new JFrame();
        frmPhiuBnHng.setTitle("Phiếu bán hàng");
        frmPhiuBnHng.setBounds(100, 100, 769, 484);
        frmPhiuBnHng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU BÁN HÀNG");
        lblPhiuMuaHng.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblPhiuMuaHng.setBounds(312, 11, 162, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(122, 68, 117, 20);
        textMaPhieu.setColumns(10);
        this.mAllTextField.add(textMaPhieu);

        JLabel lblNgayMua = new JLabel("Ngày bán :");
        lblNgayMua.setBounds(45, 111, 67, 14);

        JLabel lblNgyThanhTon = new JLabel("Ngày thanh toán :");
        lblNgyThanhTon.setBounds(488, 111, 99, 14);

        JLabel labelMaKH = new JLabel("Mã Khách :");
        labelMaKH.setBounds(45, 139, 67, 14);

        textMaKH = new JTextField();
        textMaKH.setBounds(122, 136, 117, 20);
        textMaKH.setColumns(10);
        this.mAllTextField.add(textMaKH);

        JLabel lblHTn = new JLabel("Họ tên :");
        lblHTn.setBounds(488, 139, 57, 14);

        textHoTen = new JTextField();
        textHoTen.setBounds(579, 136, 131, 20);
        textHoTen.setColumns(10);
        this.mAllTextField.add(textHoTen);

        JLabel lblaCh = new JLabel("Địa chỉ :");
        lblaCh.setBounds(45, 208, 74, 14);

        textDiaChi = new JTextField();
        textDiaChi.setBounds(122, 205, 588, 20);
        textDiaChi.setColumns(10);
        this.mAllTextField.add(textDiaChi);

        frmPhiuBnHng.getContentPane().setLayout(null);
        frmPhiuBnHng.getContentPane().add(lblPhiuMuaHng);
        frmPhiuBnHng.getContentPane().add(lblSPhiu);
        frmPhiuBnHng.getContentPane().add(textMaPhieu);
        frmPhiuBnHng.getContentPane().add(lblNgayMua);
        frmPhiuBnHng.getContentPane().add(lblNgyThanhTon);
        frmPhiuBnHng.getContentPane().add(labelMaKH);
        frmPhiuBnHng.getContentPane().add(textMaKH);
        frmPhiuBnHng.getContentPane().add(lblHTn);
        frmPhiuBnHng.getContentPane().add(textHoTen);
        frmPhiuBnHng.getContentPane().add(lblaCh);
        frmPhiuBnHng.getContentPane().add(textDiaChi);

        tableModel = new TableModel(columnNames, editColums);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 262, 665, 110);
        frmPhiuBnHng.getContentPane().add(scrollPane);

        tableCTP_BanHang = new JTable(tableModel);
        scrollPane.setViewportView(tableCTP_BanHang);
        tableCTP_BanHang.addComponentListener(new TableScroller(tableModel, tableCTP_BanHang));

        JLabel lblTngCng = new JLabel("Tổng cộng :");
        lblTngCng.setBounds(492, 386, 67, 14);
        frmPhiuBnHng.getContentPane().add(lblTngCng);

        textTongCong = new JTextField();
        textTongCong.setBounds(569, 383, 141, 20);
        frmPhiuBnHng.getContentPane().add(textTongCong);
        textTongCong.setColumns(10);
        textTongCong.setEditable(false);

        btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnLuuVaoDbActionPerformed(arg0);
            }
        });
        btnLuu.setBounds(330, 411, 89, 23);
        frmPhiuBnHng.getContentPane().add(btnLuu);

        btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnXoaActionPerformed(arg0);
            }
        });
        btnXoa.setBounds(475, 411, 89, 23);
        frmPhiuBnHng.getContentPane().add(btnXoa);

        btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnThoatActionPerformed(arg0);
            }
        });
        btnThoat.setBounds(621, 411, 89, 23);
        frmPhiuBnHng.getContentPane().add(btnThoat);

        dateNgayBan = new JDateChooser();
        dateNgayBan.setBounds(123, 105, 116, 20);
        frmPhiuBnHng.getContentPane().add(dateNgayBan);
        this.mAllDateChoolser.add(dateNgayBan);
        dateNgayBan.setEnabled(false);

        dateNgayThanhToan = new JDateChooser();
        dateNgayThanhToan.setBounds(579, 105, 131, 20);
        frmPhiuBnHng.getContentPane().add(dateNgayThanhToan);
        this.mAllDateChoolser.add(dateNgayThanhToan);

        JLabel lblNewLabel = new JLabel("Danh Sách Chi Tiết Phiếu Bán Hàng");
        lblNewLabel.setBounds(45, 246, 176, 14);
        frmPhiuBnHng.getContentPane().add(lblNewLabel);

        btnThm = new JButton("Thêm");
        btnThm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnThemRowActionPerformed(arg0);
            }
        });
        btnThm.setBounds(45, 383, 67, 23);
        frmPhiuBnHng.getContentPane().add(btnThm);

        btnXa = new JButton("Xóa");
        btnXa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnXoaRowActionPerformed(arg0);
            }
        });
        btnXa.setBounds(132, 382, 74, 23);
        frmPhiuBnHng.getContentPane().add(btnXa);

        btnCheckKhachQuen = new JButton("Kiểm tra");
        btnCheckKhachQuen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnCheckKhachQuenActionPerformed(arg0);
            }
        });
        btnCheckKhachQuen.setBounds(249, 135, 89, 23);
        frmPhiuBnHng.getContentPane().add(btnCheckKhachQuen);

        btnLayMaKHTiepTheo = new JButton("Lấy mã khách hàng tiếp theo");
        btnLayMaKHTiepTheo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.btnLayMaKHTiepTheoActionPerformed(arg0);
            }
        });
        btnLayMaKHTiepTheo.setBounds(122, 171, 216, 23);
        frmPhiuBnHng.getContentPane().add(btnLayMaKHTiepTheo);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public JFrame getFrame() {
        return frmPhiuBnHng;
    }

    public void setFrame(JFrame frame) {
        this.frmPhiuBnHng = frame;
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

    public JDateChooser getDateNgayBan() {
        return dateNgayBan;
    }

    public void setDateNgayBan(JDateChooser dateNgayBan) {
        this.dateNgayBan = dateNgayBan;
    }

    public JDateChooser getDateNgayThanhToan() {
        return dateNgayThanhToan;
    }

    public void setDateNgayThanhToan(JDateChooser dateNgayThanhToan) {
        this.dateNgayThanhToan = dateNgayThanhToan;
    }

    public JTable getTable() {
        return tableCTP_BanHang;
    }

    public void setTable(JTable table) {
        this.tableCTP_BanHang = table;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public boolean isAllTextFilled() {
        for (JTextField textField : mAllTextField) {
            if (textField.getText().toString().trim().length() == 0) {
                return false;
            }
        }
        for (JDateChooser chooser : mAllDateChoolser) {
            if (chooser.getDate() == null) {
                return false;
            }
        }
        return true;
    }

}
