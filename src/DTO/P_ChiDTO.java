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
public class P_ChiDTO {
    /*
     * Properties
     */

    private String maP_Chi = null;
    private Timestamp ngayChi = null;
    private String noiDung = null;
    private double soTienChi = 0;
    
    /*
    * Constructor
    */
    public P_ChiDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaP_Chi() {
        return maP_Chi;
    }

    public void setMaP_Chi(String maP_Chi) {
        this.maP_Chi = maP_Chi;
    }

    public Timestamp getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Timestamp ngayChi) {
        this.ngayChi = ngayChi;
    }


    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public double getSoTienChi() {
        return soTienChi;
    }

    public void setSoTienChi(double soTienChi) {
        this.soTienChi = soTienChi;
    }

    
    

}
