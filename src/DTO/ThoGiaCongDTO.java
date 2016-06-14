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

    private int maTho;
    private int maNguoi;

    public ThoGiaCongDTO(int maTho, int maNguoi) {
        this.maTho = maTho;
        this.maNguoi = maNguoi;
    }

    /*
     * Constructor
     */
    public ThoGiaCongDTO() {

    }

    /*
     * Getters and Setters
     */
    public int getMaTho() {
        return maTho;
    }

    public void setMaTho(int maTho) {
        this.maTho = maTho;
    }

    public int getMaNguoi() {
        return maNguoi;
    }

    public void setMaNguoi(int maNguoi) {
        this.maNguoi = maNguoi;
    }

}
