/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.CTP_BanHangDTO;
import DTO.P_BanHangDTO;
import main.Resource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Nhat
 */
public class P_BanHangDAO {

    CallableStatement call = null;
    Connection connection = null;

    private final String maP_BH = "MAP_BH";
    private final String maP_Thu = "MAP_THU";

    private final String insertProcedure = "{call P_BANHANG_Ins(?,?)}";
    private final String updateProcedure = "{call P_BANHANG_Upd(?,?)}";
    private final String deleteProcedure = "{call P_BANHANG_Del(?)}";
    private final String getMKH_HoTenByMaP_BH = "{call P_BanHang_getMaKHHoTenByMaP_BH(?)}";

    public P_BanHangDAO() {

    }

    /*
     * CRUD
     */
    public boolean insert(P_BanHangDTO p_BH) {
        //procedure P_BANHANG_Ins (MAP_BH varchar(10), MAP_THU varchar(10) )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(insertProcedure);
            call.setString(maP_BH, p_BH.getMaP_BH());
            call.setString(maP_Thu, p_BH.getMaP_Thu());

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

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(P_BanHangDTO p_BH) {
        try {
            //procedure P_BANHANG_Upd (MAP_BH varchar(10), MAP_THU varchar(10) )
            connection = DataSource.getInstance().getConnection();

            call = connection.prepareCall(updateProcedure);
            call.setString(maP_BH, p_BH.getMaP_BH());
            call.setString(maP_Thu, p_BH.getMaP_Thu());

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
            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(P_BanHangDTO p_BH) {
        try {
            //procedure P_BANHANG_Del (MAP_BH varchar(10) )
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(deleteProcedure);
            call.setString(maP_BH, p_BH.getMaP_BH());

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

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /*
     1. Intent:
     - Lấy mã khách hàng, họ tên dựa vào mã phiếu bán hàng
     2. Paramiter
     - In: maP_BH = mã phiếu bán hàng
     - Out: tmptList[0] = maKH
     - Out: tmptList[1] = HoTen
     */
    public void getMaKHHoTenByMaP_BH(String maP_BH, String tmptList[]) {
        try {
            //procedure P_BANHANG_Del (MAP_BH varchar(10) )
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_BanHang_getMaKHHoTenByMaP_BH(?)}");
            call.setString(1, maP_BH);

            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                tmptList[0] = rs.getString(1);
                tmptList[1] = rs.getString(2);
            }

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

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*
     1. Intent
     - Lấy mã phiếu thu dựa vào mã phiếu bán hàng
     2. Return
     - Trả về mã phiếu bán hàng
     */
    public String getMaP_ThuByMaP_BH(String maP_BH) {
        try {
            // procedure P_BanHang_getMaP_ThuByMaP_BH(in maP_BH varchar(10),out maP_Thu varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_BanHang_getMaP_ThuByMaP_BH(?,?)}");
            call.setString(1, maP_BH);
            call.registerOutParameter(2, java.sql.Types.VARCHAR);

            call.execute();
            return call.getString(2);

        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } //<editor-fold defaultstate="collapsed" desc="finally">
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
        return null;
    }

    /*
     * Lấy mã sản phẩm, tổng số lượng bán nhóm theo mã sản phẩm trong bảng ctp_banHang
     1. từ ngày lập tồn kho gần nhất đến ngày lập tồn kho hiện tại, có bao nhiêu phiếu bán hàng được lập
     2. Dựa vào số phiếu bán hàng này -> lấy maSP và tổng lượng bán của sản phẩm
     */
    public void getMaSPTongBan(Timestamp lastedNgayBC, Timestamp newNgayBC,Map<String, Integer> lRs ){
        //    create   procedure P_BanHang_getMaSPTongBan(in lastedNgayBC timestamp, in newNgayBC varchar(10))
         try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_BanHang_getMaSPTongBan(?,?)}");
            call.setTimestamp(1, lastedNgayBC);
            call.setTimestamp(2, newNgayBC);

            ResultSet rs = call.executeQuery();
            while(rs.next()){
                lRs.put(rs.getString(1), rs.getInt(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } //<editor-fold defaultstate="collapsed" desc="finally">
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
    }
    
    public String getLastID() {
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_BANHANG_getLastID(?)}");
            call.registerOutParameter(1, java.sql.Types.VARCHAR);

            call.execute();
            return call.getString(1);

        } catch (SQLException ex) {
            Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
    public String getNexId()
    {
        String maPhieu = Resource.P_BANHANG+"1";
        if(this.getLastID()!=null)
        {
            String curentId = getLastID();
            maPhieu= Resource.P_BANHANG+(Integer.valueOf(curentId.substring(Resource.P_BANHANG.length()))+1)+"";
        }
        return maPhieu;
    }
}
