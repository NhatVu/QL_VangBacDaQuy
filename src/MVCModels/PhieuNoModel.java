package MVCModels;

import java.sql.Timestamp;

import DTO.P_NoDTO;
import DataAcessLayer.*;

public class PhieuNoModel {

    P_NoDAO mP_NoDAO = new P_NoDAO();
    P_BanHangDAO mP_BanHangDAO = new P_BanHangDAO();
    P_ThuDAO mP_ThuDAO = new P_ThuDAO();
    private int maP_Thu = 0;
    int mMakh = 0;
    String mHoTen = null;
    Timestamp lastNgayTra = null;
    Double lastConLai = null;
    String tmptList[] = new String[2]; // con lai = 0, ngay = 1
    
    public void insert(P_NoDTO noDTO){
        mP_NoDAO.insert(noDTO);
    }
    
    /*
    * Hàm lấy thông tin cần thiết cho việc tính toán. Sẽ gọi laoij khi thay
    đổi mã phiếu khách hàng. 
    */
    public void getInformationByMaP_BH(int maP_BH){
       
         mP_BanHangDAO.getMaKHHoTenByMaP_BH(maP_BH, tmptList);
         if(tmptList[0] == null)
             return;
         mMakh = Integer.parseInt(tmptList[0]);
         mHoTen = tmptList[1];
         maP_Thu = mP_BanHangDAO.getMaP_ThuByMaP_BH(maP_BH);
         mP_ThuDAO.getLastConLaiNgayTraByMaP_Thu(mMakh,maP_Thu,tmptList);
         // nếu đã có phiếu nợ => load thông tin cũ lên.
         lastConLai = Double.parseDouble(tmptList[0]);
         lastNgayTra = new Timestamp(Long.parseLong(tmptList[1]));
    
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    // lấy mã phiếu nợ của phiếu hiện tại. 
    public int getNextID(){
        return mP_NoDAO.getNexId();
    }
        
    public int getMaKH(){
        return mMakh;
    }
    
    public String getHoTen(){
        return mHoTen;
    }
    
    
    public int getMaP_Thu(){
        return maP_Thu;
    }
    
    public Double getLastConLai(){
        return lastConLai;
    }
    
    public Timestamp getLastNgayTra(){
        return lastNgayTra;
    }
//</editor-fold>
    
    
}
