package main;

import MVCControllers.PhieuBanHangController;
import MVCModels.PhieuBanHangModel;
import MVCViews.PhieuBanHangView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhieuBanHangModel modelPhieuBanHang = new PhieuBanHangModel();
		PhieuBanHangView viewPhieuBanHang = new PhieuBanHangView();
		PhieuBanHangController controllerPhieuBangHang = new PhieuBanHangController(modelPhieuBanHang, viewPhieuBanHang);
		
		viewPhieuBanHang.getFrame().setVisible(true);
	}

}
