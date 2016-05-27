package main;

import MVCControllers.NhapSanPhamController;
import MVCControllers.PhieuBanHangController;
import MVCModels.PhieuBanHangModel;
import MVCViews.PhieuBanHangView;
import MVCViews.PhieuDichVuView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PhieuBanHangModel modelPhieuBanHang = new PhieuBanHangModel();
//		PhieuBanHangView viewPhieuBanHang = new PhieuBanHangView();
//		PhieuBanHangController controllerPhieuBangHang = new PhieuBanHangController(modelPhieuBanHang, viewPhieuBanHang);
//		
//		viewPhieuBanHang.getFrame().setVisible(true);
		PhieuDichVuView controller = new PhieuDichVuView();
		controller.getFrame().setVisible(true);
	}

}
