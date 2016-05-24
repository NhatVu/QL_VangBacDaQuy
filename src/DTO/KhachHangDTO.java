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

    private String maKH = null;
    private String maNguoi = null;
    private int laKhachQuen = 0;
    
    /*
    * Constructor
    */

    public KhachHangDTO() {
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

    public int isLaKhachQuen() {
        return laKhachQuen;
    }

    public void setLaKhachQuen(int laKhachQuen) {
        this.laKhachQuen = laKhachQuen;
    }

   

}
