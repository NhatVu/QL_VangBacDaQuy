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
public class P_NoDTO {
    /*
     * Properties
     */

    private String maP_No = null;
    private String maP_Thu = null;
    private Timestamp ngayNo = null;
    private double soTienNo = 0;
    private Timestamp ngayTra = null;
    private double soTienTra = 0;
    
    /*
    * Constructor
    */
    public P_NoDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaP_No() {
        return maP_No;
    }

    public void setMaP_No(String maP_No) {
        this.maP_No = maP_No;
    }

    public String getMaP_Thu() {
        return maP_Thu;
    }

    public void setMaP_Thu(String maP_Thu) {
        this.maP_Thu = maP_Thu;
    }

    public Timestamp getNgayNo() {
        return ngayNo;
    }

    public void setNgayNo(Timestamp ngayNo) {
        this.ngayNo = ngayNo;
    }

    public double getSoTienNo() {
        return soTienNo;
    }

    public void setSoTienNo(double soTienNo) {
        this.soTienNo = soTienNo;
    }

    public Timestamp getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Timestamp ngayTra) {
        this.ngayTra = ngayTra;
    }

    public double getSoTienTra() {
        return soTienTra;
    }

    public void setSoTienTra(double soTienTra) {
        this.soTienTra = soTienTra;
    }
    

}
