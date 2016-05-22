package team.com.DataAccessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import team.com.DTO.P_ThuDTO;

public class P_ThuDAO {
	CallableStatement call = null;
    Connection connection = null;
    
    public P_ThuDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(P_ThuDTO p_T){
        // procedure P_THU_Ins ( MAP_THU varchar(10), MAKH varchar(10),
    	// NGAYLAPPHIEU time, NGAYKETTHUC time, TONGCONG decimal(10,3) )
    	 
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_THU_Ins(?,?,?,?,?)}");
            
            call.setString("MAP_THU", p_T.getMaP_Thu());
            call.setString("MAKH", p_T.getMaKH());
            call.setTimestamp("NGAYLAPPHIEU", p_T.getNgayLapPhieu());
            call.setTimestamp("NGAYKETTHUC", p_T.getNgayKetThuc());
            call.setDouble("TONGCONG", p_T.getTongCong());
            
            return call.execute();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(P_ThuDTO p_T){
        try {
        	// P_THU_Upd ( MAP_THU varchar(10), MAKH varchar(10),
        	// NGAYLAPPHIEU time, NGAYKETTHUC time, TONGCONG decimal(10,3) )
        	
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_THU_Upd(?,?,?,?,?)}");

            call.setString("MAP_THU", p_T.getMaP_Thu());
            call.setString("MAKH", p_T.getMaKH());
            call.setTimestamp("NGAYLAPPHIEU", p_T.getNgayLapPhieu());
            call.setTimestamp("NGAYKETTHUC", p_T.getNgayKetThuc());
            call.setDouble("TONGCONG", p_T.getTongCong());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(P_ThuDTO p_T){
        try {
            //P_THU_Del ( MAP_THU varchar(10) )
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_THU_Del(?)}");
            call.setString("MAP_THU", p_T.getMaP_Thu());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
