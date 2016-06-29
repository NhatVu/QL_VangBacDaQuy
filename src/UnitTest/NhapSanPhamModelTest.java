package UnitTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DTO.SanPhamDTO;
import DataAcessLayer.SanPhamDAO;

public class NhapSanPhamModelTest {

	SanPhamDAO dao;
	SanPhamDTO dto;
	Connection con;
	
	@Before
	public void init(){
		dao = new SanPhamDAO();
		con = dao.getConnection();
		dto = new SanPhamDTO();
		dto.setDonGiaBan(133413);
		dto.setDonGiaMua(3313);
		dto.setMaSP(13413);
		dto.setSoLuongTon(2331);
		dto.setTenSP("TEST");
	}
	
	@Test
	public void testInsert() {
		assertTrue("Lỗi không thể insert sản phẩm",dao.insert(dto));
		assertTrue("Lỗi insert sản phẩm không thành công", check(dto));
	}

	@Test
	public void testUpdate() {
		dto.setSoLuongTon(3413);
		assertTrue("Lỗi không thể update sản phẩm",dao.update(dto));
		assertTrue("Lỗi update sản phẩm không thành công", check(dto));
	}

	
	private boolean check(SanPhamDTO dto2){		
		try {
			ResultSet rs = con.createStatement().executeQuery("select * from sanpham where MASP = " + dto2.getMaSP());
			if(rs.next()){
				if(rs.getInt("SOLUONGTON") == dto2.getSoLuongTon())
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
