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

import DTO.CT_TonKhoDTO;
import DTO.TonKhoDTO;
import DataAcessLayer.CT_TonKhoDAO;
import DataAcessLayer.TonKhoDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TonKhoModelTest {
    TonKhoDAO tkDAO = new TonKhoDAO();
    CT_TonKhoDAO ct_tkDAO = new CT_TonKhoDAO();
	private TonKhoDTO tk;
	private CT_TonKhoDTO ct_tk;
	private Date date;
	private Connection con;
	
	@Before
	public void init(){
		prepareInsertTK();
		prepareInsertCTTK();
	}
	
	private void prepareInsertCTTK() {
		ct_tk = new CT_TonKhoDTO();
		ct_tk.setMaCTP_TK(2424);
		ct_tk.setMaHang(1);
		ct_tk.setMaP_TK(tk.getMaP_TK());
		ct_tk.setSoLuongBan(1331);
		ct_tk.setSoLuongMua(2323);
		ct_tk.setTonCuoiKy(3431);
		ct_tk.setTonDauKy(2343);
	}

	private void prepareInsertTK() {
		tk = new TonKhoDTO();
		tk.setMaP_TK(33625);
		date = new Date();
		tk.setNgayBaoCao(new Timestamp(date.getTime()));
	}

	@Test
	public void test1InsertTonKho() {
		assertTrue("Lỗi insert phiếu tồn kho",tkDAO.insert(tk));
		assertTrue("Lỗi insert phiếu tồn kho",check(tk));
	}

	private boolean check(TonKhoDTO tk2) {
		try {
			con = tkDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from tonkho where MAP_TK= " + tk2.getMaP_TK());
			if(rs.next()){
				Timestamp t = rs.getTimestamp("NGAYBAOCAO");
				if(t.getMinutes() == tk2.getNgayBaoCao().getMinutes())
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
	public void test2InsertCT_TonKho() {
		assertTrue("Lỗi insert chi tiết phiếu tồn kho", ct_tkDAO.insert(ct_tk));
		assertTrue("Lỗi insert chi tiết phiếu tồn kho", check(ct_tk));
	}

	private boolean check(CT_TonKhoDTO ct_tk2) {
		try {
			con = ct_tkDAO.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from ct_tonkho where MACTP_TK= " + ct_tk2.getMaCTP_TK());
			if(rs.next()){
				if(rs.getInt("TONDAUKY") == ct_tk2.getTonDauKy())
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
