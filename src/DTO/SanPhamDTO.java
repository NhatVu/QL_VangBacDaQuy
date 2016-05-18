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
public class SanPhamDTO {
    /*
     * Properties
     */

    private String maSP = null;
    private String tenSP = null;

    /*
    * Constructor
    */
    public SanPhamDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    
}
