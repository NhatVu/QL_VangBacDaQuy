package main;

import MVCControllers.NhapSanPhamController;
import MVCControllers.PhieuBanHangController;

import MVCControllers.PhieuDichVuController;

import MVCControllers.PhieuChiController;
import MVCControllers.PhieuGiaCongController;

import MVCControllers.PhieuNoController;
import MVCControllers.TonKhoController;
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


		//NhapSanPhamController controller = new NhapSanPhamController();
		//controller.startApplication();
		          PhieuDichVuController controller = new PhieuDichVuController();
                          controller.start();
                                  


    }
    

}
