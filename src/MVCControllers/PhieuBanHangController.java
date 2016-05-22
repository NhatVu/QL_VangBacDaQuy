package team.com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

import team.com.model.PhieuBanHangModel;
import team.com.view.PhieuBanHangView;

public class PhieuBanHangController {
	private PhieuBanHangModel modelPhieuBanHang;
	private PhieuBanHangView viewPhieuBanHang;
	
	public PhieuBanHangController(PhieuBanHangModel modelPhieuBanHang, PhieuBanHangView viewPhieuBanHang) {
		this.modelPhieuBanHang = modelPhieuBanHang;
		this.viewPhieuBanHang = viewPhieuBanHang;
		
		viewPhieuBanHang.addBtnThemListener( new BtnThemListener() );
		
		// tượng tự, đối với viewPhieuBanHang.addBtnSuaListener, viewPhieuBanHang.addBtnXoaListener, viewPhieuBanHang.addBtnLuuListener 
				// và viewPhieuBanHang.addBtnThoatListener
				/*
				 *
				 */
		viewPhieuBanHang.addBtnThoatListener(new BtnThoatListener());
	}
	
	
	public class BtnThemListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			String khachHang;
			String diaChi;
			JDateChooser ngayThanhToan;
			String sanPham;
			int soLuong;
			int donGia;
			int thanhTien;
			
			try 
			{
				khachHang = viewPhieuBanHang.getTxtKhachHang().getText();
				diaChi = viewPhieuBanHang.getTxtDiaChi().getText();
				ngayThanhToan = viewPhieuBanHang.getDateNgayThanhToan();
				sanPham = viewPhieuBanHang.getCbKieuSanPham().getSelectedItem().toString();
				soLuong = viewPhieuBanHang.getTxtSoLuong();
				donGia = Integer.parseInt(viewPhieuBanHang.getCbDonGia().getSelectedItem().toString());
				thanhTien = viewPhieuBanHang.getLblThanhTien();
				
				modelPhieuBanHang.themPhieuBanHang(khachHang, diaChi, ngayThanhToan, sanPham, soLuong, donGia, thanhTien);
				
				viewPhieuBanHang.setTblDanhSachPhieuBanHang(modelPhieuBanHang.getStateTblDanhSachPhieuBanHang());
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
	}
	
	public class BtnThoatListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			viewPhieuBanHang.getFrame().dispose();
		}
		
	}
}
