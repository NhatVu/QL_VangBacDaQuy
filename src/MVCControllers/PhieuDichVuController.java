/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCControllers;

import DTO.CTP_DichVuDTO;
import DTO.DichVuDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_DichVuDTO;
import DTO.P_ThuDTO;
import DataAcessLayer.KhachHangDAO;
import DataAcessLayer.P_ThuDAO;
import MVCModels.PhieuDichVuModel;
import MVCViews.PhieuDichVuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.in;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main.Resource;
//import sun.net.www.MimeTable;
import table.TableData;

/**
 *
 * @author Administrator
 */
public class PhieuDichVuController implements ActionListener {

    private PhieuDichVuView mPhieuDichVuView;
    private PhieuDichVuModel mPhieuDichVuModel;
    private String[] mDichVu;
    private double dongia = 0;

    public PhieuDichVuController() {
        mPhieuDichVuView = new PhieuDichVuView();
        mPhieuDichVuModel = new PhieuDichVuModel();
    }

    public void start() {
        mPhieuDichVuView.setVisible(true);
        createView();
        handleEvent();
        addMoreTableRecord();

    }

    public void stop() {
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
        switch (e.getActionCommand()) {
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
        if (s.length() != 0) {
            NguoiDTO nguoi = mPhieuDichVuModel.kiemtraKhachQuen(Integer.valueOf(s));
            if (nguoi != null) {
                mPhieuDichVuView.getTextHoTen().setText(nguoi.getHoTen());
                mPhieuDichVuView.getTextDiaChi().setText(nguoi.getDiaChi());
            } else {
                JOptionPane.showMessageDialog(null, "Bạn không phải khách quen");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Xin nhập mã khách quen");
        }

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

        if (this.isTableEmpty() != true && mPhieuDichVuView.isAllTextFilled() == true) {
            double finalMoney = calculateFinalMoney();
            mPhieuDichVuView.getTextTongCong().setText(finalMoney + "");
            String shortId = mPhieuDichVuView.getTextMaKH().getText().toString().trim();
            NguoiDTO nguoi = mPhieuDichVuModel.kiemtraKhachQuen(Integer.valueOf(shortId)); // 
            // kiểm tra ở đây làm gì ta? khi ấn nút kiểm tra => rồi laod thông tin khách hàng. 
            int maKH = 0;
            if (nguoi == null) {
                int nextNguoiId = mPhieuDichVuModel.getNextIdOfNguoi();
                maKH = mPhieuDichVuModel.getNextIdOfKhachHang();

                NguoiDTO newNguoi = new NguoiDTO(nextNguoiId,
                        mPhieuDichVuView.getTextHoTen().getText().toString().trim(),
                        mPhieuDichVuView.getTextDiaChi().getText().toString().trim(),
                        Integer.parseInt(mPhieuDichVuView.getTextMaKH().getText().toString().trim()));
                KhachHangDTO kh = new KhachHangDTO(maKH, nextNguoiId, false);

                mPhieuDichVuModel.insertKhachHang(kh, newNguoi);
            } else {
                maKH = mPhieuDichVuModel.getMaKhByName(Integer.parseInt(shortId));
            }

            int nextIdPhieuThu = mPhieuDichVuModel.getNextIdOfPhieuThu();
            P_ThuDTO pThu = new P_ThuDTO(nextIdPhieuThu, maKH,
                    new Timestamp(mPhieuDichVuView.getDateNgayDK().getDate().getTime()),
                    new Timestamp(mPhieuDichVuView.getDateNgayGiao().getDate().getTime()), finalMoney);

            mPhieuDichVuModel.insertP_Thu(pThu);

            int nextIdPhieuDichVu = Integer.parseInt(mPhieuDichVuView.getTextMaPhieu().getText());
            P_DichVuDTO pDichVu = new P_DichVuDTO(nextIdPhieuDichVu, nextIdPhieuThu);
            mPhieuDichVuModel.insertP_DichVu(pDichVu);

            for (TableData data : mPhieuDichVuView.getmTableModel().getmObjectList()) {
                String tenDv = data.getDataAt(0);
                int idDv = 0;
                for (DichVuDTO dichvuDTO : mPhieuDichVuModel.getAllDichVu()) {
                    if (tenDv.equals(dichvuDTO.getTenDV())) {
                        idDv = dichvuDTO.getMaDV();
                        break;
                    }
                }

                CTP_DichVuDTO ctp = new CTP_DichVuDTO(mPhieuDichVuModel.getNextIdOfCTPDV(),
                        nextIdPhieuDichVu,
                        idDv,
                        Integer.parseInt(data.getDataAt(1)), Double.parseDouble(data.getDataAt(3)));
                mPhieuDichVuModel.insertCTPDichVu(ctp);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
        }
    }

    private void createView() {
        mDichVu = new String[mPhieuDichVuModel.getAllDichVu().size()];

        for (int i = 0; i < mPhieuDichVuModel.getAllDichVu().size(); i++) {
            mDichVu[i] = mPhieuDichVuModel.getAllDichVu().get(i).getTenDV();
        }
        JComboBox combo = new JComboBox<String>(mDichVu);
        mPhieuDichVuView.getmTable().getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(combo));
        mPhieuDichVuView.getmTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String tenDichVu = (String) cb.getSelectedItem();

                for (int i = 0; i < mPhieuDichVuModel.getAllDichVu().size(); i++) {
                    if (mPhieuDichVuModel.getAllDichVu().get(i).getTenDV().equals(tenDichVu)) {
                        dongia = mPhieuDichVuModel.getAllDichVu().get(i).getDonGia();
                        break;
                    }
                }
                int selectedRow = mPhieuDichVuView.getmTable().getSelectedRow();
                if (selectedRow > -1) {
                    mPhieuDichVuView.getmTableModel().setValueAt(dongia + "", selectedRow, 2);
                    if (mPhieuDichVuView.getmTableModel().getValueAt(selectedRow, 1).toString().trim().length() != 0) {
                        mPhieuDichVuView.getmTableModel().setValueAt(dongia * Integer.valueOf(mPhieuDichVuView.getmTableModel().getmObjectList().get(selectedRow).getDataAt(1)) + "", selectedRow, 3);
                    }

                }

            }
        });

