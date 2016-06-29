package DataAcessLayer;

import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.CT_TonKhoDTO;

public class CT_TonKhoDAO extends SuperDAO {

	/*
	 * CRUD
	 */
	public boolean insert(CT_TonKhoDTO ct_TK) {
		try {
			this.getConnection();
			call = connection
					.prepareCall("{call CT_TONKHO_Ins(?,?,?,?,?,?,?)}");
			call.setInt("MACTP_TK", ct_TK.getMaCTP_TK());
			call.setInt("MAP_TK", ct_TK.getMaP_TK());
			call.setInt("MAHANG", ct_TK.getMaHang());
			call.setInt("TONDAUKY", ct_TK.getTonDauKy());
			call.setInt("TONCUOIKY", ct_TK.getTonCuoiKy());
			call.setInt("SOLUONGBAN", ct_TK.getSoLuongBan());
			call.setInt("SOLUONGMUA", ct_TK.getSoLuongMua());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return false;
	}

	public boolean update(CT_TonKhoDTO ct_TK) {
		try {
			this.getConnection();
			call = connection
					.prepareCall("{call CT_TONKHO_Upd(?,?,?,?,?,?,?)}");

			call.setInt("MACTP_TK", ct_TK.getMaCTP_TK());
			call.setInt("MAP_TK", ct_TK.getMaP_TK());
			call.setInt("MAHANG", ct_TK.getMaHang());
			call.setInt("TONDAUKY", ct_TK.getTonDauKy());
			call.setInt("TONCUOIKY", ct_TK.getTonDauKy());
			call.setInt("SOLUONGBAN", ct_TK.getSoLuongBan());
			call.setInt("SOLUONFMUA", ct_TK.getSoLuongMua());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return false;
	}

	public boolean delete(CT_TonKhoDTO ct_TK) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CT_TONKHO_Del(?)}");
			call.setInt("MACTP_TK", ct_TK.getMaCTP_TK());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return false;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CT_TonKho_getLastID(?)}");
			call.registerOutParameter(1, Types.INTEGER);
			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(CT_TonKhoDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
}
