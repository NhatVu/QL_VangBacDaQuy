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

        //PhieuChiController controller = new PhieuChiController(); //xong
        //PhieuNoController controller = new PhieuNoController(); // xong
        // NhapSanPhamController controller = new NhapSanPhamController();
        //PhieuBanHangController controller = new PhieuBanHangController();
       // TonKhoController controller = new TonKhoController();//xong
        PhieuDichVuController controller = new PhieuDichVuController(); // xing 1 nua
        controller.start();

//		PhieuBanHangController controller = new PhieuBanHangController();
//		controller.startApplication();
//    	PhieuMuaHangController controller = new PhieuMuaHangController();
//    	controller.startApplication();
//       
        //PhieuGiaCongController controller = new PhieuGiaCongController();
        //controller.start();
    }

}
