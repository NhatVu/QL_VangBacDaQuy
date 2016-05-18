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
public class HangGiaCongDTO {
    /*
     * Properties
     */

    private String maLoaiGC = null;
    private String tenLoaiGC = null;
    
    /*
    * Constructor
    */
    public HangGiaCongDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaLoaiGC() {
        return maLoaiGC;
    }

    public void setMaLoaiGC(String maLoaiGC) {
        this.maLoaiGC = maLoaiGC;
    }

    public String getTenLoaiGC() {
        return tenLoaiGC;
    }

    public void setTenLoaiGC(String tenLoaiGC) {
        this.tenLoaiGC = tenLoaiGC;
    }
    

}
