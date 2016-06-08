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
        //PhieuNoController controller = new PhieuNoController();
        //controller.startApplication();
        
        //PhieuChiController controller = new PhieuChiController();
        TonKhoController controller = new TonKhoController();
        controller.startApplication();
        
        
       // PhieuDichVuController controller = new PhieuDichVuController();
        //PhieuGiaCongController controller = new PhieuGiaCongController();
        //controller.start();

    
    }
}
