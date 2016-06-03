/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.CTP_GiaCongDTO;
import DTO.DichVuDTO;
import DTO.NguoiDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Resource;

/**
 *
 * @author Administrator
 */
public class CTP_GiaCongDAO {
    CallableStatement call = null;
    Connection connection = null;
    
    //Properties of table
    private static final String maChiTietPhieuGiaCong = "MACTP_GC";
    private static final String maPhieuGiaCong = "MAP_GC";
    private static final String maLoaiGiaCong = "MALOAIGC";
    private static final String soluong = "SOLUONG";
    private static final String thanhTien = "THANHTIEN";
    
    private static final String insertStatement = "{call CTP_GIACONG_Ins(?,?,?,?,?)}";
    private static final String updateStatement = "{call CTP_GIACONG_Upd(?,?,?,?,?)}";
    private static final String deleteStatement = "{call CTP_GIACONG_Del(?)}";
    
    //TAG
    private static final String TAG = CTP_GiaCongDAO.class.getSimpleName();
    
    
    public CTP_GiaCongDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(CTP_GiaCongDTO n){
        //create procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30) )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(insertStatement);
            
            call.setString(maChiTietPhieuGiaCong, n.getMaCTP_GC());
            call.setString(maPhieuGiaCong, n.getMaP_GC());
            call.setString(maLoaiGiaCong, n.getMaLoaiGC());
            call.setInt(soluong, n.getSoLuong());
            call.setDouble(thanhTien, n.getThanhTien());
            
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
    
    public boolean update(CTP_GiaCongDTO n){
        try {
            // procedure DICHVU_Upd (MADV varchar(10), TENDV varchar(30) )
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall(updateStatement);
             call.setString(maChiTietPhieuGiaCong, n.getMaCTP_GC());
            call.setString(maPhieuGiaCong, n.getMaP_GC());
            call.setString(maLoaiGiaCong, n.getMaLoaiGC());
            call.setInt(soluong, n.getSoLuong());
            call.setDouble(thanhTien, n.getThanhTien());
            
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
    
    public boolean delete(CTP_GiaCongDTO n){
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )

            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(deleteStatement);
            call.setString(maChiTietPhieuGiaCong, n.getMaCTP_GC());
            
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
    
    public String getLastID() {
        try {
            // procedure  P_No_getLastID(out maxid varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_GIACONG_getLastID(?)}");
            call.registerOutParameter(1, java.sql.Types.VARCHAR);

            call.execute();
            return call.getString(1);

        } catch (SQLException ex) {
            Logger.getLogger(NguoiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } //<editor-fold defaultstate="collapsed" desc="finally">
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
        return null;
    }
    
    public String getNexId()
    {
        String maPhieu = Resource.CTP_GIACONG+"1";
        if(this.getLastID()!=null)
        {
            String curentId = getLastID();
            maPhieu= Resource.CTP_GIACONG+(Integer.valueOf(curentId.substring(Resource.CTP_GIACONG.length()))+1)+"";
        }
        return maPhieu;
    }
}
