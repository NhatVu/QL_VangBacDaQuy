package UnitTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import DTO.CTP_BanHangDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import DTO.P_BanHangDTO;
import DTO.P_ThuDTO;
import DataAcessLayer.CTP_BanHangDAO;
import DataAcessLayer.KhachHangDAO;
import DataAcessLayer.NguoiDAO;
import DataAcessLayer.P_BanHangDAO;
import DataAcessLayer.P_ThuDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhieuBanHangModelTest {

	private NguoiDAO nguoiDAO;
	private KhachHangDAO khachHangDAO;
	private P_ThuDAO p_ThuDAO;
	private P_BanHangDAO p_BanHangDAO;
	private CTP_BanHangDAO ctp_BanHangDAO;
	private NguoiDTO nguoiDTO;
	private KhachHangDTO khachHangDTO;
	private Connection con;
	private P_ThuDTO p_ThuDTO;
	private Date date;
	private P_BanHangDTO p_BanHangDTO;
	private CTP_BanHangDTO ctp_BanHangDTO;
	
	@Before
	public void init(){
		prepareInsertKhachHang();
		prepareInsertPhieuThu();
		prepareInsertPhieuBan();
		prepareInsertCTPhieuBan();
	}
	
	private void prepareInsertCTPhieuBan() {
		ctp_BanHangDAO = new CTP_BanHangDAO();
		ctp_BanHangDTO = new CTP_BanHangDTO();
		ctp_BanHangDTO.setMaCTP_BH(12414);
		ctp_BanHangDTO.setMaP_BH(p_BanHangDTO.getMaP_BH());
		ctp_BanHangDTO.setMaSP(1);
		ctp_BanHangDTO.setSoLuong(243413);
		ctp_BanHangDTO.setThanhTien(1413413);
	}

	private void prepareInsertPhieuBan() {
		p_BanHangDAO = new P_BanHangDAO();
		p_BanHangDTO = new P_BanHangDTO();
		p_BanHangDTO.setMaP_BH(1341341);
		p_BanHangDTO.setMaP_Thu(p_ThuDTO.getMaP_Thu());
	}

	private void prepareInsertPhieuThu() {
		p_ThuDAO = new P_ThuDAO();		
		p_ThuDTO = new P_ThuDTO();
		p_ThuDTO.setMaKH(khachHangDTO.getMaKH());
		p_ThuDTO.setMaP_Thu(13413);
		date = new Date();
		p_ThuDTO.setNgayKetThuc(new Timestamp(date.getTime()));
	}

	private void prepareInsertKhachHang() {
		nguoiDAO = new NguoiDAO();		
		nguoiDTO = new NguoiDTO();
		nguoiDTO.setDiaChi("TESST ST");
		nguoiDTO.setHoTen("TESTING");
		nguoiDTO.setMaLoaiNguoi(13413);
		nguoiDTO.setShortID(23352442);
		
		khachHangDAO = new KhachHangDAO();
		khachHangDTO = new KhachHangDTO(1341341, nguoiDTO.getMaLoaiNguoi(), true);
	}

	@Test
	public void test1InsertKhachHang() {
		assertTrue("Lỗi insert người không thành công", nguoiDAO.insert(nguoiDTO));
		assertTrue("Lỗi insert người không thành công", check(nguoiDTO));
		
		assertTrue("Lỗi insert khách hàng", khachHangDAO.insert(khachHangDTO));
		assertTrue("Lỗi insert người không thành công", check(khachHangDTO));
	}

	private boolean check(KhachHangDTO khachHangDTO2) {
		try {
			con = khachHangDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from khachhang where MAKH= " + khachHangDTO2.getMaKH());
			if(rs.next()){
				if(rs.getInt("MANGUOI") == khachHangDTO2.getMaNguoi() && rs.getBoolean("LAKHACHQUEN") == khachHangDTO2.isLaKhachQuen())
					return true;
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean check(NguoiDTO nguoiDTO2) {
		try {
			con = nguoiDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from nguoi where MANGUOI = " + nguoiDTO2.getMaLoaiNguoi());
			if(rs.next()){
				if(rs.getString("HOTEN").equals(nguoiDTO2.getHoTen()))
					return true;
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Test
	public void test2InsertPhieuThu() {
		assertTrue("Lỗi insert phiếu thu", p_ThuDAO.insert(p_ThuDTO));
		assertTrue("Lỗi insert phiếu thu", check(p_ThuDTO));
	}

	private boolean check(P_ThuDTO p_ThuDTO2) {
		try {
			con = p_ThuDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from p_thu where MAP_THU= " + p_ThuDTO2.getMaP_Thu());
			if(rs.next()){
				if(rs.getInt("MAKH") == p_ThuDTO2.getMaKH())
					return true;
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Test
	public void test3InsertPhieuBanHang() {
		assertTrue("Lỗi insert phiếu bán hàng", p_BanHangDAO.insert(p_BanHangDTO));
		assertTrue("Lỗi insert phiếu bán hàng", check(p_BanHangDTO));
	}

	private boolean check(P_BanHangDTO p_BanHangDTO2) {
		try {
			con = p_BanHangDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from p_banhang where MAP_BH= " + p_BanHangDTO2.getMaP_BH());
			if(rs.next()){
				if(rs.getInt("MAP_THU") == p_BanHangDTO2.getMaP_Thu())
					return true;
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Test
	public void test4InsertChiTietPhieuBanHang() {
		assertTrue("Lỗi insert chi tiết phiếu bán hàng", ctp_BanHangDAO.insert(ctp_BanHangDTO));
		assertTrue("Lỗi insert chi tiết phiếu bán hàng", check(ctp_BanHangDTO));
	}

	private boolean check(CTP_BanHangDTO ctp_BanHangDTO2) {
		try {
			con = ctp_BanHangDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from ctp_banhang where MACTP_BH= " + ctp_BanHangDTO2.getMaCTP_BH());
			if(rs.next()){
				if(rs.getInt("THANHTIEN") == ctp_BanHangDTO2.getThanhTien())
					return true;
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
