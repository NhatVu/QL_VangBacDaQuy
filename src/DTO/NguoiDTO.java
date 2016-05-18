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
public class NguoiDTO {
    /*
    * Property
    */
    private String maLoaiNguoi = null;
    private String hoTen = null;
    private String diaChi = null;
    
    /*
    * Constructor 
    */
    
    public NguoiDTO(){
        
    }
    
    /*
    * Getters and setters
    */

    public String getMaLoaiNguoi() {
        return maLoaiNguoi;
    }

    public void setMaLoaiNguoi(String maLoaiNguoi) {
        this.maLoaiNguoi = maLoaiNguoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
       
    
}
