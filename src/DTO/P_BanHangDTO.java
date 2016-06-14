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
public class P_BanHangDTO {
    /*
     * Properties
     */

    private String maP_BH = null;
    private String maP_Thu = null;
    
    /*
    * Constructor
    */
    public P_BanHangDTO(){
        
    }
    
    public P_BanHangDTO( String maP_BH, String maP_Thu )
    {
    	this.maP_BH = maP_BH;
    	this.maP_Thu = maP_Thu;
    }
    
    /*
    * Getters and Setters
    */

    public String getMaP_BH() {
        return maP_BH;
    }

    public void setMaP_BH(String maP_BH) {
        this.maP_BH = maP_BH;
    }

    public String getMaP_Thu() {
        return maP_Thu;
    }

    public void setMaP_Thu(String maP_Thu) {
        this.maP_Thu = maP_Thu;
    }
    

}
