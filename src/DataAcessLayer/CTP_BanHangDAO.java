/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.*;

/**
 *
 * @author Minh Nhat
 */
public class CTP_BanHangDAO extends SuperDAO {

	/*
	 * CRUD
	 */
	public boolean insert(CTP_BanHangDTO ctp_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_BANHANG_Ins(?,?,?,?,?)}");
			call.setInt("MACTP_BH", ctp_BH.getMaCTP_BH());
			call.setInt("MAP_BH", ctp_BH.getMaP_BH());
			call.setInt("MASP", ctp_BH.getMaSP());
			call.setInt("SOLUONG", ctp_BH.getSoLuong());
			call.setDouble("THANHTIEN", ctp_BH.getThanhTien());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean update(CTP_BanHangDTO ctp_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_BANHANG_Upd(?,?,?,?,?)}");
			call.setInt("MACTP_BH", ctp_BH.getMaCTP_BH());
			call.setInt("MAP_BH", ctp_BH.getMaP_BH());
			call.setInt("MASP", ctp_BH.getMaSP());
			call.setInt("SOLUONG", ctp_BH.getSoLuong());
			call.setDouble("THANHTIEN", ctp_BH.getThanhTien());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean delete(CTP_BanHangDTO ctp_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_BANHANG_Del(?)}");
			call.setInt("MACTP_BH", ctp_BH.getMaCTP_BH());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_BANHANG_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
}
