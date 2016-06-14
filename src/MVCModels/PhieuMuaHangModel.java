package MVCModels;

import java.util.ArrayList;

import DTO.CTP_MuaHangDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_MuaHangDTO;
import DTO.SanPhamDTO;
import DataAcessLayer.CTP_MuaHangDAO;
import DataAcessLayer.KhachHangDAO;
import DataAcessLayer.NguoiDAO;
import DataAcessLayer.P_MuaHangDAO;
import DataAcessLayer.SanPhamDAO;

public class PhieuMuaHangModel {
	
	private NguoiDAO nguoiDAO;
	private KhachHangDAO khachHangDAO;
	private P_MuaHangDAO p_MuaHangDAO;
	private CTP_MuaHangDAO ctp_MuaHangDAO;
	private SanPhamDAO sanPhamDAO;
	
	public PhieuMuaHangModel()
	{
		nguoiDAO = new NguoiDAO();
		khachHangDAO = new KhachHangDAO();
		p_MuaHangDAO = new P_MuaHangDAO();
		ctp_MuaHangDAO = new CTP_MuaHangDAO();
		sanPhamDAO = new SanPhamDAO();
	}
	
	
	public String getNextIdOfNguoi()
	{
		return nguoiDAO.getNexId();
	}
	
	public String getNextIdOfKhacHang()
	{
		return khachHangDAO.getNexId();
	}
	
	public String getNextIdOfPhieuMuaHang()
	{
		return p_MuaHangDAO.getNexId();
	}
	
	public String getNextIdOfChiTietPhieuMuaHang()
	{
		return ctp_MuaHangDAO.getNexId();
	}
	
	public NguoiDTO kiemTraKhachQuen( int shortId )
	{
		return khachHangDAO.checkKhachHangQuen(shortId);
	}
	
	public ArrayList<SanPhamDTO> getAllSanPham()
	{	
		return sanPhamDAO.getAllSanPham();
	}
	
	public boolean updateSoLuongTonOfSanPham(int updateSoLuongTon, String maSP)
	{
		return sanPhamDAO.updateSLTSanPham(updateSoLuongTon, maSP);
	}
	
	public void insertKhachHang( NguoiDTO nguoiDTO, KhachHangDTO khachHangDTO )
	{
		nguoiDAO.insert(nguoiDTO);
		khachHangDAO.insert(khachHangDTO);
	}
	
	public void insertPhieuMuaHang( P_MuaHangDTO p_MuaHangDTO )
	{
		p_MuaHangDAO.insert(p_MuaHangDTO);
	}
	
	public void insertChiTietPhieuMuaHang( CTP_MuaHangDTO ctp_MuaHangDTO )
	{
		ctp_MuaHangDAO.insert(ctp_MuaHangDTO);
	}
	
	public String getMaKhById( int id )
	{
		return khachHangDAO.getMaKhachHangByName(id);
	}
}
