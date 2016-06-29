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

import DTO.CTP_GiaCongDTO;
import DTO.P_GiaCongDTO;
import DataAcessLayer.CTP_GiaCongDAO;
import DataAcessLayer.P_GiaCongDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhieuGiaCongModelTest {
	private P_GiaCongDAO mPhieuGiaCong;
    private CTP_GiaCongDAO mCTPGiaCong;
	private P_GiaCongDTO pGiaCong;
	private CTP_GiaCongDTO ctp;
	private Date date;
	private Connection con;
	
	@Before
	public void init(){
		prepareInsertPGC();
		prepareInsertCTPGC();
	}
	
	private void prepareInsertCTPGC() {
		mCTPGiaCong = new CTP_GiaCongDAO();
		ctp = new CTP_GiaCongDTO();
		ctp.setMaCTP_GC(1241);
		ctp.setMaLoaiGC(1);
		ctp.setMaP_GC(pGiaCong.getMaP_GC());
		ctp.setSoLuong(13513);
		ctp.setThanhTien(3513513);
	}

	private void prepareInsertPGC() {
		mPhieuGiaCong = new P_GiaCongDAO();
		pGiaCong = new P_GiaCongDTO();
		pGiaCong.setMaP_GC(1451);
		pGiaCong.setMaThoGC(1);
		date = new Date();
		pGiaCong.setNgayNhanHang(new Timestamp(date.getTime()));
		pGiaCong.setNgayThanhToan(new Timestamp(date.getTime()));
		pGiaCong.setTongCong(313513);
	}

	@Test
	public void test1InsertP_GiaCong() {
		assertTrue("Lỗi insert phiếu gia công", mPhieuGiaCong.insert(pGiaCong));
		assertTrue("Lỗi insert phiếu gia công", check(pGiaCong));
	}

	private boolean check(P_GiaCongDTO pGiaCong2) {
		try {
			con = mPhieuGiaCong.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from p_giacong where MAP_GC= " + pGiaCong2.getMaP_GC());
			if(rs.next()){
				if(rs.getInt("TONGCONG") == pGiaCong2.getTongCong())
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
	public void test2InsertCTP_GiaCong() {
		assertTrue("Lỗi insert chi tiết phiếu gia công", mCTPGiaCong.insert(ctp));
		assertTrue("Lỗi insert chi tiết phiếu gia công", check(ctp));
	}

	private boolean check(CTP_GiaCongDTO ctp2) {
		try {
			con = mPhieuGiaCong.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from ctp_giacong where MACTP_GC= " + ctp2.getMaCTP_GC());
			if(rs.next()){
				if(rs.getInt("SOLUONG") == ctp2.getSoLuong())
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
