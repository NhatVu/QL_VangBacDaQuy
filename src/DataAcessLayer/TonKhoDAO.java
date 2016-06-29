/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.TonKhoDTO;

/**
 *
 * @author Administrator
 */
public class TonKhoDAO extends SuperDAO {
	// Properties of table
	private static final String maTonKho = "MAP_TK";
	private static final String ngayBaoCao = "NGAYBAOCAO";

	private static final String insertStatement = "{call TONKHO_Ins(?,?)}";
	private static final String updateStatement = "{call TONKHO_Upd(?,?,?,?)}";
	private static final String deleteStatement = "{call TONKHO_Del(?)}";

	// TAG
	private static final String TAG = TonKhoDAO.class.getSimpleName();

	public TonKhoDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(TonKhoDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(insertStatement);

			call.setInt(maTonKho, n.getMaP_TK());
			call.setTimestamp(ngayBaoCao, n.getNgayBaoCao());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean update(TonKhoDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(updateStatement);
			call.setInt(maTonKho, n.getMaP_TK());
			call.setTimestamp(ngayBaoCao, n.getNgayBaoCao());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean delete(TonKhoDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(deleteStatement);
			call.setInt(maTonKho, n.getMaP_TK());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	/*
	 * 1. Intent - Lấy dòng cuối cùng trong bảng tồn kho - lấy mã tồn kho và
	 * ngày báo cáo.
	 */
	public void getLastRow(TonKhoDTO tk) {
		try {
			this.getConnection();
			call = connection.prepareCall("call TonKho_getLastRow()");

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				tk.setMaP_TK(rs.getInt(1));
				tk.setNgayBaoCao(rs.getTimestamp(2));
			}

			if (tk.getMaP_TK() == 0) {
				tk.setMaP_TK(0);
			}
			if (tk.getNgayBaoCao() == null) {
				tk.setNgayBaoCao(new Timestamp(1432876790));
			}
		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	/*
	 * 1. Intent - Lấy mã sản phẩm + tồn cuối kỳ của tồn kho 2. Parameter
	 * Map<String, String> lResult. = Map<MaSP, TonCuoiKy>
	 */
	public void getMaSPTonCuoiKyByMaTK(int maTK, Map<Integer, Integer> lResult) {
		try {
			this.getConnection();
			call = connection
					.prepareCall("call TonKho_getMaSPTonCuoiKyByMaTK(?)");
			call.setInt(1, maTK);

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				lResult.put(rs.getInt(1), rs.getInt(2));
			}

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(TonKhoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}
}
