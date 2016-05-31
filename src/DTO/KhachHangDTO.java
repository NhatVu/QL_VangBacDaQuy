/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Minh Nhat
 */
public class KhachHangDTO {
    /*
     * Properties
     */

    private String maKH;
    private String maNguoi;
    private boolean laKhachQuen;
    
    
    
    /*
    * Constructor
    */

    public KhachHangDTO(String maKH, String maNguoi, boolean laKhachQuen) {
        this.maKH = maKH;
        this.maNguoi = maNguoi;
        this.laKhachQuen = laKhachQuen;
    }

 

    
    
    
    /*
    * Gettes and setters
    */

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNguoi() {
        return maNguoi;
    }

    public void setMaNguoi(String maNguoi) {
        this.maNguoi = maNguoi;
    }

    public boolean isLaKhachQuen() {
        return laKhachQuen;
    }

    public void setLaKhachQuen(boolean laKhachQuen) {
        this.laKhachQuen = laKhachQuen;
    }

   

}
