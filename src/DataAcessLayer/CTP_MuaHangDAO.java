/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.CTP_MuaHangDTO;
import main.Resource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Nhat
 */
public class CTP_MuaHangDAO {

    CallableStatement call = null;
    Connection connection = null;

    public CTP_MuaHangDAO() {

    }

    /*
     * CRUD
     */
    public boolean insert(CTP_MuaHangDTO ctp_MH) {
        // procedure CTP_MUAHANG_Ins (MACTP_MH varchar(10), MASP varchar(10), MAP_MH varchar(10),
        // SOLUONG int, DONGIA decimal, THANHTIEN decimal )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_MUAHANG_Ins(?,?,?,?,?)}");
            call.setInt("MACTP_MH", ctp_MH.getMaCTP_MH());
            call.setInt("MASP", ctp_MH.getMaSP());
            call.setInt("MAP_MH", ctp_MH.getMaP_MH());
            call.setInt("SOLUONG", ctp_MH.getSoLuong());
            call.setDouble("THANHTIEN", ctp_MH.getThanhTien());

            return call.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean update(CTP_MuaHangDTO ctp_MH) {
        try {
            //procedure CTP_MUAHANG_Upd (MACTP_MH varchar(10), MASP varchar(10), MAP_MH varchar(10),
            // SOLUONG int, DONGIA decimal, THANHTIEN decimal )
            connection = DataSource.getInstance().getConnection();

            call = connection.prepareCall("{call CTP_MUAHANG_Upd(?,?,?,?,?)}");
            call.setInt("MACTP_MH", ctp_MH.getMaCTP_MH());
            call.setInt("MASP", ctp_MH.getMaSP());
            call.setInt("MAP_MH", ctp_MH.getMaP_MH());
            call.setInt("SOLUONG", ctp_MH.getSoLuong());
            call.setDouble("THANHTIEN", ctp_MH.getThanhTien());

            return call.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean delete(CTP_MuaHangDTO ctp_MH) {
        try {
            //procedure CTP_MUAHANG_Del (MACTP_MH varchar(10) )
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_MUAHANG_Del(?)}");
            call.setInt("MACTP_MH", ctp_MH.getMaCTP_MH());

            return call.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public int getLastID() {
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_MUAHANG_getLastID(?)}");
            call.registerOutParameter(1, java.sql.Types.VARCHAR);

            call.execute();
            return call.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(CTP_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTP_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 0;
    }

    public int getNexId() {
        return getLastID() + 1;

    }
}
