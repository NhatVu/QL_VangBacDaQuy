package UnitTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import DTO.P_NoDTO;
import DataAcessLayer.P_NoDAO;

public class PhieuNoModelTest {
	P_NoDAO mP_NoDAO;
	private P_NoDTO noDTO;
	private Connection con;
	private Date date;
	
	@Before
	public void init(){
		mP_NoDAO = new P_NoDAO();
		noDTO = new P_NoDTO();
		noDTO.setMaP_No(14134);
		noDTO.setMaP_Thu(1);
		date = new Date();
		noDTO.setNgayNo(new Timestamp(date.getTime()));
		noDTO.setNgayTra(new Timestamp(date.getTime()));
		noDTO.setSoTienNo(3413413);
		noDTO.setSoTienTra(34133);
	}
	
	@Test
	public void testInsert() {
		assertTrue("Lỗi insert phiếu nợ", mP_NoDAO.insert(noDTO));
		assertTrue("Lỗi insert phiếu nợ", check(noDTO));
	}
	private boolean check(P_NoDTO noDTO2) {
		try {
			con = mP_NoDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from p_no where MAP_NO= " + noDTO2.getMaP_No());
			if(rs.next()){
				if(rs.getInt("SOTIENTRA") == noDTO2.getSoTienTra())
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
