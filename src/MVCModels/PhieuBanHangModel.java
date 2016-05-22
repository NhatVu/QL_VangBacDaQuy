package team.com.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.toedter.calendar.JDateChooser;

public class PhieuBanHangModel {
	private JTable stateTblDanhSachPhieuBanHang;

	public JTable getStateTblDanhSachPhieuBanHang() {
		return stateTblDanhSachPhieuBanHang;
	}
	
	public PhieuBanHangModel()
	{
		stateTblDanhSachPhieuBanHang = new JTable(new TableValue());		
	}
	
	public class TableValue extends AbstractTableModel
	{
		public Object values[][] = 
			{
				{
					"Clay", 
					"Ashworth", 
					new GregorianCalendar(1962, Calendar.FEBRUARY, 20).getTime(),
					new Float(12345.67)
					
				},
				{
					"Jacob", 
					"Ashworth",
		            new GregorianCalendar(1987, Calendar.JANUARY, 6).getTime(),
		            new Float(23456.78)
				},
				{
					"Jordan", 
					"Ashworth",
		            new GregorianCalendar(1989, Calendar.AUGUST, 31).getTime(),
		            new Float(34567.89)
				},
				{
					"Evelyn", 
					"Kirk",
		            new GregorianCalendar(1945, Calendar.JANUARY, 16).getTime(),
		            new Float(-456.70)
				},
				{
					"Belle", 
					"Spyres",
		            new GregorianCalendar(1907, Calendar.AUGUST, 2).getTime(),
		            new Float(567.00)
				}
			};
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return values[0].length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return values.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return values[rowIndex][columnIndex];
		}
		
	}
	
	public void themPhieuBanHang( 
			String khachHang, String diaChi, JDateChooser ngayThanhToan, 
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
