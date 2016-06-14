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
public class CTP_MuaHangDTO {
     /*
     * Properties
     */

    private String maCTP_MH = null;
    private String maP_MH = null;
    private String maSP = null;
    private int soLuong = 0;
    private double thanhTien = 0;
    
    /*
    * Constructor
    */
    
    

    public CTP_MuaHangDTO() {
    }
    
    
    
    /*
    * Getters and Setters
    */

    public CTP_MuaHangDTO(String maCTP_MH, String maP_MH, String maSP, int soLuong, double thanhTien) {
		super();
		this.maCTP_MH = maCTP_MH;
		this.maP_MH = maP_MH;
		this.maSP = maSP;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}



	public String getMaCTP_MH() {
        return maCTP_MH;
    }

    public void setMaCTP_MH(String maCTP_MH) {
        this.maCTP_MH = maCTP_MH;
    }

    public String getMaP_MH() {
        return maP_MH;
    }

    public void setMaP_MH(String maP_MH) {
        this.maP_MH = maP_MH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
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
