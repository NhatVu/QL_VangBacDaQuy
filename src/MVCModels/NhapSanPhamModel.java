package MVCModels;

import DTO.SanPhamDTO;
import DataAcessLayer.SanPhamDAO;

public class NhapSanPhamModel {
    SanPhamDAO spDAO = new SanPhamDAO();
    
    public void insert(SanPhamDTO spDTO){
        spDAO.insert(spDTO);
    }
    
    public void update(SanPhamDTO spDTO){
        spDAO.update(spDTO);
    }
}
