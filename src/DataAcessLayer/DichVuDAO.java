/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.DichVuDTO;

/**
 *
 * @author Minh Nhat
 */
public class DichVuDAO extends SuperDAO {
	private String TAG = DichVuDAO.class.getSimpleName();

	/*
	 * CRUD
	 */
	public boolean insert(DichVuDTO dv) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call DICHVU_Ins(?,?,?)}");
			call.setInt("MADV", dv.getMaDV());
			call.setString("TENDV", dv.getTenDV());
			call.setDouble("DONGIA", dv.getDonGia());

			return call.execute();

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
		}
		return false;
	}

	public boolean update(DichVuDTO dv) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call DICHVU_Upd(?,?,?)}");
			call.setInt("MADV", dv.getMaDV());
			call.setString("TENDV", dv.getTenDV());
			call.setDouble("DONGIA", dv.getDonGia());

			return call.execute();

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
		}
		return false;
	}

	public boolean delete(DichVuDTO dv) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call DICHVU_Del(?)}");
			call.setInt("MADV", dv.getMaDV());

			return call.execute();

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
		}
		return false;
	}

	public ArrayList<DichVuDTO> getAllDichVu() {
		try {
			this.getConnection();
			ArrayList<DichVuDTO> result = new ArrayList<DichVuDTO>();
			String query = "SELECT * FROM DICHVU";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int maGC = rs.getInt("MADV");
				String tenGC = rs.getString("TENDV");
				double dongia = Double.parseDouble(rs.getString("DONGIA"));
				DichVuDTO dv = new DichVuDTO(maGC, tenGC, dongia);
				result.add(dv);
			}
			st.close();
			return result;
		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
		}
		return null;
	}
}
