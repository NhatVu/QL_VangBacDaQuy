package MVCViews;

import MVCControllers.PhieuDichVuController;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import main.Resource;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import table.TableModel;
import table.TableData;
import table.TableScroller;

public class PhieuDichVuView {
    ArrayList<JTextField> mAllTextField = new ArrayList<>();
    ArrayList<JDateChooser> mAllDateChoolser = new ArrayList<>();
    private JFrame frame;
    private JTextField textMaPhieu;
    private JTextField textMaKH;
    private JTextField textHoTen;
    private JTextField textDiaChi;
    private JTextField textTongCong;
    
    //button
    private JButton mSaveButton;
    private JButton mClearButton;
    private JButton mExitButton;
    private JButton mCheckButton;
    private JButton mRandomButton;
    private JButton mAddButton;
    private JButton mRemoveButton;
    
    //date
    
    private JDateChooser dateNgayDK;
    private JDateChooser dateNgayGiao;
    private JScrollPane mScrollPane;
    private JTable mTable;
    private TableModel mTableModel;

    private static final String column1 = "Tên dịch vụ";
    private static final String column2= "Số lượng";
    private static final String column3 = "Đơn Giá";
    private static final String column4 = "Thành tiền";
    
    private static final boolean colum1Editable = true;
    private static final boolean colum2Editable = true;
    private static final boolean colum3Editable = false;
    private static final boolean colum4Editable = false;
    
    
    
    
    private static final String[] columnNames = new String[]{column1,column2,column3,column4};
    private static final boolean[] editColums = new boolean[]{colum1Editable,colum2Editable,colum3Editable,colum4Editable};
    
    //fake
    
    
    public JButton getmRandomButton() {
        return mRandomButton;
    }

    public JButton getmAddButton() {
        return mAddButton;
    }
    
    
    


    public PhieuDichVuView() {
        initialize();
    }

    public JDateChooser getDateNgayDK() {
        return dateNgayDK;
    }

    public JDateChooser getDateNgayGiao() {
        return dateNgayGiao;
    }

    public JButton getmRemoveButton() {
        return mRemoveButton;
    }
    
    

    
    

    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        registerWidgets();
    }
    
    public void setVisible(boolean b)
    {
        frame.setVisible(b);
        if(!b) frame.dispose();
    }
    


    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public JButton getMySaveButton() {
        return mSaveButton;
    }

    public JButton getMyClearButton() {
        return mClearButton;
    }

    public JButton getMyExitButton() {
        return mExitButton;
    }

    public JButton getMyCheckButton() {
        return mCheckButton;
    }
    
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
    

//</editor-fold>



    private void registerWidgets() {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU DỊCH VỤ");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(139, 68, 136, 20);
        textMaPhieu.setColumns(10);
        mAllTextField.add(textMaPhieu);

        JLabel lblNgayMua = new JLabel("Ngày đăng ký :");
        lblNgayMua.setBounds(450, 71, 92, 14);

        JLabel lblNgyThanhTon = new JLabel("Ngày giao :");
        lblNgyThanhTon.setBounds(450, 111, 92, 14);

        JLabel labelMaKH = new JLabel("Mã Khách :");
        labelMaKH.setBounds(45, 111, 67, 14);

        textMaKH = new JTextField();
        textMaKH.setBounds(139, 108, 136, 20);
        textMaKH.setColumns(10);
        mAllTextField.add(textMaKH);

        JLabel lblHTn = new JLabel("Họ tên :");
        lblHTn.setBounds(450, 148, 92, 14);

        textHoTen = new JTextField();
        textHoTen.setBounds(562, 145, 137, 20);
        textHoTen.setColumns(10);
        mAllTextField.add(textHoTen);

        JLabel lblaCh = new JLabel("Địa chỉ :");
        lblaCh.setBounds(45, 181, 74, 14);

        textDiaChi = new JTextField();
        textDiaChi.setBounds(139, 178, 560, 20);
        textDiaChi.setColumns(10);
        mAllTextField.add(textDiaChi);
        
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

        JLabel lblTngCng = new JLabel("Tổng cộng :");
        lblTngCng.setBounds(475, 386, 67, 14);
        frame.getContentPane().add(lblTngCng);

        textTongCong = new JTextField();
        textTongCong.setBounds(562, 383, 148, 20);
        frame.getContentPane().add(textTongCong);
        textTongCong.setColumns(10);
        
        
        mCheckButton = new JButton("Kiểm tra");
        mCheckButton.setActionCommand(Resource.CHECK);
        mCheckButton.setBounds(277, 107, 133, 23);
        frame.getContentPane().add(mCheckButton);
            
        mSaveButton = new JButton("Lưu");
        mSaveButton.setActionCommand(Resource.SAVE);
        mSaveButton.setBounds(425, 414, 89, 23);
        frame.getContentPane().add(mSaveButton);

        mClearButton = new JButton("Xóa");
        mClearButton.setActionCommand(Resource.CLEAR);
        mClearButton.setBounds(524, 414, 89, 23);
        frame.getContentPane().add(mClearButton);

        mExitButton = new JButton("Thoát");
        mExitButton.setActionCommand(Resource.EXIT);
        mExitButton.setBounds(621, 414, 89, 23);
        frame.getContentPane().add(mExitButton);
        
        
        

        dateNgayDK = new JDateChooser();
        dateNgayDK.setBounds(563, 71, 136, 20);
        frame.getContentPane().add(dateNgayDK);
        mAllDateChoolser.add(dateNgayDK);

        dateNgayGiao = new JDateChooser();
        dateNgayGiao.setBounds(563, 108, 136, 20);
        frame.getContentPane().add(dateNgayGiao);
        mAllDateChoolser.add(dateNgayGiao);
        
        mRandomButton = new JButton("Lấy mã khách hàng tiếp theo");
        mRandomButton.setBounds(139, 139, 271, 23);
        mRandomButton.setActionCommand(Resource.RANDOM);
        frame.getContentPane().add(mRandomButton);
        
        mAddButton = new JButton("Thêm");
        mAddButton.setActionCommand(Resource.ADD);
        mAddButton.setBounds(38, 382, 89, 23);
        frame.getContentPane().add(mAddButton);
        
        mRemoveButton = new JButton("Xóa");
        mRemoveButton.setActionCommand(Resource.REMOVE);
        mRemoveButton.setBounds(139, 382, 89, 23);
        frame.getContentPane().add(mRemoveButton);
        
        //
        
        mTableModel = new TableModel(columnNames,editColums);
        
        
        
        mScrollPane = new JScrollPane();
        mScrollPane.setBounds(45, 209, 654, 154);
        frame.getContentPane().add(mScrollPane);
        
        mTable = new JTable(mTableModel);
        mScrollPane.setViewportView(mTable);
        mTable.addComponentListener(new TableScroller(mTableModel,mTable));
    }

    public JTable getmTable() {
        return mTable;
    }

    public TableModel getmTableModel() {
        return mTableModel;
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
    
    
    
    
}
