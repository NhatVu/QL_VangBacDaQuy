/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.SanPhamDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Nhat
 */
public class SanPhamDAO {

    CallableStatement call = null;
    Connection connection = null;

    public SanPhamDAO() {

    }

    /*
     * CRUD
     */
    public boolean insert(SanPhamDTO sp) {
        //procedure SANPHAM_Ins (MASP varchar(10), TENLOAISP varchar(30), DONGIAMUA decial, DONGIABAN decimal, SOLUONGTON int )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call SANPHAM_Ins(?,?,?,?,?)}");
            call.setString("MASP", sp.getMaSP());
            call.setString("TENLOAISP", sp.getTenSP());
            call.setDouble("DONGIAMUA", sp.getDonGiaMua());
            call.setDouble("DONGIABAN", sp.getDonGiaBan());
            call.setInt("SOLUONGTON", sp.getSoLuongTon());

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
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(SanPhamDTO sp) {
        try {
            //procedure SANPHAM_Upd (MASP varchar(10), TENLOAISP varchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
            connection = DataSource.getInstance().getConnection();

            call = connection.prepareCall("{call SANPHAM_Upd(?,?,?,?,?)}");
            call.setString("MASP", sp.getMaSP());
            call.setString("TENLOAISP", sp.getTenSP());
            call.setDouble("DONGIAMUA", sp.getDonGiaMua());
            call.setDouble("DONGIABAN", sp.getDonGiaBan());
            call.setInt("SOLUONGTON", sp.getSoLuongTon());

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
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(SanPhamDTO sp) {
        try {
            //create procedure SANPHAM_Del (MASP varchar(10) )

            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call SANPHAM_Del(?)}");
            call.setString("MASP", sp.getMaSP());

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
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public List<String> getMaSP(){
         try {
             List<String> result = new ArrayList<String>();
            connection = DataSource.getInstance().getConnection();

            call = connection.prepareCall("{call SanPham_getSanPham()}");
            
             ResultSet rs = call.executeQuery();
             while(rs.next()){
                 result.add(rs.getString(1));
             }
             return result;

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
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
