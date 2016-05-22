package team.com.DataAccessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import team.com.DTO.P_NoDTO;

public class P_NoDAO {
	CallableStatement call = null;
    Connection connection = null;
    
    public P_NoDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(P_NoDTO p_N){
        // procedure P_NO_Ins ( MAP_NO varchar(10), MAP_THU varchar(10), NGAYNO time,
    	// SOTIENNO decimal(10,3), NGAYTRA time, SOTIENTRA decimal(10,3) )
    	
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_NO_Ins(?,?,?,?,?,?)}");
            call.setString("MAP_NO", p_N.getMaP_No());
            call.setString("MAP_THU", p_N.getMaP_Thu());
            call.setTimestamp("NGAYNO", p_N.getNgayNo());
            call.setDouble("SOTIENNO", p_N.getSoTienNo());
            call.setTimestamp("NGAYTRA", p_N.getNgayTra());
            call.setDouble("SOTIENTRA", p_N.getSoTienTra());
    
            return call.execute();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(P_NoDTO p_N){
        try {
        	// P_NO_Upd ( MAP_NO varchar(10), MAP_THU varchar(10), NGAYNO time,
        	// SOTIENNO decimal(10,3), NGAYTRA time, SOTIENTRA decimal(10,3) )
        	
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_NO_Upd(?,?,?,?,?,?)}");

            call.setString("MAP_NO", p_N.getMaP_No());
            call.setString("MAP_THU", p_N.getMaP_Thu());
            call.setTimestamp("NGAYNO", p_N.getNgayNo());
            call.setDouble("SOTIENNO", p_N.getSoTienNo());
            call.setTimestamp("NGAYTRA", p_N.getNgayTra());
            call.setDouble("SOTIENTRA", p_N.getSoTienTra());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(P_NoDTO p_N){
        try {
            //P_NO_Del (MAP_NO varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_NO_Del(?)}");
            call.setString("MAP_NO", p_N.getMaP_No());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
