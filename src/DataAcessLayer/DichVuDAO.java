/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.DichVuDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Nhat
 */
public class DichVuDAO {
    CallableStatement call = null;
    Connection connection = null;
    
    public DichVuDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(DichVuDTO dv){
        //procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30), DONGIA decimal )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call DICHVU_Ins(?,?)}");
            call.setString("MADV", dv.getMaDV());
            call.setString("TENDV", dv.getTenDV());
            call.setDouble("DONGIA", dv.getDonGia());
            
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
    
    public boolean update(DichVuDTO dv){
        try {
            // procedure DICHVU_Upd (MADV varchar(10), TENDV varchar(30), DONGIA decimal)
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall("{call DICHVU_Upd(?,?)}");
            call.setString("MADV", dv.getMaDV());
            call.setString("TENDV", dv.getTenDV());
            call.setDouble("DONGIA", dv.getDonGia());
            
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
    
    public boolean delete(DichVuDTO dv){
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )

            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call DICHVU_Del(?)}");
            call.setString("MADV", dv.getMaDV());
            
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
