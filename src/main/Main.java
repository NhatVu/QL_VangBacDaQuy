package main;

import MVCControllers.NhapSanPhamController;
import MVCControllers.PhieuBanHangController;
import MVCControllers.PhieuChiController;
import MVCControllers.PhieuNoController;
import MVCControllers.TonKhoController;
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
        //PhieuNoController noController = new PhieuNoController();
        //noController.startApplication();
        //TonKhoController controller = new TonKhoController();
        //controller.startApplication();
        PhieuChiController controller = new PhieuChiController();
        controller.stratApplication();
    }
    
}
