package MVCViews;

import MVCControllers.PhieuMuaHangController;
import table.TableModel;
import table.TableScroller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.Font;

public class PhieuMuaHangView {

	ArrayList<JTextField> mAllTextField = new ArrayList<>();
    ArrayList<JDateChooser> mAllDateChoolser = new ArrayList<>();
	
    private JFrame frame;
    private JTextField textMaPhieu;
    private JTextField textMaKH;
    private JTextField textHoTen;
    private JTextField textDiaChi;
    private JTextField textTongCong;
    private JTable tableCTP_MuaHang;
    private TableModel tableModel;
    
    private static final String column1 = "Tên Sản Phẩm";
    private static final String column2 = "Số Lượng";
    private static final String column3 = "Đơn Giá Mua";
    private static final String column4 = "Thành Tiền";
    
    private static final boolean colum1Editable = true;
    private static final boolean colum2Editable = true;
    private static final boolean colum3Editable = false;
    private static final boolean colum4Editable = false;
    
    private static final String[] columnNames = new String[]{column1,column2,column3,column4};
    private static final boolean[] editColums = new boolean[]{colum1Editable,colum2Editable,colum3Editable,colum4Editable};

    private PhieuMuaHangController controller = null;
    private JDateChooser dateNgayMua;
    private JDateChooser dateNgayThanhToan;
    private JButton btnCheckKhachQuen;
    private JButton btnLayMaKHTiepTheo;
    private JButton btnThm;
    private JButton btnXa;
    private JButton btnLuu;
    private JButton btnXoa;
    private JButton btnThoat;
  
    
    public PhieuMuaHangView(PhieuMuaHangController controller) {
        initialize();
        this.controller = controller;
    }

    public void setVisible(boolean b)
    {
        frame.setVisible(b);
        if(!b) frame.dispose();
    }
    
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 769, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU MUA HÀNG");
        lblPhiuMuaHng.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblPhiuMuaHng.setBounds(312, 11, 162, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(122, 68, 117, 20);
        textMaPhieu.setColumns(10);
        this.mAllTextField.add(textMaPhieu);

        JLabel lblNgayMua = new JLabel("Ngày mua :");
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
        
        tableModel = new TableModel(columnNames, editColums);
       
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 262, 665, 110);
        frame.getContentPane().add(scrollPane);
        
        tableCTP_MuaHang = new JTable(tableModel);
        scrollPane.setViewportView(tableCTP_MuaHang);
        tableCTP_MuaHang.addComponentListener(new TableScroller(tableModel, tableCTP_MuaHang));
        
        JLabel lblTngCng = new JLabel("Tổng cộng :");
        lblTngCng.setBounds(492, 386, 67, 14);
        frame.getContentPane().add(lblTngCng);

        textTongCong = new JTextField();
        textTongCong.setBounds(569, 383, 141, 20);
        frame.getContentPane().add(textTongCong);
        textTongCong.setColumns(10);

        btnLuu = new JButton("Lưu");  
        btnLuu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnLuuVaoDbActionPerformed(arg0);
        	}
        });
        btnLuu.setBounds(330, 411, 89, 23);
        frame.getContentPane().add(btnLuu);

        btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnXoaActionPerformed(arg0);
        	}
        });
        btnXoa.setBounds(475, 411, 89, 23);
        frame.getContentPane().add(btnXoa);

        btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnThoatActionPerformed(arg0);
        	}
        });
        btnThoat.setBounds(621, 411, 89, 23);
        frame.getContentPane().add(btnThoat);

        dateNgayMua = new JDateChooser();
        dateNgayMua.setBounds(123, 105, 116, 20);
        frame.getContentPane().add(dateNgayMua);
        this.mAllDateChoolser.add(dateNgayMua);

        dateNgayThanhToan = new JDateChooser();
        dateNgayThanhToan.setBounds(579, 105, 131, 20);
        frame.getContentPane().add(dateNgayThanhToan);
        this.mAllDateChoolser.add(dateNgayThanhToan);
        
        JLabel lblNewLabel = new JLabel("Danh Sách Chi Tiết Phiếu Mua Hàng");
        lblNewLabel.setBounds(45, 246, 176, 14);
        frame.getContentPane().add(lblNewLabel);
        
        btnThm = new JButton("Thêm");
        btnThm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnThemRowActionPerformed(arg0);
        	}
        });
        btnThm.setBounds(45, 383, 67, 23);
        frame.getContentPane().add(btnThm);
        
        btnXa = new JButton("Xóa");
        btnXa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnXoaRowActionPerformed(arg0);
        	}
        });
        btnXa.setBounds(132, 382, 74, 23);
        frame.getContentPane().add(btnXa);
        
        btnCheckKhachQuen = new JButton("Kiểm tra");
        btnCheckKhachQuen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnCheckKhachQuenActionPerformed(arg0);
        	}
        });
        btnCheckKhachQuen.setBounds(249, 135, 99, 23);
        frame.getContentPane().add(btnCheckKhachQuen);
        
        btnLayMaKHTiepTheo = new JButton("Lấy mã khách hàng tiếp theo");
        btnLayMaKHTiepTheo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnLayMaKHTiepTheoActionPerform(arg0);
        	}
        });
        btnLayMaKHTiepTheo.setBounds(122, 171, 226, 23);
        frame.getContentPane().add(btnLayMaKHTiepTheo);
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

	public JDateChooser getDateNgayMua() {
		return dateNgayMua;
	}

	public void setDateNgayMua(JDateChooser dateNgayMua) {
		this.dateNgayMua = dateNgayMua;
	}

	public JDateChooser getDateNgayThanhToan() {
		return dateNgayThanhToan;
	}

	public void setDateNgayThanhToan(JDateChooser dateNgayThanhToan) {
		this.dateNgayThanhToan = dateNgayThanhToan;
	}
	
	public JTable getTable() {
		return tableCTP_MuaHang;
	}

	public void setTable(JTable table) {
		this.tableCTP_MuaHang = table;
	}

	public TableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(TableModel tableModel) {
		this.tableModel = tableModel;
	}

	public boolean isAllTextFilled()
    {
        for(JTextField textField:mAllTextField)
        {
            if(textField.getText().toString().trim().length()==0)
                return false;
        }
        for(JDateChooser chooser :mAllDateChoolser)
        {
            if(chooser.getDate()==null)
                return false;
        }
        return true;
    }
	
	
	public static void main( String[] args )
	{
		PhieuMuaHangController controller = new PhieuMuaHangController();
		PhieuMuaHangView view = new PhieuMuaHangView(controller);
		view.setVisible(true);
	}

}



