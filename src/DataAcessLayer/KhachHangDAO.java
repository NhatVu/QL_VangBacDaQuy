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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    public KhachHangDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(KhachHangDTO n){
        //create procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30) )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(insertStatement);
            
            call.setString(maKh, n.getMaKH());
            call.setString(maNguoi, n.getMaNguoi());
            call.setInt(laKhachQuen, n.isLaKhachQuen());
            
            
            return call.execute();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(KhachHangDTO n){
        try {
            // procedure DICHVU_Upd (MADV varchar(10), TENDV varchar(30) )
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall(updateStatement);
            call.setString(maKh, n.getMaKH());
            call.setString(maNguoi, n.getMaNguoi());
            call.setInt(laKhachQuen, n.isLaKhachQuen());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(KhachHangDTO n){
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )

            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(deleteStatement);
            call.setString(maKh, n.getMaKH());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
