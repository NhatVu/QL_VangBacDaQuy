package main;

import MVCControllers.NhapSanPhamController;
import MVCControllers.PhieuBanHangController;
import MVCControllers.PhieuNoController;
import MVCModels.PhieuBanHangModel;
import MVCViews.PhieuBanHangView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PhieuBanHangModel modelPhieuBanHang = new PhieuBanHangModel();
//		PhieuBanHangView viewPhieuBanHang = new PhieuBanHangView();
//		PhieuBanHangController controllerPhieuBangHang = new PhieuBanHangController(modelPhieuBanHang, viewPhieuBanHang);
//		
//		viewPhieuBanHang.getFrame().setVisible(true);
		//NhapSanPhamController controller = new NhapSanPhamController();
		//controller.startApplication();
		PhieuNoController noController = new PhieuNoController();
		noController.startApplication();
	}

}
