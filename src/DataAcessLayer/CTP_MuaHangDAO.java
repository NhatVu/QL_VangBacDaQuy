/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.CTP_MuaHangDTO;
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
    
    public CTP_MuaHangDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(CTP_MuaHangDTO ctp_MH){
        // procedure CTP_MUAHANG_Ins (MACTP_MH varchar(10), MASP varchar(10), MAP_MH varchar(10),
        // SOLUONG int, DONGIA decimal, THANHTIEN decimal )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_MUAHANG_Ins(?,?,?,?,?,?)}");
            call.setString("MACTP_MH", ctp_MH.getMaCTP_MH());
            call.setString("MASP", ctp_MH.getMaSP());
            call.setString("MAP_MH", ctp_MH.getMaP_MH());
            call.setInt("SOLUONG", ctp_MH.getSoLuong());
            call.setDouble("DONGIA", ctp_MH.getDonGia());
            call.setDouble("THANHTIEN", ctp_MH.getThanhTien());
            
            return call.execute();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(CTP_MuaHangDTO ctp_MH){
        try {
            //procedure CTP_MUAHANG_Upd (MACTP_MH varchar(10), MASP varchar(10), MAP_MH varchar(10),
            // SOLUONG int, DONGIA decimal, THANHTIEN decimal )
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall("{call CTP_MUAHANG_Upd(?,?,?,?,?,?)}");
            call.setString("MACTP_MH", ctp_MH.getMaCTP_MH());
            call.setString("MASP", ctp_MH.getMaSP());
            call.setString("MAP_MH", ctp_MH.getMaP_MH());
            call.setInt("SOLUONG", ctp_MH.getSoLuong());
            call.setDouble("DONGIA", ctp_MH.getDonGia());
            call.setDouble("THANHTIEN", ctp_MH.getThanhTien());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(CTP_MuaHangDTO ctp_MH){
        try {
            //procedure CTP_MUAHANG_Del (MACTP_MH varchar(10) )
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_MUAHANG_Del(?)}");
            call.setString("MACTP_MH", ctp_MH.getMaCTP_MH());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
