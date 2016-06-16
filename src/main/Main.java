package main;

import MVCControllers.MainPageController;
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

        MainPageController controller = new MainPageController();
        controller.start();
    }

}
