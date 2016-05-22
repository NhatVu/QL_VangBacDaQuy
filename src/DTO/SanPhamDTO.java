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
public class SanPhamDTO {
    /*
     * Properties
     */

    private String maSP = null;
    private String tenSP = null;
    private double donGiaBan = 0;
    private double donGiaMua = 0;
    private int soLuongTon = 0;

    /*
    * Constructor
    */
    public SanPhamDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public double getDonGiaMua() {
        return donGiaMua;
    }

    public void setDonGiaMua(double donGiaMua) {
        this.donGiaMua = donGiaMua;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }
    
    
    
}
