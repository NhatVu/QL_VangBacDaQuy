package MVCViews;

import MVCControllers.PhieuBanHangController;
import TableModel.CTP_BanHangTableModel;
import table.TableScroller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JComboBox;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhieuBanHangView {

	ArrayList<JTextField> mAllTextField = new ArrayList<>();
    ArrayList<JDateChooser> mAllDateChoolser = new ArrayList<>();
	
    private JFrame frame;
    private JTextField textMaPhieu;
    private JTextField textMaKH;
    private JTextField textHoTen;
    private JTextField textDiaChi;
    private JTextField textTongCong;
    private JTable tableCTP_BanHang;
    private CTP_BanHangTableModel ct_PhieuBanHangTableModel;

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
  
//    public PhieuBanHangView()
//    {
//    	initialize();
//    }
    
    public PhieuBanHangView(PhieuBanHangController controller) {
        initialize();
        this.controller = controller;
    }

    private void initialize() {
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosed(WindowEvent arg0) {
        		JOptionPane.showMessageDialog(null, "Window listener started");
        		textMaPhieu.setText("Hi Hi Hi");
        	}
        });
        frame.setBounds(100, 100, 769, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU BÁN HÀNG");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

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
        
        ct_PhieuBanHangTableModel = new CTP_BanHangTableModel(); 
        tableCTP_BanHang = new JTable(ct_PhieuBanHangTableModel);
        tableCTP_BanHang.addComponentListener(new TableScroller());
       
        JScrollPane scrollPane = new JScrollPane(tableCTP_BanHang);
        scrollPane.setBounds(45, 262, 665, 110);
        
        frame.getContentPane().add(scrollPane);
        
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
        		controller.btnXoaKhoiDbActionPerformed(arg0);
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

        dateNgayBan = new JDateChooser();
        dateNgayBan.setBounds(123, 105, 116, 20);
        frame.getContentPane().add(dateNgayBan);
        this.mAllDateChoolser.add(dateNgayBan);

        dateNgayThanhToan = new JDateChooser();
        dateNgayThanhToan.setBounds(579, 105, 131, 20);
        frame.getContentPane().add(dateNgayThanhToan);
        this.mAllDateChoolser.add(dateNgayThanhToan);
        
        JLabel lblNewLabel = new JLabel("Danh Sách Chi Tiết Phiếu Bán Hàng");
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
        btnCheckKhachQuen.setBounds(249, 135, 74, 23);
        frame.getContentPane().add(btnCheckKhachQuen);
        
        btnLayMaKHTiepTheo = new JButton("Lấy mã khách hàng tiếp theo");
        btnLayMaKHTiepTheo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		controller.btnLayMaKHTiepTheoActionPerformed(arg0);
        	}
        });
        btnLayMaKHTiepTheo.setBounds(122, 171, 201, 23);
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
    
    public JTable getTableCTP_MH() {
        return tableCTP_BanHang;
    }
    
    public void setTableCTP_MH(JTable tableCTP_MH) {
        this.tableCTP_BanHang = tableCTP_MH;
    }    
    
    public CTP_BanHangTableModel getCt_PhieuBanHangTableModel() {
		return ct_PhieuBanHangTableModel;
	}

	public void setCt_PhieuBanHangTableModel(CTP_BanHangTableModel ct_PhieuBanHangTableModel) {
		this.ct_PhieuBanHangTableModel = ct_PhieuBanHangTableModel;
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
	
	public JButton getBtnCheckKhachQuen() {
		return btnCheckKhachQuen;
	}

	public void setBtnCheckKhachQuen(JButton btnCheckKhachQuen) {
		this.btnCheckKhachQuen = btnCheckKhachQuen;
	}

	public JButton getBtnLayMaKHTiepTheo() {
		return btnLayMaKHTiepTheo;
	}

	public void setBtnLayMaKHTiepTheo(JButton btnLayMaKHTiepTheo) {
		this.btnLayMaKHTiepTheo = btnLayMaKHTiepTheo;
	}

	public JButton getBtnThm() {
		return btnThm;
	}

	public void setBtnThm(JButton btnThm) {
		this.btnThm = btnThm;
	}

	public JButton getBtnXa() {
		return btnXa;
	}

	public void setBtnXa(JButton btnXa) {
		this.btnXa = btnXa;
	}

	public JButton getBtnLuu() {
		return btnLuu;
	}

	public void setBtnLuu(JButton btnLuu) {
		this.btnLuu = btnLuu;
	}

	public JButton getBtnXoa() {
		return btnXoa;
	}

	public void setBtnXoa(JButton btnXoa) {
		this.btnXoa = btnXoa;
	}

	public JButton getBtnThoat() {
		return btnThoat;
	}

	public void setBtnThoat(JButton btnThoat) {
		this.btnThoat = btnThoat;
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


	// this class helps the scroll move to Bottom Position
 	class TableScroller extends ComponentAdapter
 	{
 		public void componentResized( ComponentEvent event )
 		{
 			int lastRow = ct_PhieuBanHangTableModel.getRowCount() - 1;
 			int cellTop = tableCTP_BanHang.getCellRect(lastRow, 0, true).y;
 			JScrollPane jsp = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, tableCTP_BanHang);
 			JViewport jvp = jsp.getViewport();
 			int portHeight = jvp.getSize().height;
 			int position  = cellTop - ( portHeight - tableCTP_BanHang.getRowHeight() - tableCTP_BanHang.getRowMargin());
 			if( position >= 0 )
 			{
 				jvp.setViewPosition(new Point(0, position));
 			}
 		}
 	}
}



