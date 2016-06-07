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

//		NhapSanPhamController controller = new NhapSanPhamController();
//		controller.startApplication();
		          
//    	PhieuDichVuController controller = new PhieuDichVuController();
//    	controller.start();
                                  
    	PhieuBanHangController controller = new PhieuBanHangController();
    	controller.startApplication();
    }
    

}
