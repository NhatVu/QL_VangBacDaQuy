package DataAcessLayer;

import DTO.CTP_DichVuDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Resource;


public class CTP_DichVuDAO {
	CallableStatement call = null;
    Connection connection = null;
    
    public CTP_DichVuDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(CTP_DichVuDTO ctp_DV){
        // procedure CTP_DICHVU_Ins (MACTP_DV varchar(10), MAP_DV varchar(10), 
    	// MADV varchar(10), SOLUONG int(11), THANHTIEN decimal(10,3))  
    	
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_DICHVU_Ins(?,?,?,?,?)}");
            
            call.setString("MACTP_DV", ctp_DV.getMaCTP_DV());
            call.setString("MAP_DV", ctp_DV.getMaP_DV());
            call.setString("MADV", ctp_DV.getMaDV());
            call.setInt("SOLUONG", ctp_DV.getSoLuong());
            call.setDouble("THANHTIEN", ctp_DV.getThanhTien());
            
            return call.execute();
                    
       
        } catch (SQLException ex) {
            Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(CTP_DichVuDTO ctp_DV){
        try {
        	// CTP_DICHVU_Upd (MACTP_DV varchar(10), MAP_DV varchar(10), 
        	// MADV varchar(10), SOLUONG int(11), THANHTIEN decimal(10,3))  
        	
        	
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_DICHVU_Ins(?,?,?,?,?)}");

            call.setString("MACTP_DV", ctp_DV.getMaCTP_DV());
            call.setString("MAP_DV", ctp_DV.getMaP_DV());
            call.setString("MADV", ctp_DV.getMaDV());
            call.setInt("SOLUONG", ctp_DV.getSoLuong());
            call.setDouble("THANHTIEN", ctp_DV.getThanhTien());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(CTP_DichVuDTO ctp_DV){
        try {
            // CTP_DICHVU_Del (MACTP_DV varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_DICHVU_Del(?)}");
            call.setString("MACTP_DV", ctp_DV.getMaCTP_DV());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public String getLastID() {
        try {
            // procedure  P_No_getLastID(out maxid varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CTP_DICHVU_getLastID(?)}");
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
        String maPhieu = Resource.CTP_DICHVU+"1";
        if(this.getLastID()!=null)
        {
            String curentId = getLastID();
            maPhieu= Resource.CTP_DICHVU+(Integer.valueOf(curentId.substring(Resource.CTP_DICHVU.length()))+1)+"";
        }
        return maPhieu;
    }
}
