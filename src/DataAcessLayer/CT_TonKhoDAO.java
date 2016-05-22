package team.com.DataAccessLayer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import team.com.DTO.CT_TonKhoDTO;

public class CT_TonKhoDAO {
	CallableStatement call = null;
    Connection connection = null;
    
    public CT_TonKhoDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(CT_TonKhoDTO ct_TK){
        // procedure CT_TONKHO_Ins (MACTP_TK varchar(10), MAP_TK varchar(10), MAHANG varchar(10),
    	// TONDAUKY int(11), TONCUOIKY int(11), SOLUONGBAN int(11), SOLUONGMUA int(11)) 

        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CT_TONKHO_Ins(?,?,?,?,?,?,?)}");
            call.setString("MACTP_TK", ct_TK.getMaCTP_TK());
            call.setString("MAP_TK", ct_TK.getMaP_TK());
            call.setString("MAHANG", ct_TK.getMaHang());
            call.setInt("TONDAUKY", ct_TK.getTonDauKy());
            call.setInt("TONCUOIKY", ct_TK.getTonDauKy());
            call.setInt("SOLUONGBAN", ct_TK.getSoLuongBan());
            call.setInt("SOLUONFMUA", ct_TK.getSoLuongMua());
            
            return call.execute();
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(CT_TonKhoDTO ct_TK){
        try {
        	// CT_TONKHO_Upd (MACTP_TK varchar(10), MAP_TK varchar(10), MAHANG varchar(10),
        	// TONDAUKY int(11), TONCUOIKY int(11), SOLUONGBAN int(11), SOLUONGMUA int(11))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CT_TONKHO_Upd(?,?,?,?,?,?,?)}");
            
            call.setString("MACTP_TK", ct_TK.getMaCTP_TK());
            call.setString("MAP_TK", ct_TK.getMaP_TK());
            call.setString("MAHANG", ct_TK.getMaHang());
            call.setInt("TONDAUKY", ct_TK.getTonDauKy());
            call.setInt("TONCUOIKY", ct_TK.getTonDauKy());
            call.setInt("SOLUONGBAN", ct_TK.getSoLuongBan());
            call.setInt("SOLUONFMUA", ct_TK.getSoLuongMua());
            
            return call.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!= null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(CT_TonKhoDTO ct_TK){
        try {
            //CT_TONKHO_Del (MACTP_TK varchar(10)
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call CT_TONKHO_Del(?)}");
            call.setString("MACTP_TK", ct_TK.getMaCTP_TK());
            
            return call.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CT_TonKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
