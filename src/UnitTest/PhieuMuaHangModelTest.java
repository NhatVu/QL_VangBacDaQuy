package UnitTest;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import DTO.CTP_MuaHangDTO;
import DTO.P_MuaHangDTO;
import DataAcessLayer.CTP_MuaHangDAO;
import DataAcessLayer.P_MuaHangDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhieuMuaHangModelTest {
	private P_MuaHangDAO p_MuaHangDAO;
	private CTP_MuaHangDAO ctp_MuaHangDAO;
	private P_MuaHangDTO p_MuaHangDTO;
	private CTP_MuaHangDTO ctp_MuaHangDTO;
	private Date date;
	private Connection con;
	
	@Before
	public void init(){
		prepareInsertPMH();
		prepareInsertCTPMH();
	}
	
	private void prepareInsertCTPMH() {
		ctp_MuaHangDAO = new CTP_MuaHangDAO();
		ctp_MuaHangDTO = new CTP_MuaHangDTO();
		ctp_MuaHangDTO.setMaCTP_MH(14134);
		ctp_MuaHangDTO.setMaP_MH(p_MuaHangDTO.getMaP_MH());
		ctp_MuaHangDTO.setMaSP(1);
		ctp_MuaHangDTO.setSoLuong(124134);
		ctp_MuaHangDTO.setThanhTien(1341353);
	}

	private void prepareInsertPMH() {
		p_MuaHangDAO = new P_MuaHangDAO();
		p_MuaHangDTO = new P_MuaHangDTO();
		p_MuaHangDTO.setMaKH(1);
		p_MuaHangDTO.setMaP_MH(34134);
		date = new Date();
		p_MuaHangDTO.setNgayMua(new Timestamp(date.getTime()));
		p_MuaHangDTO.setNgayThanhToan(new Timestamp(date.getTime()));
		p_MuaHangDTO.setTongCong(34341);
	}

	@Test
	public void test1InsertPhieuMuaHang() {
		assertTrue("Lỗi insert phiếu mua hàng", p_MuaHangDAO.insert(p_MuaHangDTO));
		assertTrue("Lỗi insert phiếu mua hàng", check(p_MuaHangDTO));
	}

	private boolean check(P_MuaHangDTO p_MuaHangDTO2) {
		try {
			con = ctp_MuaHangDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from p_muahang where MAP_MH= " + p_MuaHangDTO2.getMaP_MH());
			if(rs.next()){
				if(rs.getInt("TONGCONG") == p_MuaHangDTO2.getTongCong())
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
	public void test2InsertChiTietPhieuMuaHang() {
		assertTrue("Lỗi insert chi tiết phiếu mua hàng", ctp_MuaHangDAO.insert(ctp_MuaHangDTO));
		assertTrue("Lỗi insert chi tiết phiếu mua hàng", check(ctp_MuaHangDTO));
	}

	private boolean check(CTP_MuaHangDTO ctp_MuaHangDTO2) {
		try {
			con = ctp_MuaHangDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from ctp_muahang where MACTP_MH= " + ctp_MuaHangDTO2.getMaCTP_MH());
			if(rs.next()){
				if(rs.getInt("SOLUONG") == ctp_MuaHangDTO2.getSoLuong())
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
