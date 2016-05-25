package MVCControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

import MVCModels.PhieuBanHangModel;
import MVCViews.PhieuBanHangView;

public class PhieuBanHangController {

    PhieuBanHangModel model = new PhieuBanHangModel();
    PhieuBanHangView view = null;

    public void startApplication() {
        view = new PhieuBanHangView(this);
        view.getFrame().setVisible(true);
    }
    
    
}
