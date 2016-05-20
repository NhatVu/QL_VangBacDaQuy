/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.CTP_BanHangDTO;
import DTO.P_BanHangDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Nhat
 */
public class P_BanHangDAO {
    CallableStatement call = null;
    Connection connection = null;
    
    public P_BanHangDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(P_BanHangDTO p_BH){
        //procedure P_BANHANG_Ins (MAP_BH varchar(10), MAP_THU varchar(10) )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_BANHANG_Ins(?,?)}");
            call.setString("MAP_BH", p_BH.getMaP_BH());
            call.setString("MAP_THU", p_BH.getMaP_Thu());
            
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
    
    public boolean update(P_BanHangDTO p_BH){
        try {
           //procedure P_BANHANG_Upd (MAP_BH varchar(10), MAP_THU varchar(10) )
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall("{call P_BANHANG_Upd(?,?)}");
            call.setString("MAP_BH", p_BH.getMaP_BH());
            call.setString("MAP_THU", p_BH.getMaP_Thu());
            
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
    
    public boolean delete(P_BanHangDTO p_BH){
        try {
            //procedure P_BANHANG_Del (MAP_BH varchar(10) )
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_BANHANG_Del(?)}");
            call.setString("MAP_BH", p_BH.getMaP_BH());
            
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
