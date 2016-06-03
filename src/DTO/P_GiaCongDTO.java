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

    private String maP_GC;
    private String maThoGC;
    private Timestamp ngayNhanHang;
    private Timestamp ngayThanhToan;
    private double tongCong;

    public P_GiaCongDTO(String maP_GC, String maThoGC, Timestamp ngayNhanHang, Timestamp ngayThanhToan, double tongCong) {
        this.maP_GC = maP_GC;
        this.maThoGC = maThoGC;
        this.ngayNhanHang = ngayNhanHang;
        this.ngayThanhToan = ngayThanhToan;
        this.tongCong = tongCong;
    }
    
    
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

    @Override
    public String toString() {
        return maP_GC+"-"+maThoGC+"-"+ngayNhanHang.toString()+"-"+ngayThanhToan.toString()+"-"+tongCong+"";
    }
    
    

    
    

}
