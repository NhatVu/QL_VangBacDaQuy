package MVCModels;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.mchange.v1.xmlprops.SaxXmlPropsParser;
import com.toedter.calendar.JDateChooser;

import DTO.CTP_BanHangDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_BanHangDTO;
import DTO.P_ThuDTO;
import DTO.SanPhamDTO;
import DataAcessLayer.CTP_BanHangDAO;
import DataAcessLayer.KhachHangDAO;
import DataAcessLayer.NguoiDAO;
import DataAcessLayer.P_BanHangDAO;
import DataAcessLayer.P_ThuDAO;
import DataAcessLayer.SanPhamDAO;

public class PhieuBanHangModel {
	
	private SanPhamDAO sanPhamDAO;
	private CTP_BanHangDAO ctp_BanHangDAO;
	private P_BanHangDAO p_BanHangDAO;
	private P_ThuDAO p_ThuDAO;
	private KhachHangDAO khachHangDAO;
	private NguoiDAO nguoiDAO;
	
	
	public PhieuBanHangModel() {
		super();
		sanPhamDAO = new SanPhamDAO();
		ctp_BanHangDAO = new CTP_BanHangDAO();
		p_BanHangDAO = new P_BanHangDAO();
		p_ThuDAO = new P_ThuDAO();
		khachHangDAO = new KhachHangDAO();
		nguoiDAO = new NguoiDAO();
	}


	public SanPhamDAO getSanPhamDAO() {
		return sanPhamDAO;
	}


	public void setSanPhamDAO(SanPhamDAO sanPhamDAO) {
		this.sanPhamDAO = sanPhamDAO;
	}


	public CTP_BanHangDAO getCtp_BanHangDAO() {
		return ctp_BanHangDAO;
	}


	public void setCtp_BanHangDAO(CTP_BanHangDAO ctp_BanHangDAO) {
		this.ctp_BanHangDAO = ctp_BanHangDAO;
	}


	public P_BanHangDAO getP_BanHangDAO() {
		return p_BanHangDAO;
	}


	public void setP_BanHangDAO(P_BanHangDAO p_BanHangDAO) {
		this.p_BanHangDAO = p_BanHangDAO;
	}


	public P_ThuDAO getP_ThuDAO() {
		return p_ThuDAO;
	}


	public void setP_ThuDAO(P_ThuDAO p_ThuDAO) {
		this.p_ThuDAO = p_ThuDAO;
	}


	public KhachHangDAO getKhachHangDAO() {
		return khachHangDAO;
	}


	public void setKhachHangDAO(KhachHangDAO khachHangDAO) {
		this.khachHangDAO = khachHangDAO;
	}


	public NguoiDAO getNguoiDAO() {
		return nguoiDAO;
	}


	public void setNguoiDAO(NguoiDAO nguoiDAO) {
		this.nguoiDAO = nguoiDAO;
	}
	
	public String getNextIdOfNguoi()
	{
		return nguoiDAO.getNexId();
	}
	
	public String getNextIdOfKhachHang()
	{
		return khachHangDAO.getNexId();
	}
	
	public String getNextIdOfP_Thu()
	{
		return p_ThuDAO.getNexId();
	}
	
	public String getNextIdOfP_BanHang()
	{
		return p_BanHangDAO.getNexId();
	}
	
	public String getNextIdOfCTP_BanHang()
	{
		return ctp_BanHangDAO.getNexId();
	}
	
	public NguoiDTO kiemtraKhachQuen(int shortId)
    {
        return khachHangDAO.checkKhachHangQuen(shortId);
    }
	
	public String getMaKhByName(int id)
    {
        return khachHangDAO.getMaKhachHangByName(id);
    }
	
	public List<String> getDanhSacMaSP()
	{
		return sanPhamDAO.getMaSP();
	}
	
	public List<Double> getDsDonGiaBanSP()
	{
		return sanPhamDAO.getDonGiaBan();
	}
	
	public List<Double> getDsDonGiaMuaSP()
	{
		return sanPhamDAO.getDonGiaMua();
	}
	
	public List<Integer> getDsSoLuongTonSP()
	{
		return sanPhamDAO.getSoLuongTon();
	}
	
	
	
	
	public void insertNguoi( NguoiDTO nguoiDTO )
	{
		nguoiDAO.insert(nguoiDTO);
	}

	public void insertKhachHang( KhachHangDTO khachHangDTO )
	{
		khachHangDAO.insert(khachHangDTO);
	}
	
	public void insertP_Thu( P_ThuDTO p_ThuDTO )
	{
		p_ThuDAO.insert(p_ThuDTO);
	}
	
	public void insertP_BanHang( P_BanHangDTO p_BanHangDTO )
	{
		p_BanHangDAO.insert(p_BanHangDTO);
	}
	
	public void insertCTP_BanHang( CTP_BanHangDTO ctp_BanHangDTO )
	{
		ctp_BanHangDAO.insert(ctp_BanHangDTO);
	}
	
}
