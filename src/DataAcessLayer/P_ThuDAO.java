package DataAcessLayer;

import DTO.P_ThuDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Resource;

public class P_ThuDAO {

    CallableStatement call = null;
    Connection connection = null;

    public P_ThuDAO() {

    }

    /*
     * CRUD
     */
    public boolean insert(P_ThuDTO p_T) {
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
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean update(P_ThuDTO p_T) {
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
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean delete(P_ThuDTO p_T) {
        try {
            //P_THU_Del ( MAP_THU varchar(10) )
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_THU_Del(?)}");
            call.setString("MAP_THU", p_T.getMaP_Thu());

            return call.execute();

        } catch (SQLException ex) {
            Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    /*
     1. Intent: Lấy thông tin tiền còn lại, ngày thu
        - Nếu phiếu thu đã lập => lấy theo bảng phiếu nợ
        - Nếu phiếu thu chưa lập => kiểm tra , nếu là khách quen => cho lập
        - 1,2 ko thỏa => trả về conLao = 0, ngayLap = "0000-00-00
    
    2. Paramiter :
        - In : maKH = mã khách hàng ; maP_Thu = mã phiếu thu
        - Out : tmpList[0] = tiền còn lại
        - Out : tmpList[1] = ngày trả

     */
    public void getLastConLaiNgayTraByMaP_Thu(String maKH, String maP_Thu, String tmptList[]) {
        try {

            //  procedure  P_Thu_getLastConLaiNgayTraByMaP_Thu(in maKH varchar(10), in maP_Thu varchar(10),
            // out conLai decimal(10,3), out ngayTra timestamp)
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_Thu_getLastConLaiNgayTraByMaP_Thu(?,?,?,?)}");
            call.setString(1, maKH);
            call.setString(2, maP_Thu);
            call.registerOutParameter(3, Types.DECIMAL);
            call.registerOutParameter(4, Types.TIMESTAMP);

            call.execute();
            tmptList[0] = String.valueOf(call.getDouble(3));
            tmptList[1] = String.valueOf(call.getTimestamp(4).getTime());

        } catch (SQLException ex) {
            Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } //<editor-fold defaultstate="collapsed" desc="finally">
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
    }
    
    public String getLastID() {
        try {
            // procedure  P_No_getLastID(out maxid varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_THU_getLastID(?)}");
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
                    Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
        return null;
    }
    
    
    public String getNexId()
    {
        String maPhieu = Resource.P_THU+"1";
        if(this.getLastID()!=null)
        {
            String curentId = getLastID();
            maPhieu= Resource.P_THU+(Integer.valueOf(curentId.substring(Resource.P_THU.length()))+1)+"";
        }
        return maPhieu;
    }
}
