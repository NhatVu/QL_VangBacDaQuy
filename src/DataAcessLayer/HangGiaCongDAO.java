/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.DichVuDTO;
import DTO.HangGiaCongDTO;
import DTO.NguoiDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class HangGiaCongDAO {
    CallableStatement call = null;
    Connection connection = null;
    
    //Properties of table
    private static final String maLoaiGiaCong = "MALOAIGC";
    private static final String tenLoaiGiaCong = "TENLOAGC";
    private static final String donGia = "DONGIA";
    
    
    private static final String insertStatement = "{call HANGGIACONG_Ins(?,?,?)}";
    private static final String updateStatement = "{call HANGGIACONG_Upd(?,?,?)}";
    private static final String deleteStatement = "{call CTP_GIACONG_Del(?)}";
    //TAG
    private static final String TAG = HangGiaCongDAO.class.getSimpleName();
    
    
    public HangGiaCongDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(HangGiaCongDTO n){
        //create procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30) )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall(insertStatement);
            
            call.setString(maLoaiGiaCong, n.getMaLoaiGC());
            call.setString(tenLoaiGiaCong, n.getTenLoaiGC());
            call.setDouble(donGia, n.getDonGia());
            
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
    
    public boolean update(HangGiaCongDTO n){
        try {
            // procedure DICHVU_Upd (MADV varchar(10), TENDV varchar(30) )
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall(updateStatement);
            call.setString(maLoaiGiaCong, n.getMaLoaiGC());
            call.setString(tenLoaiGiaCong, n.getTenLoaiGC());
            call.setDouble(donGia, n.getDonGia());
            
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
            call.setString(maLoaiGiaCong, n.getMaLoaiNguoi());
            
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
    
    public ArrayList<HangGiaCongDTO> getAllHangGiaCong()
    {
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )
            
            connection = DataSource.getInstance().getConnection();
            ArrayList<HangGiaCongDTO> result = new ArrayList();
            String query = "SELECT * FROM HANGGIACONG";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String maGC = rs.getString("MALOAIGC");
                String tenGC = rs.getString("TENLOAGC");
                double dongia = Double.parseDouble(rs.getString("DONGIA"));
                HangGiaCongDTO dv = new HangGiaCongDTO(maGC,tenGC,dongia);
                result.add(dv);
            }
            st.close();
            return result;
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
        return null;
    }
}