        JTextField textField = new JTextField();
        mPhieuDichVuView.getmTable().getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(textField));
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (textField.getText().toString().trim().length() > 0) {
                    if (isInteger(textField.getText().toString().trim())) {
                        mPhieuDichVuView.getmTableModel().setValueAt(dongia * Integer.parseInt(textField.getText().toString().trim()) + "", mPhieuDichVuView.getmTable().getSelectedRow(), 3);
                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập số");
                    }
                }

            }
        });

        mPhieuDichVuView.getTextMaPhieu().setText(String.valueOf(mPhieuDichVuModel.getNextIdOfPhieuDichVu()));
        mPhieuDichVuView.getTextMaPhieu().setEditable(false);
        mPhieuDichVuView.getDateNgayDK().setDate(getCurrentDate());

    }

    public Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    private void getRandomKHId() {
        mPhieuDichVuView.getTextMaKH().setText(String.valueOf(System.currentTimeMillis()).substring(4));
        mPhieuDichVuView.getTextHoTen().setText("");
        mPhieuDichVuView.getTextDiaChi().setText("");

    }

    private void addMoreTableRecord() {
        int size = mPhieuDichVuView.getmTableModel().getmObjectList().size();

        if ((size > 0 && mPhieuDichVuView.getmTableModel().getValueAt(size - 1, 3).toString().trim().length() != 0) || size == 0) {
            ArrayList<String> data = new ArrayList<>();
            data.add(mPhieuDichVuModel.getAllDichVu().get(0).getTenDV());
            data.add("");
            dongia = mPhieuDichVuModel.getAllDichVu().get(0).getDonGia();
            data.add(dongia + "");
            data.add("");
            TableData temp = new TableData(data);
            mPhieuDichVuView.getmTableModel().addObject(temp);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
        }
    }

    private void removeTableRecord() {
        if (mPhieuDichVuView.getmTable().getSelectedRow() >= 0) {
            mPhieuDichVuView.getmTableModel().removeObject(mPhieuDichVuView.getmTable().getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xóa");
        }
    }

    private double calculateFinalMoney() {
        double sum = 0;
        for (int i = 0; i < mPhieuDichVuView.getmTable().getRowCount(); i++) {
            sum += Double.parseDouble((String) mPhieuDichVuView.getmTableModel().getValueAt(i, 3));
        }
        return sum;
    }

    private boolean isTableEmpty() {
        for (int i = 0; i < mPhieuDichVuView.getmTable().getRowCount(); i++) {
            if (mPhieuDichVuView.getmTableModel().getValueAt(i, 3).toString().trim().length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}
