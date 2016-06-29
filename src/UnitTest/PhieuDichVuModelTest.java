package UnitTest;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import DTO.CTP_DichVuDTO;
import DTO.P_DichVuDTO;
import DataAcessLayer.CTP_DichVuDAO;
import DataAcessLayer.P_DichVuDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhieuDichVuModelTest {
	private CTP_DichVuDAO mCTPDV;
	private P_DichVuDAO mPhieuDichVuDAO;
	private CTP_DichVuDTO ctp_DV;
	private P_DichVuDTO p_DV;
	private Connection con;

	@Before
	public void init(){
		prepareInsertPDV();
		prepareInsertCTPDV();		
	}
	
	private void prepareInsertPDV() {
		mPhieuDichVuDAO = new P_DichVuDAO();
		p_DV = new P_DichVuDTO();
		p_DV.setMaP_DV(13413);
		p_DV.setMaP_Thu(13413);
	}

	private void prepareInsertCTPDV() {
		mCTPDV = new CTP_DichVuDAO();
		ctp_DV = new CTP_DichVuDTO();
		ctp_DV.setMaCTP_DV(14143);
		ctp_DV.setMaDV(1);
		ctp_DV.setMaP_DV(p_DV.getMaP_DV());
		ctp_DV.setSoLuong(3434);
		ctp_DV.setThanhTien(1413413);
	}

	@Test
	public void test2InsertCTPDichVu() {
		assertTrue("Lỗi insert chi tiết phiếu dịch vụ", mCTPDV.insert(ctp_DV));
		assertTrue("Lỗi insert chi tiết phiếu dịch vụ", check(ctp_DV));
	}

	private boolean check(CTP_DichVuDTO ctp_DV2) {
		try {
			con = mCTPDV.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from ctp_dichvu where MACTP_DV= " + ctp_DV2.getMaCTP_DV());
			if(rs.next()){
				if(rs.getInt("MAP_DV") == p_DV.getMaP_DV())
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
	public void test1InsertP_DichVu() {
		assertTrue("Lỗi insert phiếu dịch vụ", mPhieuDichVuDAO.insert(p_DV));
		assertTrue("Lỗi insert phiếu dịch vụ", check(p_DV));
	}

	private boolean check(P_DichVuDTO p_DV2) {
		try {
			con = mPhieuDichVuDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from p_dichvu where MAP_DV= " + p_DV2.getMaP_DV());
			if(rs.next()){
				if(rs.getInt("MAP_THU") == p_DV.getMaP_Thu())
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
