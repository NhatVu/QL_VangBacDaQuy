package DataAcessLayer;

import DTO.P_ChiDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class P_ChiDAO {
	CallableStatement call = null;
    Connection connection = null;
    
    public P_ChiDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(P_ChiDTO p_C){
        // procedure P_CHI_Ins (MAP_CHI varchar(10), NGAYBAOCAO time, TONGCONG decimal(10,3))
    	
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_CHI_Ins(?,?,?)}");
            call.setString("MAP_CHI", p_C.getMaP_Chi());
            call.setTimestamp("NGAYBAOCAO", p_C.getBaoCao());
            call.setInt("TONGCONG", p_C.getTongCong());
    
            return call.execute();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(P_ChiDTO p_C){
        try {
            //P_CHI_Upd (MAP_CHI varchar(10), NGAYBAOCAO time, TONGCONG decimal(10,3))
        	
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall("{call P_CHI_Upd(?,?,?)}");
            call.setString("MAP_CHI", p_C.getMaP_Chi());
            call.setTimestamp("NGAYBAOCAO", p_C.getBaoCao());
            call.setInt("TONGCONG", p_C.getTongCong());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(P_ChiDTO p_C){
        try {
            //P_CHI_Del (MAP_CHI varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_CHI_Del(?)}");
            call.setString("MAP_CHI", p_C.getMaP_Chi());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
