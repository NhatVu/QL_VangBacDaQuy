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
public class CT_TonKhoDTO {
    /*
     * Properties
     */

    private String maCTP_TK = null;
    private String maP_TK = null;
    private String maHang = null;
    private int tonDauKy = 0;
    private int tonCuoiKy = 0;
    private int soLuongBan = 0;
    private int soLuongMua = 0;
    
    /*
    * Constructor
    */
    public CT_TonKhoDTO(){
        
    }

    /*
    * Getters and Setters
    */

    public String getMaCTP_TK() {
        return maCTP_TK;
    }

    public void setMaCTP_TK(String maCTP_TK) {
        this.maCTP_TK = maCTP_TK;
    }

    public String getMaP_TK() {
        return maP_TK;
    }

    public void setMaP_TK(String maP_TK) {
        this.maP_TK = maP_TK;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public int getTonDauKy() {
        return tonDauKy;
    }

    public void setTonDauKy(int tonDauKy) {
        this.tonDauKy = tonDauKy;
    }

    public int getTonCuoiKy() {
        return tonCuoiKy;
    }

    public void setTonCuoiKy(int tonCuoiKy) {
        this.tonCuoiKy = tonCuoiKy;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
    
}
