package MVCModels;

import javax.swing.JSpinner;
import javax.swing.JTable;

public class PhieuBanHangModel {
	private JTable stateTblDanhSachPhieuBanHang;

	public JTable getStateTblDanhSachPhieuBanHang() {
		return stateTblDanhSachPhieuBanHang;
	}
	
	public void themPhieuBanHang( 
			String khachHang, String diaChi, JSpinner ngayThanhToan, 
			String sanPham, int soLuong, int donGia, int thanhTien)
	{
		// xử lý thêm Phiếu Bán Hàng tại đây
		
		
		
		
		
		
		/* giả sử, trong tblDanhSachPhieuBanHang hiển thị 7 cột:khachHang, diaChi, ngayThanhToan, sanPham, soLuong, donGia, thanhTien */
		
		// stateTblDanhSachPhieuBanHang
	}
	
	// Tương tự, cách tổ chức trong Model & Controller, đối với xử lý suaPhieuBanHang, xoaphieuBanHang, luuPhieuBanHang và thoatPhieuBanHang 
	public void suaPhieuBanHang( /* ... */ )
	{
		
	}

	public void xoaPhieuBanHang(  )
	{
		
	}
	
	public void luuPhieuBanHang(  )
	{
		
	}
}
