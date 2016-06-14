package DataAcessLayer;

import DTO.P_ChiDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Resource;

public class P_ChiDAO {

    CallableStatement call = null;
    Connection connection = null;

    public P_ChiDAO() {

    }

    /*
     * CRUD
     */
    public boolean insert(P_ChiDTO p_C) {
        // procedure P_CHI_Ins (MAP_CHI varchar(10), NGAYCHI timestamp, NOIDUNG varchar(300), SOTIENCHI decimal )

        try {
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_CHI_Ins(?,?,?,?)}");
            call.setInt("MAP_CHI", p_C.getMaP_Chi());
            call.setTimestamp("NGAYCHI", p_C.getNgayChi());
            call.setString("NOIDUNG", p_C.getNoiDung());
            call.setDouble("SOTIENCHI", p_C.getSoTienChi());

            return call.execute();

        } catch (SQLException ex) {
            Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(P_ChiDTO p_C) {
        try {
            //P_CHI_Upd (MAP_CHI varchar(10), NGAYBAOCAO time,NOIDUNG varchar(300), SOTIENCHI decimal(10,3))

            connection = DataSource.getInstance().getConnection();

            call = connection.prepareCall("{call P_CHI_Upd(?,?,?,?)}");
            call.setInt("MAP_CHI", p_C.getMaP_Chi());
            call.setTimestamp("NGAYCHI", p_C.getNgayChi());
            call.setString("NOIDUNG", p_C.getNoiDung());
            call.setDouble("SOTIENCHI", p_C.getSoTienChi());

            return call.execute();

        } catch (SQLException ex) {
            Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(P_ChiDTO p_C) {
        try {
            //P_CHI_Del (MAP_CHI varchar(10))
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_CHI_Del(?)}");
            call.setInt("MAP_CHI", p_C.getMaP_Chi());

            return call.execute();

        } catch (SQLException ex) {
            Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public int getLastID() {
        try {
            //create procedure P_Chi_getLastID()
            connection = DataSource.getInstance().getConnection();
            call = connection.prepareCall("{call P_Chi_getLastID(?)}");

            call.execute();
            return call.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                call.close();
            } catch (SQLException ex) {
                Logger.getLogger(P_ChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int getNexId() {
        return getLastID() + 1;
    }
}
