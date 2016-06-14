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

    private int maCTP_TK;
    private int maP_TK;
    private int maHang;
    private int tonDauKy = 0;
    private int tonCuoiKy = 0;
    private int soLuongBan = 0;
    private int soLuongMua = 0;

    /*
     * Constructor
     */
    public CT_TonKhoDTO() {

    }

    /*
     * Getters and Setters
     */
    public int getMaCTP_TK() {
        return maCTP_TK;
    }

    public void setMaCTP_TK(int maCTP_TK) {
        this.maCTP_TK = maCTP_TK;
    }

    public int getMaP_TK() {
        return maP_TK;
    }

    public void setMaP_TK(int maP_TK) {
        this.maP_TK = maP_TK;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
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
