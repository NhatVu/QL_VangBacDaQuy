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
public class CTP_GiaCongDTO {
    /*
     * Properties
     */

    private String maCTP_GC;
    private String maLoaiGC;
    private String maP_GC;
    private int soLuong;
    private double thanhTien;

    public CTP_GiaCongDTO(String maCTP_GC, String maLoaiGC, String maP_GC, int soLuong, double thanhTien) {
        this.maCTP_GC = maCTP_GC;
        this.maLoaiGC = maLoaiGC;
        this.maP_GC = maP_GC;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }
    
    
    
    /*
    * Constructor
    */

    public CTP_GiaCongDTO() {
    }
    
    /*
    * Getters and Setters
    */

    public String getMaCTP_GC() {
        return maCTP_GC;
    }

    public void setMaCTP_GC(String maCTP_GC) {
        this.maCTP_GC = maCTP_GC;
    }

    public String getMaLoaiGC() {
        return maLoaiGC;
    }

    public void setMaLoaiGC(String maLoaiGC) {
        this.maLoaiGC = maLoaiGC;
    }

    public String getMaP_GC() {
        return maP_GC;
    }

    public void setMaP_GC(String maP_GC) {
        this.maP_GC = maP_GC;
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
