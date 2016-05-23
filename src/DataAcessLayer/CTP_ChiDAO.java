package DataAcessLayer;

import DTO.CTP_ChiDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CTP_ChiDAO {
	CallableStatement call = null;
    Connection connection = null;
    
    public CTP_ChiDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(CTP_ChiDTO ctp_C){
        // procedure CTP_CHI_Ins (MACTP_CHI varchar(10), MAP_CHI varchar(10), 
    	// MAPHI varchar(10), TENPHI varchar(30), THANHTIEN decimal(10,3) )
    	
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_CHI_Ins(?,?,?,?,?)}");
            call.setString("MACTP_CHI", ctp_C.getMaCTP_Chi());
            call.setString("MAP_CHI", ctp_C.getMaP_Chi());
            call.setString("MAPHI", ctp_C.getMaPhi());
            call.setString("TENPHI", ctp_C.getTenPhi());
            call.setDouble("THANHTIEN", ctp_C.getThanhTien());
    
            return call.execute();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(CTP_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(CTP_ChiDTO ctp_C){
        try {
        	// CTP_CHI_Upd (MACTP_CHI varchar(10), MAP_CHI varchar(10), 
        	// MAPHI varchar(10), TENPHI varchar(30), THANHTIEN decimal(10,3) )
        	
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall("{call CTP_CHI_Upd(?,?,?,?,?)}");
            call.setString("MACTP_CHI", ctp_C.getMaCTP_Chi());
            call.setString("MAP_CHI", ctp_C.getMaP_Chi());
            call.setString("MAPHI", ctp_C.getMaPhi());
            call.setString("TENPHI", ctp_C.getTenPhi());
            call.setDouble("THANHTIEN", ctp_C.getThanhTien());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(CTP_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(CTP_ChiDTO ctp_C){
        try {
            //CTP_CHI_Del (MACTP_CHI varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_CHI_Del(?)}");
            call.setString("MACTP_CHI", ctp_C.getMaCTP_Chi());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CTP_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
