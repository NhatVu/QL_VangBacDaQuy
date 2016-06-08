/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.DichVuDTO;
import DTO.KhachHangDTO;
import DTO.NguoiDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Nhat
 */
public class DichVuDAO {
    CallableStatement call = null;
    Connection connection = null;
    private String TAG = DichVuDAO.class.getSimpleName();
    
    public DichVuDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(DichVuDTO dv){
        //procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30), DONGIA decimal )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call DICHVU_Ins(?,?,?)}");
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
            
            call = connection.prepareCall("{call DICHVU_Upd(?,?,?)}");
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
    
    public ArrayList<DichVuDTO> getAllDichVu()
    {
        try {
            //create procedure DICHVU_Del (MADV varchar(10) )
            
            connection = DataSource.getInstance().getConnection();
            ArrayList<DichVuDTO> result = new ArrayList();
            String query = "SELECT * FROM DICHVU";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String maGC = rs.getString("MADV");
                String tenGC = rs.getString("TENDV");
                double dongia = Double.parseDouble(rs.getString("DONGIA"));
                DichVuDTO dv = new DichVuDTO(maGC,tenGC,dongia);
                result.add(dv);
            }
            st.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        }
        finally{
            if(connection!=null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
