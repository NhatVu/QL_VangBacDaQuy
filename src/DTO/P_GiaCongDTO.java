/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author Minh Nhat
 */
public class P_GiaCongDTO {
    /*
     * Properties
     */

    private String maP_GC = null;
    private String maThoGC = null;
    private Timestamp ngayNhanHang = null;
    private Timestamp ngayThanhToan = null;
    private double tongCong = 0;
    
    /*
    * Constructor
    */
    public P_GiaCongDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaP_GC() {
        return maP_GC;
    }

    public void setMaP_GC(String maP_GC) {
        this.maP_GC = maP_GC;
    }

    public String getMaThoGC() {
        return maThoGC;
    }

    public void setMaThoGC(String maThoGC) {
        this.maThoGC = maThoGC;
    }

    public Timestamp getNgayNhanHang() {
        return ngayNhanHang;
    }

    public void setNgayNhanHang(Timestamp ngayNhanHang) {
        this.ngayNhanHang = ngayNhanHang;
    }

    public Timestamp getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Timestamp ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTongCong() {
        return tongCong;
    }

    public void setTongCong(double tongCong) {
        this.tongCong = tongCong;
    }

    
    

}
