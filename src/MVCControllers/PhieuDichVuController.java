/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCControllers;

import DTO.NguoiDTO;
import MVCModels.PhieuDichVuModel;
import MVCViews.PhieuDichVuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.in;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import main.Resource;
import table.P_DichVuData;
import table.TableDataAdapter;

/**
 *
 * @author Administrator
 */
public class PhieuDichVuController implements ActionListener{
    private PhieuDichVuView mPhieuDichVuView;
    private PhieuDichVuModel mPhieuDichVuModel;

    private static final String mIdOfPhieuDichVu = "P_DICHVU";
    public PhieuDichVuController() {
        mPhieuDichVuView = new PhieuDichVuView();
        mPhieuDichVuModel = new PhieuDichVuModel();
    }
    
    public void start()
    {
        mPhieuDichVuView.setVisible(true);
        createView();
        handleEvent();
        addMoreTableRecord();

    }
    
    public void stop()
    {
        mPhieuDichVuView.setVisible(false);
    }

    private void handleEvent() {
        mPhieuDichVuView.getMyCheckButton().addActionListener(this);
        mPhieuDichVuView.getMyClearButton().addActionListener(this);
        mPhieuDichVuView.getMyExitButton().addActionListener(this);
        mPhieuDichVuView.getMySaveButton().addActionListener(this);
        mPhieuDichVuView.getmAddButton().addActionListener(this);
        mPhieuDichVuView.getmRandomButton().addActionListener(this);
        mPhieuDichVuView.getmRemoveButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand())
        {
            case Resource.CHECK:
                checkCustomer();
                break;
            case Resource.CLEAR:
                clearData();
                break;
            case Resource.EXIT:
                stop();
                break;
            case Resource.SAVE:
                saveData();
                break;
            case Resource.RANDOM:
                getRandomKHId();
                break;
            case Resource.ADD:
                addMoreTableRecord();
                break;
            case Resource.REMOVE:
                removeTableRecord();
                break;
        }
    }

    private void checkCustomer() {
        String s = mPhieuDichVuView.getTextMaKH().getText().toString().trim();
        if(s.length()!=0)
        {
            NguoiDTO nguoi= mPhieuDichVuModel.kiemtraKhachQuen(Integer.valueOf(s));
            if(nguoi!=null)
            {
                mPhieuDichVuView.getTextHoTen().setText(nguoi.getHoTen());
                mPhieuDichVuView.getTextDiaChi().setText(nguoi.getDiaChi());
            }else
            {
                JOptionPane.showMessageDialog(null,"Bạn không phải khách quen");
            }
        }else
            JOptionPane.showMessageDialog(null,"Xin nhập mã khách quen");
            
    }

    private void clearData() {
        mPhieuDichVuView.getTextDiaChi().setText("");
        mPhieuDichVuView.getTextHoTen().setText("");
        mPhieuDichVuView.getTextMaKH().setText("");
        mPhieuDichVuView.getTextTongCong().setText("");
        mPhieuDichVuView.getDateNgayDK().cleanup();
        mPhieuDichVuView.getDateNgayGiao().cleanup();
        
        
    }

    private void saveData() {
        P_DichVuData temp = (P_DichVuData) mPhieuDichVuView.getmTableModel().getmObjectList().get(0);
        for(String s :temp.getData())
            System.err.println(s);
        
        
        
    }

    private void createView() {
        String maPhieu = mIdOfPhieuDichVu+"1";
        if(mPhieuDichVuModel.getLastId()!=null)
        {
            String curentId = mPhieuDichVuModel.getLastId();
            maPhieu= mIdOfPhieuDichVu+(Integer.valueOf(curentId.substring(mIdOfPhieuDichVu.length()))+1)+"";
        }
        mPhieuDichVuView.getTextMaPhieu().setText(maPhieu);
        
        mPhieuDichVuView.getDateNgayDK().setDate(getCurrentDate());
        
        
        
    }
    
    public Date getCurrentDate()
    {
	   Calendar cal = Calendar.getInstance();
	   return cal.getTime();
    }

    private void getRandomKHId() {
        mPhieuDichVuView.getTextMaKH().setText(String.valueOf(System.currentTimeMillis()).substring(4));
    }

    private void addMoreTableRecord() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Dich vu 1");
        data.add("1");
        data.add("2");
        data.add("2");
        P_DichVuData temp = new P_DichVuData(data);
        mPhieuDichVuView.getmTableModel().addObject(temp);
    }

    private void removeTableRecord() {
        if(mPhieuDichVuView.getmTable().getSelectedRow()>=0)
            mPhieuDichVuView.getmTableModel().removeObject(mPhieuDichVuView.getmTable().getSelectedRow());
        else
            JOptionPane.showMessageDialog(null,"Vui lòng chọn 1 dòng để xóa");
    }

    
    
    
    
}
