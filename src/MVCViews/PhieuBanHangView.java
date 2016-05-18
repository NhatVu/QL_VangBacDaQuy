package MVCViews;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Label;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PhieuBanHangView {

	private JFrame frame;
	private JTextField txtKhachHang;
	private JTextField txtDiaChi;
	private JSpinner spinnerNgayLapPhieu;
	private JSpinner spinnerNgayThanhToan;
	private JLabel lblTongTien;
	private JComboBox cbKieuSanPham;
	private JComboBox cbLoaiSanPham;
	private JTextField txtSoLuong;
	private JComboBox cbDonGia;
	private JLabel lblThanhTien;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JTable tblDanhSachPhieuBanHang;
	private JButton btnLuu;
	private JButton btnThoat;

	/**
	 * Create the application.
	 */
	public PhieuBanHangView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPhieuBanHang = new JLabel("PHIẾU BÁN HÀNG");
		lblPhieuBanHang.setBounds(347, 11, 171, 14);
		
		JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
		lblThngTinKhch.setBounds(10, 31, 122, 14);
		
		JLabel lblKhchHng = new JLabel("Khách Hàng:");
		lblKhchHng.setBounds(10, 54, 89, 14);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setBounds(100, 51, 147, 20);
		txtKhachHang.setColumns(10);
		
		JLabel lblaCh = new JLabel("Địa Chỉ:");
		lblaCh.setBounds(299, 54, 57, 14);
		
		JLabel lblNgyLpPhiu = new JLabel("Ngày Lập Phiếu:");
		lblNgyLpPhiu.setBounds(10, 79, 101, 14);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(410, 51, 147, 20);
		txtDiaChi.setColumns(10);
		
		JLabel lblNgy = new JLabel("Ngày Thanh Toán:");
		lblNgy.setBounds(299, 79, 109, 14);
		
		JLabel lblNewLabel = new JLabel("Thông tin phiếu bán hàng");
		lblNewLabel.setBounds(10, 127, 147, 14);
		
		JLabel lblKiuSnPhm = new JLabel("Kiểu Sản Phẩm:");
		lblKiuSnPhm.setBounds(10, 152, 89, 14);
		
		String[] arrSanPham = {"Nhẫn Vàng", "Nhẫn Bạc", "Nhận Đồng","Nhẫn Nhôm", "Nhẫn...BCS"};
		final DefaultComboBoxModel<String> sanphamName = new DefaultComboBoxModel<String>();
		for( int i = 0; i < arrSanPham.length; i++ )
		{
			sanphamName.addElement(arrSanPham[i]);
		}
		cbKieuSanPham = new JComboBox(sanphamName);
		cbKieuSanPham.setSelectedIndex(0);
		cbKieuSanPham.setBounds(99, 149, 148, 20);
		
		JLabel lblLoiSnPhm = new JLabel("Loại Sản Phẩm:");
		lblLoiSnPhm.setBounds(299, 152, 101, 14);
		
		final DefaultComboBoxModel<String> loaiSanPhamName = new DefaultComboBoxModel<String>();
		loaiSanPhamName.addElement("Hàng Thật");
		loaiSanPhamName.addElement("Hàng Giả");
		cbLoaiSanPham = new JComboBox(loaiSanPhamName);
		cbLoaiSanPham.setSelectedIndex(0);
		cbLoaiSanPham.setBounds(410, 149, 147, 20);
		
		JLabel lblNewLabel_1 = new JLabel("Số Lượng:");
		lblNewLabel_1.setBounds(10, 177, 79, 14);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(100, 174, 147, 20);
		txtSoLuong.setColumns(10);
		
		JLabel lblTngTin = new JLabel("Tổng Tiền:");
		lblTngTin.setBounds(598, 79, 71, 14);
		
		lblTongTien = new JLabel("0");
		lblTongTien.setBounds(679, 79, 98, 14);
		lblTongTien.setEnabled(false);
		lblTongTien.setBackground(SystemColor.controlShadow);
		
		JLabel lblnGi = new JLabel("Đơn Giá:");
		lblnGi.setBounds(298, 177, 71, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Thành Tiền:");
		lblNewLabel_2.setBounds(598, 177, 79, 14);
		
		Integer[] listDonGia = { 50000, 60000, 90000, 200000, 500000, 700000, 950000, 1200000  };
		final DefaultComboBoxModel<Integer> dongiaName = new DefaultComboBoxModel<Integer>();
		for( int i = 0; i < listDonGia.length; i++ )
		{
			dongiaName.addElement(listDonGia[i]);
		}
		cbDonGia = new JComboBox(dongiaName);
		cbDonGia.setSelectedIndex(7);
		cbDonGia.setBounds(410, 174, 147, 20);
		
		lblThanhTien = new JLabel("0");
		lblThanhTien.setBounds(676, 177, 98, 14);
		lblThanhTien.setEnabled(false);
		lblThanhTien.setBackground(SystemColor.inactiveCaption);
		
		JLabel lblDanhSchPhiu = new JLabel("Danh Sách Phiếu Bán Hàng Mới Nhập");
		lblDanhSchPhiu.setBounds(10, 254, 237, 14);
		
		// cái JTable bên dưới chưa xong !!! :D
		String[][] arr2C = {  {"a", "1"}, {"b", "2"}, {"c", "3"}  };
		String[] arr1C = {"TEN", "TUOI"};
		//final DefaultTableColumnModel
		tblDanhSachPhieuBanHang = new JTable(5, 4);
		tblDanhSachPhieuBanHang.setBounds(10, 268, 764, 142);
		
		spinnerNgayLapPhieu = new JSpinner();
		spinnerNgayLapPhieu.setBounds(99, 77, 147, 20);
		
		spinnerNgayThanhToan = new JSpinner();
		spinnerNgayThanhToan.setBounds(410, 76, 147, 20);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblPhieuBanHang);
		frame.getContentPane().add(lblThngTinKhch);
		frame.getContentPane().add(lblKhchHng);
		frame.getContentPane().add(lblaCh);
		frame.getContentPane().add(txtDiaChi);
		frame.getContentPane().add(txtKhachHang);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblKiuSnPhm);
		frame.getContentPane().add(cbKieuSanPham);
		frame.getContentPane().add(txtSoLuong);
		frame.getContentPane().add(lblnGi);
		frame.getContentPane().add(lblNgy);
		frame.getContentPane().add(lblNgyLpPhiu);
		frame.getContentPane().add(lblTngTin);
		frame.getContentPane().add(lblLoiSnPhm);
		frame.getContentPane().add(lblTongTien);
		frame.getContentPane().add(cbLoaiSanPham);
		frame.getContentPane().add(spinnerNgayLapPhieu);
		frame.getContentPane().add(spinnerNgayThanhToan);
		frame.getContentPane().add(cbDonGia);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(lblThanhTien);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblDanhSchPhiu);
		frame.getContentPane().add(tblDanhSachPhieuBanHang);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(100, 220, 89, 23);
		frame.getContentPane().add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(299, 220, 89, 23);
		frame.getContentPane().add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnXoa.setBounds(494, 220, 89, 23);
		frame.getContentPane().add(btnXoa);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(688, 427, 89, 23);
		frame.getContentPane().add(btnThoat);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(580, 427, 89, 23);
		frame.getContentPane().add(btnLuu);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtKhachHang() {
		return txtKhachHang;
	}

	public void setTxtKhachHang(JTextField txtKhachHang) {
		this.txtKhachHang = txtKhachHang;
	}

	public JTextField getTxtDiaChi() {
		return txtDiaChi;
	}

	public void setTxtDiaChi(JTextField txtDiaChi) {
		this.txtDiaChi = txtDiaChi;
	}

	public JSpinner getSpinnerNgayLapPhieu() {
		return spinnerNgayLapPhieu;
	}

	public void setSpinnerNgayLapPhieu(JSpinner spinnerNgayLapPhieu) {
		this.spinnerNgayLapPhieu = spinnerNgayLapPhieu;
	}

	public JSpinner getSpinnerNgayThanhToan() {
		return spinnerNgayThanhToan;
	}

	public void setSpinnerNgayThanhToan(JSpinner spinnerNgayThanhToan) {
		this.spinnerNgayThanhToan = spinnerNgayThanhToan;
	}

	public int getLblTongTien() {
		return Integer.parseInt(lblTongTien.toString());
	}

	public void setLblTongTien(int lblTongTien) {
		this.lblTongTien.setText(Integer.toString(lblTongTien));
	}

	public JComboBox getCbKieuSanPham() {
		return cbKieuSanPham;
	}

	public void setCbKieuSanPham(JComboBox cbKieuSanPham) {
		this.cbKieuSanPham = cbKieuSanPham;
	}

	public JComboBox getCbLoaiSanPham() {
		return cbLoaiSanPham;
	}

	public void setCbLoaiSanPham(JComboBox cbLoaiSanPham) {
		this.cbLoaiSanPham = cbLoaiSanPham;
	}

	public int getTxtSoLuong() {
		return Integer.parseInt(txtSoLuong.getText());
	}

	public void setTxtSoLuong(int txtSoLuong) {
		this.txtSoLuong.setText(Integer.toString(txtSoLuong));
	}

	public JComboBox getCbDonGia() {
		return cbDonGia;
	}

	public void setCbDonGia(JComboBox cbDonGia) {
		this.cbDonGia = cbDonGia;
	}

	public int getLblThanhTien() {
		return Integer.parseInt(lblThanhTien.getText());
	}

	public void setLblThanhTien(int lblThanhTien) {
		this.lblThanhTien.setText(Integer.toString(lblThanhTien));
	}

	public JButton getBtnThem() {
		return btnThem;
	}

	public JButton getBtnSua() {
		return btnSua;
	}

	public JButton getBtnXoa() {
		return btnXoa;
	}

	public JTable getTbDanhSachPhieuBanHang() {
		return tblDanhSachPhieuBanHang;
	}

	public void setTbDanhSachPhieuBanHang(JTable tblDanhSachPhieuBanHang) {
		this.tblDanhSachPhieuBanHang = tblDanhSachPhieuBanHang;
	}
	
	
	// gọi các Sự Kiện, chưa xử lý sự kiện ( sự kiện được xử lý trong Controller )
	public void addBtnThemListener( ActionListener listenBtnThem )
	{
		btnThem.addActionListener(listenBtnThem);
	}
	
	public void addBtnSuaListener( ActionListener listenBtnSua )
	{
		btnSua.addActionListener(listenBtnSua);
	}
	
	public void addBtnXoaListener( ActionListener listenBtnXoa )
	{
		btnXoa.addActionListener(listenBtnXoa);
	}
	
	public void addBtnLuuListener( ActionListener listenBtnLuu )
	{
		btnLuu.addActionListener(listenBtnLuu);
	}
	
	public void addBtnThoatListener( ActionListener listenBtnThoat )
	{
		btnThoat.addActionListener(listenBtnThoat);
	}
}
