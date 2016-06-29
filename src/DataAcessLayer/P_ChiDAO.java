package DataAcessLayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.P_ChiDTO;

public class P_ChiDAO extends SuperDAO {

	public P_ChiDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(P_ChiDTO p_C) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_CHI_Ins(?,?,?,?)}");
			call.setInt("MAP_CHI", p_C.getMaP_Chi());
			call.setTimestamp("NGAYCHI", p_C.getNgayChi());
			call.setString("NOIDUNG", p_C.getNoiDung());
			call.setDouble("SOTIENCHI", p_C.getSoTienChi());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_ChiDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean update(P_ChiDTO p_C) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_CHI_Upd(?,?,?,?)}");
			call.setInt("MAP_CHI", p_C.getMaP_Chi());
			call.setTimestamp("NGAYCHI", p_C.getNgayChi());
			call.setString("NOIDUNG", p_C.getNoiDung());
			call.setDouble("SOTIENCHI", p_C.getSoTienChi());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_ChiDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean delete(P_ChiDTO p_C) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_CHI_Del(?)}");
			call.setInt("MAP_CHI", p_C.getMaP_Chi());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_ChiDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_Chi_getLastID(?)}");

			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_ChiDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;
	}
}
