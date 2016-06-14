package main;

import MVCControllers.NhapSanPhamController;
import MVCControllers.PhieuBanHangController;

import MVCControllers.PhieuDichVuController;

import MVCControllers.PhieuChiController;
import MVCControllers.PhieuGiaCongController;
import MVCControllers.PhieuMuaHangController;
import MVCControllers.PhieuNoController;
import MVCControllers.TonKhoController;
import MVCModels.PhieuBanHangModel;
import MVCViews.PhieuBanHangView;
import MVCViews.PhieuDichVuView;
import MVCViews.PhieuHangGiaCongView;

public class Main {

    public static void main(String[] args) {
		// TODO Auto-generated method stub


    	
        //PhieuNoController controller = new PhieuNoController();
        //controller.startApplication();
        
        //PhieuChiController controller = new PhieuChiController();
//        PhieuChiController controller = new PhieuChiController();
//       controller.startApplication();
        
//		NhapSanPhamController controller = new NhapSanPhamController();
//		controller.startApplication();
        
//		PhieuBanHangController controller = new PhieuBanHangController();
//		controller.startApplication();
    	
    	PhieuMuaHangController controller = new PhieuMuaHangController();
    	controller.startApplication();
		
//        PhieuDichVuController controller = new PhieuDichVuController();
        //PhieuGiaCongController controller = new PhieuGiaCongController();
//        controller.start();

    }

}
