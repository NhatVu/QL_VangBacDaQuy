package DataAcessLayer;

import DTO.P_DichVuDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class P_DichVuDAO {
	CallableStatement call = null;
    Connection connection = null;
    
    public P_DichVuDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(P_DichVuDTO p_DV){
        // procedure P_DICHVU_Ins (MAP_DV varchar(10), MAP_THU varchar(10) )   	 

        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_DICHVU_Ins(?,?)}");
            
            call.setString("MAP_DV", p_DV.getMaP_DV());
            call.setString("MAP_THU", p_DV.getMaP_Thu());
            
            return call.execute();
                    
       
        } catch (SQLException ex) {
            Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(P_DichVuDTO p_DV){
    	// P_DICHVU_Upd (MAP_DV varchar(10), MAP_THU varchar(10) )  
        
    	try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_DICHVU_Upd(?,?)}");

            call.setString("MAP_DV", p_DV.getMaP_DV());
            call.setString("MAP_THU", p_DV.getMaP_Thu());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(P_DichVuDTO p_DV){
        try {
            // P_DICHVU_Del (MAPDV varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_DICHVU_Del(?)}");
            call.setString("MAP_DV", p_DV.getMaP_DV());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}