package DataAcessLayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.CTP_DichVuDTO;

public class CTP_DichVuDAO extends SuperDAO {

	/*
	 * CRUD
	 */
	public boolean insert(CTP_DichVuDTO ctp_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_Ins(?,?,?,?,?)}");

			call.setInt("MACTP_DV", ctp_DV.getMaCTP_DV());
			call.setInt("MAP_DV", ctp_DV.getMaP_DV());
			call.setInt("MADV", ctp_DV.getMaDV());
			call.setInt("SOLUONG", ctp_DV.getSoLuong());
			call.setDouble("THANHTIEN", ctp_DV.getThanhTien());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean update(CTP_DichVuDTO ctp_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_Ins(?,?,?,?,?)}");

			call.setInt("MACTP_DV", ctp_DV.getMaCTP_DV());
			call.setInt("MAP_DV", ctp_DV.getMaP_DV());
			call.setInt("MADV", ctp_DV.getMaDV());
			call.setInt("SOLUONG", ctp_DV.getSoLuong());
			call.setDouble("THANHTIEN", ctp_DV.getThanhTien());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean delete(CTP_DichVuDTO ctp_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_Del(?)}");
			call.setInt("MACTP_DV", ctp_DV.getMaCTP_DV());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(NguoiDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} // <editor-fold defaultstate="collapsed" desc="finally">
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
							null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
}
