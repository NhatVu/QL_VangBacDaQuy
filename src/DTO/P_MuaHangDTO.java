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
public class P_MuaHangDTO {
    /*
     * Properties
     */

    private String maP_MH = null;
    private String maKH = null;
    private Timestamp ngayMua = null;
    private Timestamp ngayThanhToan = null;
    private double tongCong = 0;
    
    /*
    * Constructor
    */
    public P_MuaHangDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaP_MH() {
        return maP_MH;
    }

    public void setMaP_MH(String maP_MH) {
        this.maP_MH = maP_MH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Timestamp getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Timestamp ngayMua) {
        this.ngayMua = ngayMua;
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
