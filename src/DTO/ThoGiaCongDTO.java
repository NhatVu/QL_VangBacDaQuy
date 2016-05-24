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
public class ThoGiaCongDTO {
    /*
    * Properties
    */
    
    private String maTho = null;
    private String maNguoi = null;
    
    /*
    * Constructor
    */
    public ThoGiaCongDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaTho() {
        return maTho;
    }

    public void setMaTho(String maTho) {
        this.maTho = maTho;
    }

    

    public String getMaNguoi() {
        return maNguoi;
    }

    public void setMaNguoi(String maNguoi) {
        this.maNguoi = maNguoi;
    }
    
    
}
