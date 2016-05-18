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
public class CTP_ChiDTO {
    /*
     * Properties
     */

    private String maCTP_Chi = null;
    private String maP_Chi = null;
    private String maPhi = null;
    private String tenPhi = null;
    private double thanhTien = 0;
    
    /*
    * Constructor
    */
    public CTP_ChiDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaCTP_Chi() {
        return maCTP_Chi;
    }

    public void setMaCTP_Chi(String maCTP_Chi) {
        this.maCTP_Chi = maCTP_Chi;
    }

    public String getMaP_Chi() {
        return maP_Chi;
    }

    public void setMaP_Chi(String maP_Chi) {
        this.maP_Chi = maP_Chi;
    }

    public String getMaPhi() {
        return maPhi;
    }

    public void setMaPhi(String maPhi) {
        this.maPhi = maPhi;
    }

    public String getTenPhi() {
        return tenPhi;
    }

    public void setTenPhi(String tenPhi) {
        this.tenPhi = tenPhi;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    

}
