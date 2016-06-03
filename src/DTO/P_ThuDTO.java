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
public class P_ThuDTO {
    /*
     * Properties
     */

    private String maP_Thu;
    private String maKH;
    private Timestamp ngayLapPhieu;
    private Timestamp ngayKetThuc;
    private double tongCong;

    public P_ThuDTO(String maP_Thu, String maKH, Timestamp ngayLapPhieu, Timestamp ngayKetThuc, double tongCong) {
        this.maP_Thu = maP_Thu;
        this.maKH = maKH;
        this.ngayLapPhieu = ngayLapPhieu;
        this.ngayKetThuc = ngayKetThuc;
        this.tongCong = tongCong;
    }
    
    
    
    /*
    * Constructor
    */
    public P_ThuDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaP_Thu() {
        return maP_Thu;
    }

    public void setMaP_Thu(String maP_Thu) {
        this.maP_Thu = maP_Thu;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Timestamp getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(Timestamp ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getTongCong() {
        return tongCong;
    }

    public void setTongCong(double tongCong) {
        this.tongCong = tongCong;
    }
    

}
