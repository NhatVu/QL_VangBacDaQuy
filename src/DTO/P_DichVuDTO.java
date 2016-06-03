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
public class P_DichVuDTO {
    /*
     * Properties
     */

    private String maP_DV;
    private String maP_Thu;

    public P_DichVuDTO(String maP_DV, String maP_Thu) {
        this.maP_DV = maP_DV;
        this.maP_Thu = maP_Thu;
    }
    
    
    
    /*
    * Constructor
    */
    public P_DichVuDTO(){
        
    }
    
    /*
    * Getters and Setters
    */

    public String getMaP_DV() {
        return maP_DV;
    }

    public void setMaP_DV(String maP_DV) {
        this.maP_DV = maP_DV;
    }

    public String getMaP_Thu() {
        return maP_Thu;
    }

    public void setMaP_Thu(String maP_Thu) {
        this.maP_Thu = maP_Thu;
    }
    

}
