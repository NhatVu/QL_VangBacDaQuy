package MVCViews;

import DTO.NguoiDTO;
import DTO.ThoGiaCongDTO;
import DataAcessLayer.NguoiDAO;
import DataAcessLayer.ThoGiaCongDAO;
import MVCControllers.PhieuGiaCongController;
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


public class PhieuHangGiaCongView {
    ArrayList<JTextField> mAllTextField = new ArrayList<>();
    ArrayList<JDateChooser> mAllDateChoolser = new ArrayList<>();
    ArrayList<ThoGiaCongDTO> mAllThoGiaCong;
    ArrayList<NguoiDTO> mAllNguoi;

    public ArrayList<ThoGiaCongDTO> getmAllThoGiaCong() {
        return mAllThoGiaCong;
    }

    public void setmAllThoGiaCong(ArrayList<ThoGiaCongDTO> mAllThoGiaCong) {
        this.mAllThoGiaCong = mAllThoGiaCong;
    }

    public ArrayList<NguoiDTO> getmAllNguoi() {
        return mAllNguoi;
    }

    public void setmAllNguoi(ArrayList<NguoiDTO> mAllNguoi) {
        this.mAllNguoi = mAllNguoi;
    }
    
    
            
    private JFrame frame;
    private JTextField textMaPhieu;
    private JTextField textMaKH;
    private JComboBox textHoTen;
    private JTextField textDiaChi;
    private JTextField textTongCong;
  
    private JScrollPane mScrollPane;
    private JTable mTable;
    private TableModel mTableModel;

    public JTable getmTable() {
        return mTable;
    }

    public TableModel getmTableModel() {
        return mTableModel;
    }

    public JButton getmAddButton() {
        return mAddButton;
    }

    public JButton getmRemoveButton() {
        return mRemoveButton;
    }

    public JButton getmSaveButton() {
        return mSaveButton;
    }

    public JButton getmClearButton() {
        return mClearButton;
    }

    public JButton getmExitButton() {
        return mExitButton;
    }

    public JDateChooser getDateNgayThanhToan() {
        return dateNgayThanhToan;
    }

    public JDateChooser getDateNgayNhanHang() {
        return dateNgayNhanHang;
    }
    
        public ArrayList<JTextField> getmAllTextField() {
        return mAllTextField;
    }

    public ArrayList<JDateChooser> getmAllDateChoolser() {
        return mAllDateChoolser;
    }
    
    
    private static final String column1 = "Tên hàng gia công";
    private static final String column2= "Số lượng";
    private static final String column3 = "Đơn Giá";
    private static final String column4 = "Thành tiền";
    
