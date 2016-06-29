package UnitTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import DTO.P_ChiDTO;
import DataAcessLayer.P_ChiDAO;

public class PhieuChiModelTest {
	P_ChiDAO p_ChiDAO;
	private P_ChiDTO p_ChiDTO;
	private Connection con;
	private Date date;
	
	@Before
	public void init(){
		p_ChiDAO = new P_ChiDAO();
		p_ChiDTO = new P_ChiDTO();
		p_ChiDTO.setMaP_Chi(124124);
		date = new Date();
		p_ChiDTO.setNgayChi(new Timestamp(date.getTime()));
		p_ChiDTO.setNoiDung("TEST STSTE");
		p_ChiDTO.setSoTienChi(2342343);
	}
	
	@Test
	public void testInsert() {
		assertTrue("Lỗi insert phiếu chi", p_ChiDAO.insert(p_ChiDTO));
		assertTrue("Lỗi insert phiếu chi", check(p_ChiDTO));
	}
	private boolean check(P_ChiDTO p_ChiDTO2) {
		try {
			con = p_ChiDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from p_chi where MAP_CHI= " + p_ChiDTO2.getMaP_Chi());
			if(rs.next()){
				if(rs.getInt("SOTIENCHI") == p_ChiDTO2.getSoTienChi())
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
