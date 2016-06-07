package MVCControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.sql.Timestamp;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.ietf.jgss.Oid;

import DTO.CTP_BanHangDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_BanHangDTO;
import DTO.P_ThuDTO;
import DTO.SanPhamDTO;
import MVCModels.PhieuBanHangModel;
import MVCViews.PhieuBanHangView;
import TableModel.CTP_BanHangJTable;

public class PhieuBanHangController
{
	private PhieuBanHangModel model = null;
	private PhieuBanHangView view = null;
	
	
	public PhieuBanHangController() {
		super();
		model = new PhieuBanHangModel();
	}
	
	public void startApplication()
	{
		view = new PhieuBanHangView(this);
		view.getFrame().setVisible(true);
	}
	

	public void btnCheckKhachQuenActionPerformed( ActionEvent arg0 )
	{
		JOptionPane.showMessageDialog(null, "Nut check duoc nhan");
		String s = view.getTextMaKH().getText().toString().trim();
        if(s.length()!=0)
        {
            NguoiDTO nguoi= model.kiemtraKhachQuen(Integer.valueOf(s));
            if(nguoi!=null)
            {
                view.getTextHoTen().setText(nguoi.getHoTen());
                view.getTextDiaChi().setText(nguoi.getDiaChi());
            }else
            {
                JOptionPane.showMessageDialog(null,"Bạn không phải khách quen");
            }
        }
        else
        {
        	JOptionPane.showMessageDialog(null,"Xin nhập mã khách quen");
        }
	}
	
	public void btnLayMaKHTiepTheoActionPerformed( ActionEvent arg0 )
	{
		view.getTextMaKH().setText(String.valueOf(System.currentTimeMillis()).substring(4));
        view.getTextHoTen().setText("");
        view.getTextDiaChi().setText("");
	}
	
	public void btnThemRowActionPerformed( ActionEvent arg0 )
	{
		CTP_BanHangJTable ctp_BanHangJTable = new CTP_BanHangJTable();
		ctp_BanHangJTable.setTenSanPham("");
		ctp_BanHangJTable.setSoLuong(0);
		ctp_BanHangJTable.setDonGia(0);
		ctp_BanHangJTable.setThanhTien(0);
		
		this.view.getCt_PhieuBanHangTableModel().addObject(ctp_BanHangJTable);
	}
	
	public void btnXoaRowActionPerformed(ActionEvent arg0)
	{
		if( view.getTableCTP_MH().getSelectedRow() >= 0 )
		{
			view.getCt_PhieuBanHangTableModel().removeObject(view.getTableCTP_MH().getSelectedRow());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Vui lòng xóa dòng trong danh sách !");
		}
			
	}
	
	public void btnLuuVaoDbActionPerformed( ActionEvent arg0 )
	{
		if(this.isTableEmpty()!=true && view.isAllTextFilled()==true)
		{
			
			String shortId = view.getTextMaKH().getText().toString().trim();
            NguoiDTO nguoi= model.kiemtraKhachQuen(Integer.valueOf(shortId));
            String maKH = "";
            if ( nguoi ==null )
            {
            	/*
    			 * insert NguoiDTO
    			 * + MaNguoi, HoTen, DiaChi, shortID
    			 */
    			NguoiDTO nguoiDTO = new NguoiDTO();
    			String maNguoi = model.getNextIdOfNguoi();
    			nguoiDTO.setMaLoaiNguoi( maNguoi );
    			nguoiDTO.setHoTen(view.getTextHoTen().getText());
    			nguoiDTO.setDiaChi(view.getTextDiaChi().getText());
    			nguoiDTO.setShortID( Integer.parseInt( view.getTextMaKH().getText() ));
    			model.insertNguoi(nguoiDTO);
    			
    			/*
    			 * insert KhachHang
    			 * + MaKH, MaNguoi, LaKhachQuen
    			 */
    			maKH = model.getNextIdOfKhachHang();
    			KhachHangDTO khachHangDTO = new KhachHangDTO(
    					maKH,
    					maNguoi,
    					false );
    			model.insertKhachHang(khachHangDTO);
            }
            else
            {
            	maKH = model.getMaKhByName( Integer.parseInt(shortId) );
            }
			
			
			/*
			 * insert P_ThuDTO
			 * + MaP_Thu, MaKH, NgayLapPhieu, NgayKetThuc, TongCong
			 */
			String maP_Thu = model.getNextIdOfP_Thu();
			Double totalMoney = calculateTotalMoney();
			P_ThuDTO p_ThuDTO = new P_ThuDTO();
			p_ThuDTO.setMaP_Thu(maP_Thu);
			p_ThuDTO.setMaKH(maKH);
			p_ThuDTO.setNgayLapPhieu( new Timestamp(view.getDateNgayBan().getDate().getTime()) );
			p_ThuDTO.setNgayKetThuc( new Timestamp(view.getDateNgayThanhToan().getDate().getTime()) );
			p_ThuDTO.setTongCong( totalMoney );
			model.insertP_Thu(p_ThuDTO);
			
			/*
			 * insert P_BanHangDTO
			 * + MaP_BH, MaP_Thu
			 */
			String maP_BanHang = model.getNextIdOfP_BanHang(); 
			P_BanHangDTO p_BanHangDTO = new P_BanHangDTO();
			p_BanHangDTO.setMaP_BH(maP_BanHang); // giờ muốn cho nó Tự Động Hiển Thị khi mở Form
			p_BanHangDTO.setMaP_Thu(maP_Thu);
			model.insertP_BanHang(p_BanHangDTO);
			
			/*
			 * retrieve MaSP from CSDL, and insert CTP_BanHang
			 */
			
			for( int i = 0; i < model.getDanhSacMaSP().size(); i++ )		
			{
				String maSP = model.getDanhSacMaSP().get(i);
				CTP_BanHangDTO ctp_BanHangDTO = new CTP_BanHangDTO();
				ctp_BanHangDTO.setMaCTP_BH( model.getNextIdOfCTP_BanHang() );
				ctp_BanHangDTO.setMaP_BH(maP_BanHang);
				ctp_BanHangDTO.setMaSP(maSP);
				
				int soLuong = Integer.parseInt(view.getTableCTP_MH().getValueAt(i, 2).toString() );
				ctp_BanHangDTO.setSoLuong(soLuong);
				ctp_BanHangDTO.setThanhTien(Double.parseDouble( view.getTableCTP_MH().getValueAt(i, 4).toString() ));
				model.insertCTP_BanHang(ctp_BanHangDTO);
			}	
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !");
		}
	}
	
	private Double calculateTotalMoney() {
		// TODO Auto-generated method stub
		
		Double sum = 0.0;
		for( int i = 0; i < view.getTableCTP_MH().getRowCount(); i++ )
		{
			sum += Double.parseDouble( (String)view.getTableCTP_MH().getValueAt(i, 4) );
		}
		
		return sum;
	}

	private boolean isTableEmpty()
    {
        for(int i = 0; i < view.getTableCTP_MH().getRowCount(); i++)
        {
            if(view.getTableCTP_MH().getValueAt(i, 4).toString().trim().length()==0)
                return true;
        }
        return false;
    }
	
	
	public void btnXoaKhoiDbActionPerformed( ActionEvent arg0 )
	{
		view.getDateNgayBan().cleanup();
		view.getDateNgayThanhToan().cleanup();
		view.getTextMaKH().setText("");
		view.getTextHoTen().setText("");
		view.getTextDiaChi().setText("");
		view.getTextTongCong().setText("");
	}
	
	public void btnThoatActionPerformed( ActionEvent arg0 )
	{
		view.getFrame().setVisible(false);
	}
}
