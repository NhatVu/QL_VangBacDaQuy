package DataAcessLayer;

import DTO.P_NoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.logging.Level;
import java.util.logging.Logger;



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
            
             try {
                call.close();
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
            
             try {
                call.close();
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
        //<editor-fold defaultstate="collapsed" desc="finally">
        finally{
            if(connection!=null)
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
        return false;
    }
    
    /*
    1. Intent
        - Lấy mã phiếu nợ tiếp theo sẽ được thêm vào bảng phiếu nợ.
    2. Return
        - Trả về mã phiếu nợ.
    */
    public String getLastID(){
        try {
            // procedure  P_No_getLastID(out maxid varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_No_getLastID(?)}");
            call.registerOutParameter(1, java.sql.Types.VARCHAR);
            
            call.execute();
            return call.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //<editor-fold defaultstate="collapsed" desc="finally">
        finally{
            if(connection!=null)
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
}
