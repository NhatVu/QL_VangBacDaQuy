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
public class CTP_BanHangDTO {
    /*
     * Properties
     */

    private String maCTP_BH = null;
    private String maP_BH = null;
    private String maSP = null;
    private int soLuong = 0;
    private double thanhTien = 0;
    
    /*
    * Constructor
    */
    public CTP_BanHangDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaCTP_BH() {
        return maCTP_BH;
    }

    public void setMaCTP_BH(String maCTP_BH) {
        this.maCTP_BH = maCTP_BH;
    }

    public String getMaP_BH() {
        return maP_BH;
    }

    public void setMaP_BH(String maP_BH) {
        this.maP_BH = maP_BH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    

}
