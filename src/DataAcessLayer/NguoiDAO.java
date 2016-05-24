/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.DichVuDTO;
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
public class NguoiDAO {
    CallableStatement call = null;
    Connection connection = null;
    
    //Properties of table
    private static final String maNguoi = "MANGUOI";
    private static final String shortId = "SHORTID";
    private static final String hoten = "HOTEN";
    private static final String diachi = "DIACHI";
    
    private static final String insertStatement = "{call NGUOI_Ins(?,?,?,?)}";
    private static final String updateStatement = "{call NGUOI_Upd(?,?,?,?)}";
    private static final String deleteStatement = "{call NGUOI_Del(?)}";
    
    //TAG
    private static final String TAG = NguoiDAO.class.getSimpleName();
    
    
    public NguoiDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(NguoiDTO n){
        //create procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30) )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(insertStatement);
            
            call.setString(maNguoi, n.getMaLoaiNguoi());
            call.setInt(shortId, n.getShortID());
            call.setString(hoten, n.getHoTen());
            call.setString(diachi, n.getDiaChi());
            
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
    
    public boolean update(NguoiDTO n){
        try {
            // procedure DICHVU_Upd (MADV varchar(10), TENDV varchar(30) )
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall(updateStatement);
            call.setString(maNguoi, n.getMaLoaiNguoi());
            call.setInt(shortId, n.getShortID());
            call.setString(hoten, n.getHoTen());
            call.setString(diachi, n.getDiaChi());
            
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
    
    public boolean delete(NguoiDTO n){
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )

            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(deleteStatement);
            call.setString(maNguoi, n.getMaLoaiNguoi());
            
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
