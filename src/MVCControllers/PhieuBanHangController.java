package MVCControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import DTO.CTP_BanHangDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_BanHangDTO;
import DTO.P_ThuDTO;
import DTO.SanPhamDTO;
import MVCModels.PhieuBanHangModel;
import MVCViews.PhieuBanHangView;
import table.TableData;

public class PhieuBanHangController implements Controller {

    private PhieuBanHangModel model = new PhieuBanHangModel();
    private PhieuBanHangView view = null;
    private Controller parent;

    private String[] dsTenSanPham;
    private double donGiaBan = 0;

    public void start() {
        view = new PhieuBanHangView(this);
        view.setVisible(true);
        createAutoView();
        btnThemRowActionPerformed(null); // tự tạo dòng đầu tiên trong JTable khi Phiếu Bán Hàng được mở lên
        setParentVisiableFalse();
    }

    private void createAutoView() {
        // TODO Auto-generated method stub
        dsTenSanPham = new String[model.getAllSanPham().size()];

        for (int i = 0; i < model.getAllSanPham().size(); i++) {
            dsTenSanPham[i] = model.getAllSanPham().get(i).getTenSP();
        }
        /*
         *  tạo comboBox tên sản phẩm cho cột Tên Sản Phẩm
         */
        JComboBox comboTenSanPham = new JComboBox<String>(dsTenSanPham);
        view.getTable().getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboTenSanPham));
        view.getTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

        comboTenSanPham.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JComboBox cb = (JComboBox) e.getSource();
                String tenSanPham = (String) cb.getSelectedItem();

                /*
                 * 	- Kiểm tra tenSanPham trong Database
                 * 	- Tính giá trị của Thành Tiền
                 */
                for (int i = 0; i < model.getAllSanPham().size(); i++) {
                    if (tenSanPham.equals(model.getAllSanPham().get(i).getTenSP())) {
                        donGiaBan = model.getAllSanPham().get(i).getDonGiaBan();
                        break;
                    }
                }
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    view.getTableModel().setValueAt(donGiaBan + "", selectedRow, 2);

                    if (view.getTableModel().getValueAt(selectedRow, 1).toString().trim().length() != 0) {
                        int soLuongNhap = Integer.valueOf(view.getTableModel().getmObjectList().get(selectedRow).getDataAt(1).trim());
                        view.getTableModel().setValueAt(donGiaBan * soLuongNhap + "", selectedRow, 3);
                    }
                }
            }
        });

        /* Khi chỉnh sửa giá trị của column Số Lượng
         * 	- Kiểm tra Số Lượng nhập vào là số nguyên
         * 	- Tính giá trị của Thành Tiền
         */
        JTextField textField = new JTextField();
        view.getTable().getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(textField));
        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                warn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                warn();
            }

            private void warn() {
                // TODO Auto-generated method stub
                if (textField.getText().toString().trim().length() > 0) {
                    if (isInteger(textField.getText().toString().trim())) {
                        view.getTableModel().setValueAt(donGiaBan * Integer.parseInt(textField.getText().toString().trim()) + "", view.getTable().getSelectedRow(), 3);
                    } else {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập số");
                    }
                }
            }
        });

        view.getTextMaPhieu().setText(String.valueOf(model.getNextIdOfPhieuBanHang()));
        view.getTextMaPhieu().setEditable(false);
        view.getDateNgayBan().setDate(getCurrentDate());
        view.getTextTongCong().setEditable(false);
    }

    private Date getCurrentDate() {
        // TODO Auto-generated method stub
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /*
     * 	Xử lý sự kiện 
     */
    public void btnCheckKhachQuenActionPerformed(ActionEvent arg0) {
        String maKH = view.getTextMaKH().getText().toString().trim();
        if (maKH.length() != 0) {
            NguoiDTO nguoiDTO = model.kiemTraKhachQuen(Integer.valueOf(maKH));
            if (nguoiDTO != null) {
                view.getTextHoTen().setText(nguoiDTO.getHoTen());
                view.getTextDiaChi().setText(nguoiDTO.getDiaChi());
            } else {
                JOptionPane.showMessageDialog(null, "Bạn không phải khách quen");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách quen");
        }
    }

    public void btnLayMaKHTiepTheoActionPerformed(ActionEvent arg0) {
        view.getTextMaKH().setText(String.valueOf(System.currentTimeMillis()).substring(4));
        view.getTextHoTen().setText("");
        view.getTextDiaChi().setText("");
    }

    public void btnThemRowActionPerformed(ActionEvent arg0) {
        int size = view.getTableModel().getmObjectList().size();

        if ((size > 0 && view.getTableModel().getValueAt(size - 1, 3).toString().trim().length() != 0) || size == 0) {
            ArrayList<String> data = new ArrayList<>();
            data.add(model.getAllSanPham().get(0).getTenSP());
            data.add("");
            data.add(model.getAllSanPham().get(0).getDonGiaBan() + "");
            data.add("");

            TableData tableData = new TableData(data);
            view.getTableModel().addObject(tableData);
        }
    }

    public void btnXoaRowActionPerformed(ActionEvent arg0) {
        if (view.getTable().getSelectedRow() >= 0) {
            view.getTableModel().removeObject(view.getTable().getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xóa");
        }
    }

    public void btnLuuVaoDbActionPerformed(ActionEvent arg0) {
        if (view.isAllTextFilled() == true && isTableEmpty() != true) {
            double finalMoney = calculateFinalMoney();
            view.getTextTongCong().setText(finalMoney + "");

            /*
             * insert NguoiiDTO, KhachHangDTO
             */
            String shortId = view.getTextMaKH().getText().toString().trim();
            NguoiDTO nguoi = model.kiemTraKhachQuen(Integer.valueOf(shortId));

            int maKH = 0;
            if (nguoi == null) {
                int nextNguoiId = model.getNextIdOfNguoi();
                maKH = model.getNextIdOfKhachHang();
                NguoiDTO nguoiDTO = new NguoiDTO(
                        nextNguoiId,
                        view.getTextHoTen().getText().toString().trim(),
                        view.getTextDiaChi().getText().toString().trim(),
                        Integer.valueOf(shortId)
                );

                KhachHangDTO khachHangDTO = new KhachHangDTO(maKH, nextNguoiId, false);

                model.insertKhachHang(nguoiDTO, khachHangDTO);
            } else {
                maKH = model.getMaKhById(Integer.valueOf(shortId));
            }

            /*
             *  insert P_ThuDTO
             */
            int nextIdPhieuThu = model.getNextIdOfPhieuThu();
            P_ThuDTO p_ThuDTO = new P_ThuDTO(
                    nextIdPhieuThu,
                    maKH,
                    new Timestamp(view.getDateNgayBan().getDate().getTime()),
                    new Timestamp(view.getDateNgayThanhToan().getDate().getTime()),
                    finalMoney);
            model.insertPhieuThu(p_ThuDTO);

            /*
             *  insert P_BanHangDTO
             */
            int nextIdPhieuBanHang = model.getNextIdOfPhieuBanHang();
            P_BanHangDTO p_BanHangDTO = new P_BanHangDTO(nextIdPhieuBanHang, nextIdPhieuThu);

            /*
             *  insert CTP_BanHangDTO
             */
            for (TableData data : view.getTableModel().getmObjectList()) {
                int maSP = 0;// được lấy lên từ Database 
                int soLuongTon = 0; // được lấy lên từ Database 
                String tenSP = data.getDataAt(0);

                for (SanPhamDTO sanPhamDTO : model.getAllSanPham()) {
                    if (tenSP.equals(sanPhamDTO.getTenSP())) {
                        maSP = sanPhamDTO.getMaSP();
                        soLuongTon = sanPhamDTO.getSoLuongTon();
                        break;
                    }
                }

                int soLuong = Integer.parseInt(data.getDataAt(1));
                if (soLuong <= soLuongTon) {
                    CTP_BanHangDTO ctp_BanHangDTO = new CTP_BanHangDTO(
                            model.getNextIdOfChiTietPhieuBanHang(),
                            nextIdPhieuBanHang,
                            maSP,
                            soLuong,
                            Double.parseDouble(data.getDataAt(3))
                    );
                    model.insertChiTietPhieuBanHang(ctp_BanHangDTO);

                    /*
                     *  update SoLuongTon của SanPham
                     */
                    soLuongTon -= soLuong;
                    if (model.updateSoLuongTonOfSanPham(soLuongTon, maSP)) {
                        JOptionPane.showMessageDialog(null, "Số lượng tồn đã được cập nhật");
                    } else {
                        JOptionPane.showConfirmDialog(null, "Số lượng tồn CHƯA được cập nhật");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Số lượng sản phẩm trong kho không đủ");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
        }
    }

    public void btnXoaActionPerformed(ActionEvent arg0) {
        view.getDateNgayBan().cleanup();
        view.getDateNgayThanhToan().cleanup();
        view.getTextMaKH().setText("");
        view.getTextHoTen().setText("");
        view.getTextDiaChi().setText("");
        view.getTextTongCong().setText("");
    }

    public void btnThoatActionPerformed(ActionEvent arg0) {
        view.setVisible(false);
        setParentVisiableTrue();
    }

    private boolean isTableEmpty() {
        for (int i = 0; i < view.getTable().getRowCount(); i++) {
            if (view.getTableModel().getValueAt(i, 3).toString().trim().length() == 0) {
                return true;
            }
        }

        return false;
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

        return true;
    }

    private double calculateFinalMoney() {
        double sum = 0;
        for (int i = 0; i < view.getTable().getRowCount(); i++) {
            sum += Double.parseDouble((String) view.getTableModel().getValueAt(i, 3));
        }
        return sum;
    }

    @Override
    public void setParent(Controller parent) {
        this.parent = parent;
    }

    @Override
    public void setParentVisiableFalse() {
        this.parent.setParentVisiableFalse();
    }

    @Override
    public void setParentVisiableTrue() {
        this.parent.setParentVisiableTrue();
    }
}
