/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Resource;

/**
 *
 * @author Administrator
 */
public class KhachHangDAO {

    CallableStatement call = null;
    Connection connection = null;

    //Properties of table
    private static final String maKh = "MAKH";
    private static final String maNguoi = "MANGUOI";
    private static final String laKhachQuen = "LAKHACHQUEN";

    private static final String insertStatement = "{call KHACHHANG_Ins(?,?,?)}";
    private static final String updateStatement = "{call KHACHHANG_Upd(?,?,?,?)}";
    private static final String deleteStatement = "{call KHACHHANG_Del(?)}";

    //TAG
    private static final String TAG = KhachHangDAO.class.getSimpleName();

    public KhachHangDAO() {

    }

    /*
     * CRUD
     */
    public boolean insert(KhachHangDTO n) {
        //create procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30) )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(insertStatement);

            call.setInt(maKh, n.getMaKH());
            call.setInt(maNguoi, n.getMaNguoi());
            call.setBoolean(laKhachQuen, n.isLaKhachQuen());

            return call.execute();

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
        }
        return false;
    }

    public boolean update(KhachHangDTO n) {
        try {
            // procedure DICHVU_Upd (MADV varchar(10), TENDV varchar(30) )
            connection = DataSource.getInstance().getConnection();

            call = connection.prepareCall(updateStatement);
            call.setInt(maKh, n.getMaKH());
            call.setInt(maNguoi, n.getMaNguoi());
            call.setBoolean(laKhachQuen, n.isLaKhachQuen());

            return call.execute();

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
        }
        return false;
    }

    public boolean delete(KhachHangDTO n) {
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )

            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(deleteStatement);
            call.setInt(maKh, n.getMaKH());

            return call.execute();

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
        }
        return false;
    }

    public ArrayList<KhachHangDTO> getAllKhachHangQuen() {
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )

            connection = DataSource.getInstance().getConnection();
            ArrayList<KhachHangDTO> result = new ArrayList();
            String query = "select * from NGUOI,KHACHHANG WHERE NGUOi.MANGUOI = KHACHHANG.MANGUOI AND KHACHHANG.LAKHACHQUEN = true";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int maKh = rs.getInt("MAKH");
                int maNg = rs.getInt("MANGUOI");
                KhachHangDTO kh = new KhachHangDTO(maKh, maNg, true);
                result.add(kh);
            }
            st.close();

            return result;
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
        }
        return null;
    }

    public NguoiDTO checkKhachHangQuen(int shortId) {
        try {

            connection = DataSource.getInstance().getConnection();
            ArrayList<KhachHangDTO> result = new ArrayList();
            String query = "select * from NGUOI,KHACHHANG WHERE NGUOi.MANGUOI = KHACHHANG.MANGUOI AND NGUOI.SHORTID=" + shortId;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.first()) {
                int maNg = rs.getInt("MANGUOI");
                String diachi = rs.getString("DIACHI");
                String ten = rs.getString("HOTEN");
                NguoiDTO ng = new NguoiDTO(maNg, ten, diachi, shortId);
                return ng;
            }
            st.close();
            return null;
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
        }
        return null;
    }

    public int getLastID() {
        try {
            // procedure  P_No_getLastID(out maxid varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call KHACHHANG_getLastID(?)}");
            call.registerOutParameter(1, java.sql.Types.VARCHAR);

            call.execute();
            return call.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        } //<editor-fold defaultstate="collapsed" desc="finally">
        finally {
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
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
        return 0;
    }

    public int getNexId() {
        return getLastID() + 1;

    }

    public int getMaKhachHangByName(int shortId) {
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )

            connection = DataSource.getInstance().getConnection();
            ArrayList<KhachHangDTO> result = new ArrayList();
            String query = "select KHACHHANG.MAKH from KHACHHANG,NGUOI where NGUOI.MANGUOI = KHACHHANG.MANGUOI and NGUOI.SHORTID=" + shortId;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.first()) {
                return rs.getInt("MAKH");
            }
            st.close();
            return 0;
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
        }
        return 0;
    }

}
