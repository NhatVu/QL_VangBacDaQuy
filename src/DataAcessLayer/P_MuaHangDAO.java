/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessLayer;

import DTO.P_MuaHangDTO;
import main.Resource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Nhat
 */
public class P_MuaHangDAO {
    CallableStatement call = null;
    Connection connection = null;
    
    public P_MuaHangDAO(){
        
    }
    
    /*
    * CRUD
    */
    public boolean insert(P_MuaHangDTO p_MH){
        //procedure P_MUAHANG_Ins (MAP_MH varchar(10), MAKH varchar(10), 
        // NGAYMUA time, NGAYTHANHTOAN time, TONGCONG decimal )
        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_MUAHANG_Ins(?,?,?,?,?)}");
            call.setInt("MAP_MH", p_MH.getMaP_MH());
            call.setInt("MAKH", p_MH.getMaKH());
            call.setTimestamp("NGAYMUA", p_MH.getNgayMua());
            call.setTimestamp("NGAYTHANHTOAN", p_MH.getNgayThanhToan());
            call.setDouble("TONGCONG", p_MH.getTongCong());
            
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
            
            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean update(P_MuaHangDTO p_MH){
        try {
           //procedure P_MUAHANG_Upd (MAP_MH varchar(10), MAKH varchar(10), 
            // NGAYMUA time, NGAYTHANHTOAN time, TONGCONG decimal )
            connection = DataSource.getInstance().getConnection();
            
            call = connection.prepareCall("{call P_MUAHANG_Upd(?,?,?,?,?)}");
            call.setInt("MAP_MH", p_MH.getMaP_MH());
            call.setInt("MAKH", p_MH.getMaKH());
            call.setTimestamp("NGAYMUA", p_MH.getNgayMua());
            call.setTimestamp("NGAYTHANHTOAN", p_MH.getNgayThanhToan());
            call.setDouble("TONGCONG", p_MH.getTongCong());
            
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
            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean delete(P_MuaHangDTO p_MH){
        try {
            //procedure P_MUAHANG_Del (MAP_MH varchar(10) ))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_MUAHANG_Del(?)}");
            call.setInt("MAP_MH", p_MH.getMaP_MH());
            
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
            
            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    /*
* Lấy mã sản phẩm, tổng số lượng mua nhóm theo mã sản phẩm trong bảng ctp_muahang
1. từ ngày lập tồn kho gần nhất đến ngày lập tồn kho hiện tại, có bao nhiêu phiếu mua hàng được lập
2. Dựa vào số phiếu bán hàng này -> lấy maSP và tổng lượng mua của sản phẩm
*/
     public void getMaSPTongMua(Timestamp lastedNgayBC, Timestamp newNgayBC,Map<Integer, Integer> lRs){
        try {
            // create procedure P_MuaHang_getMaSPTongMua(in lastedNgayBC timestamp, in newNgayBC varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_MuaHang_getMaSPTongMua(?,?)}");
            call.setTimestamp(1, lastedNgayBC);
            call.setTimestamp(2, newNgayBC);
            ResultSet rs = call.executeQuery();
            
            while(rs.next()){
                lRs.put(rs.getInt(1), rs.getInt(2));
            }
            
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
            
            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
     public int getLastID() {
         try {
             connection = DataSource.getInstance().getConnection();
             call = connection.prepareCall("{call P_MUAHANG_getLastID(?)}");
             call.registerOutParameter(1, java.sql.Types.VARCHAR);

             call.execute();
             return call.getInt(1);

         } catch (SQLException ex) {
             Logger.getLogger(P_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally {
             if (connection != null) {
                 try {
                     connection.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(P_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             try {
                 call.close();
             } catch (SQLException ex) {
                 Logger.getLogger(P_MuaHangDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }

         return 0;
     }
     
     public int getNexId() {
      return getLastID() + 1;
     
    }
     
}