    private static final boolean colum1Editable = true;
    private static final boolean colum2Editable = true;
    private static final boolean colum3Editable = false;
    private static final boolean colum4Editable = false;
    
    
    
    
    private static final String[] columnNames = new String[]{column1,column2,column3,column4};
    private static final boolean[] editColums = new boolean[]{colum1Editable,colum2Editable,colum3Editable,colum4Editable};
    
    
    private JButton mAddButton;
    private JButton mRemoveButton;
    private JButton mSaveButton;
    private JButton mClearButton;
    private JButton mExitButton;
    private JDateChooser dateNgayThanhToan;
    private JDateChooser dateNgayNhanHang;
    private PhieuGiaCongController controller = null;
    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    
    /**
	 * @wbp.parser.constructor
	 */
    public PhieuHangGiaCongView(PhieuGiaCongController controller) {
        initialize();
        this.controller = controller;
    }

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
    private void registerWidgets()
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 792, 484);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPhiuMuaHng = new JLabel("PHIẾU HÀNG GIA CÔNG");
        lblPhiuMuaHng.setBounds(294, 32, 116, 14);

        JLabel lblSPhiu = new JLabel("Mã phiếu :");
        lblSPhiu.setBounds(45, 71, 67, 14);

        textMaPhieu = new JTextField();
        textMaPhieu.setBounds(122, 68, 180, 20);
        textMaPhieu.setColumns(10);
        mAllTextField.add(textMaPhieu);

        JLabel lblNgayMua = new JLabel("Ngày nhận hàng :");
        lblNgayMua.setBounds(393, 114, 121, 14);

        JLabel lblNgyThanhTon = new JLabel("Ngày thanh toán :");
        lblNgyThanhTon.setBounds(393, 158, 121, 14);

        JLabel labelMaKH = new JLabel("Mã thợ:");
        labelMaKH.setBounds(45, 158, 67, 14);
        
        textDiaChi = new JTextField();
        textDiaChi.setBounds(122, 197, 588, 20);
        textDiaChi.setColumns(10);
        mAllTextField.add(textDiaChi);

        textMaKH = new JTextField();
        textMaKH.setBounds(122, 155, 180, 20);
        textMaKH.setColumns(10);
        mAllTextField.add(textMaKH);

        JLabel lblHTn = new JLabel("Họ tên thợ:");
        lblHTn.setBounds(45, 114, 67, 14);
        
        mAllNguoi = new ArrayList<>();
        mAllThoGiaCong = new ThoGiaCongDAO().getAllThoGiaCong();
        String[] thogiacongs = new String[mAllThoGiaCong.size()];
        for(int i = 0;i<mAllThoGiaCong.size();i++)
        {
            NguoiDTO nguoi =new NguoiDAO().getNguoiFromMaNguoi(mAllThoGiaCong.get(i).getMaNguoi());
            mAllNguoi.add(nguoi);
            thogiacongs[i] = nguoi.getHoTen();
        }
        
        textMaKH.setText(String.valueOf(mAllThoGiaCong.get(0).getMaTho()));
        textDiaChi.setText(mAllNguoi.get(0).getDiaChi());
            
        textHoTen = new JComboBox(thogiacongs);
        textHoTen.setBounds(122, 111, 180, 20);


        JLabel lblaCh = new JLabel("Địa chỉ :");
        lblaCh.setBounds(45, 200, 74, 14);

        
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

        dateNgayNhanHang = new JDateChooser();
        dateNgayNhanHang.setBounds(530, 108, 180, 20);
        frame.getContentPane().add(dateNgayNhanHang);
        mAllDateChoolser.add(dateNgayNhanHang);
                

        dateNgayThanhToan = new JDateChooser();
        dateNgayThanhToan.setBounds(530, 152, 180, 20);
        frame.getContentPane().add(dateNgayThanhToan);
        mAllDateChoolser.add(dateNgayThanhToan);
        
        mAddButton = new JButton("Thêm");
        mAddButton.setActionCommand(Resource.ADD);
        mAddButton.setBounds(45, 382, 89, 23);
        frame.getContentPane().add(mAddButton);
        
        mRemoveButton = new JButton("Xóa");
        mRemoveButton.setActionCommand(Resource.REMOVE);
        mRemoveButton.setBounds(154, 382, 89, 23);
        frame.getContentPane().add(mRemoveButton);
        
        mTableModel = new TableModel(columnNames,editColums);
        
        mScrollPane = new JScrollPane();
        mScrollPane.setBounds(45, 239, 665, 136);
        frame.getContentPane().add(mScrollPane);
        
        mTable = new JTable(mTableModel);
        mScrollPane.setViewportView(mTable);
        mTable.addComponentListener(new TableScroller(mTableModel,mTable));
    }

    public PhieuHangGiaCongView(JButton mAddButton, JButton mRemoveButton, JButton mSaveButton, JButton mClearButton, JButton mExitButton) {
        this.mAddButton = mAddButton;
        this.mRemoveButton = mRemoveButton;
        this.mSaveButton = mSaveButton;
        this.mClearButton = mClearButton;
        this.mExitButton = mExitButton;
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
    
    public JComboBox getTextHoTen() {
        return textHoTen;
    }
    
    public void setTextHoTen(JComboBox textHoTen) {
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
