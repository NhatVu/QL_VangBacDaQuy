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

import DTO.CTP_MuaHangDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_MuaHangDTO;
import DTO.SanPhamDTO;
import MVCModels.PhieuMuaHangModel;
import MVCViews.PhieuMuaHangView;

import java.awt.event.WindowEvent;

import main.CheckInput;
import table.TableData;

public class PhieuMuaHangController implements Controller {

    private PhieuMuaHangModel model = new PhieuMuaHangModel();
    private PhieuMuaHangView view = null;
    private Controller parent;

    private String[] dsTenSanPham;
    private double donGiaMua = 0;

    double finalMoney = 0;

    public void start() {
        view = new PhieuMuaHangView(this);
        view.setVisible(true);
        createAutoView();
        btnThemRowActionPerformed(null); // tự tạo dòng đầu tiên trong JTable khi Phiếu Mua Hàng được mở lên
        setParentVisiableFalse();
    }

    private void createAutoView() {
        // TODO Auto-generated method stub
        dsTenSanPham = new String[model.getAllSanPham().size()];
        for (int i = 0; i < model.getAllSanPham().size(); i++) {
            dsTenSanPham[i] = model.getAllSanPham().get(i).getTenSP();
        }

        /*
         *  tạo comboBox tên sản phẩm  cho cột Tên Sản Phẩm
         */
        JComboBox<String> comboTenSanPham = new JComboBox<String>(dsTenSanPham);
        view.getTable().getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboTenSanPham));
        view.getTable().putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        comboTenSanPham.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JComboBox<?> cb = (JComboBox<?>) arg0.getSource();
                String tenSanPham = (String) cb.getSelectedItem();

                /*
                 * 	- Kiểm tra tenSanPham trong Database
                 * 	- Tính giá trị của Thành Tiền
                 */
                for (int i = 0; i < model.getAllSanPham().size(); i++) {
                    if (tenSanPham.equals(model.getAllSanPham().get(i).getTenSP())) {
                        donGiaMua = model.getAllSanPham().get(i).getDonGiaMua();
                        break;
                    }
                }
                int selectedRow = view.getTable().getSelectedRow();
                if (selectedRow >= 0) {
                    view.getTableModel().setValueAt(donGiaMua + "", selectedRow, 2);
                    if (view.getTableModel().getValueAt(selectedRow, 1).toString().trim().length() != 0) {
                        int soLuongNhap = Integer.valueOf(view.getTableModel().getmObjectList().get(selectedRow).getDataAt(1).trim());
                        view.getTableModel().setValueAt(donGiaMua * soLuongNhap + "", selectedRow, 3);
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
            public void removeUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                warn();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                // TODO Auto-generated method stub
                warn();
            }

            private void warn() {
                // TODO Auto-generated method stub
                if (Integer.parseInt(textField.getText().toString().trim()) > 0
                        && isInteger(textField.getText().toString().trim())) {
                    view.getTableModel().setValueAt(donGiaMua * Integer.parseInt(textField.getText().toString().trim()) + "", view.getTable().getSelectedRow(), 3);

                    /*
                     *  cập nhật giá trị của Tổng Tiền
                     */
                    if (view.getTable().getRowCount() >= 1) {
                        finalMoney = calculateFinalMoney();
                        view.getTextTongCong().setText(finalMoney + "");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại Số Lượng ( kiểu số, lớn hơn 0 )");
                }
            }
        });

        view.getTextMaPhieu().setText(String.valueOf(model.getNextIdOfPhieuMuaHang()));
        view.getTextMaPhieu().setEditable(false);
        view.getDateNgayMua().setDate(getCurrentDate());

    }

    private Date getCurrentDate() {
        // TODO Auto-generated method stub
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
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

    private boolean isTableEmpty() {
        // TODO Auto-generated method stub
        for (int i = 0; i < view.getTable().getRowCount(); i++) {
            if (view.getTableModel().getValueAt(i, 3).toString().trim().length() == 0) {
                return true;
            }
        }

        return false;
    }

    private double calculateFinalMoney() {
        double sum = 0;
        for (int i = 0; i < view.getTable().getRowCount(); i++) {
            sum += Double.parseDouble((String) view.getTableModel().getValueAt(i, 3));
        }
        return sum;
    }

    /*
     *  Xử lý sự kiện
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

    public void btnLayMaKHTiepTheoActionPerform(ActionEvent arg0) {
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
            data.add(model.getAllSanPham().get(0).getDonGiaMua() + "");
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
        if (view.isAllTextFilled() == true && isTableEmpty() != true
                && CheckInput.isStringMax50(view.getTextMaKH().getText())
                && CheckInput.isStringMax50(view.getTextHoTen().getText())
                && CheckInput.isStringMax300(view.getTextDiaChi().getText())) {

            if (view.getDateNgayMua().getDate().getTime()> view.getDateNgayThanhToan().getDate().getTime()) {
                JOptionPane.showMessageDialog(null, "Ngày thanh toán không thể trước ngày mua !");
            } else if (!isInteger(view.getTextMaKH().getText())) {
                JOptionPane.showMessageDialog(null, "Mã khách hàng phải có định dạng số !");
            } else {

//        		double finalMoney = calculateFinalMoney();
//                view.getTextTongCong().setText(finalMoney + "");

                /*
                 * insert NguoiiDTO, KhachHangDTO
                 */
                String shortId = view.getTextMaKH().getText().toString().trim();
                NguoiDTO nguoi = model.kiemTraKhachQuen(Integer.valueOf(shortId));

                int maKH = 0;
                if (nguoi == null) {
                    int nextNguoiId = model.getNextIdOfNguoi();
                    maKH = model.getNextIdOfKhacHang();
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
                 * 	insert P_MuaHangDTO
                 */
                int nextIdPhieuMuaHang = model.getNextIdOfChiTietPhieuMuaHang();
                P_MuaHangDTO p_MuaHangDTO = new P_MuaHangDTO(
                        nextIdPhieuMuaHang,
                        maKH,
                        new Timestamp(view.getDateNgayMua().getDate().getTime()),
                        new Timestamp(view.getDateNgayThanhToan().getDate().getTime()),
                        finalMoney);
                model.insertPhieuMuaHang(p_MuaHangDTO);

                /*
                 * 	insert CTP_MuaHangDTO
                 */
                for (TableData data : view.getTableModel().getmObjectList()) {
                    int maSP = 0; // được lấy lên từ Database 
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

                    CTP_MuaHangDTO ctp_MuaHangDTO = new CTP_MuaHangDTO(
                            model.getNextIdOfChiTietPhieuMuaHang(),
                            nextIdPhieuMuaHang,
                            maSP,
                            soLuong,
                            Double.parseDouble(data.getDataAt(3)));
                    model.insertChiTietPhieuMuaHang(ctp_MuaHangDTO);

                    /*
                     *  update SoLuongTon của SanPham
                     */
                    soLuongTon += soLuong;
                    model.updateSoLuongTonOfSanPham(soLuongTon, maSP);
                }

                JOptionPane.showMessageDialog(null, "Lưu thành công !");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra thông tin !");
        }

    }

    public void btnXoaActionPerformed(ActionEvent arg0) {
        view.getDateNgayMua().cleanup();
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

    @Override
    public void setParent(Controller parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    @Override
    public void setParentVisiableFalse() {
        this.parent.setParentVisiableFalse();
    }

    @Override
    public void setParentVisiableTrue() {
        this.parent.setParentVisiableTrue();
    }

    @Override
    public void addChild(Controller child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dipose() {
        view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING));
    }
}
