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
public class TonKhoDTO {
    /*
     * Properties
     */

    private int maP_TK;
    private Timestamp ngayBaoCao = null;

    /*
     * Constructor
     */
    public TonKhoDTO() {
    }

    /*
     * Getters and Setters
     */
    public int getMaP_TK() {
        return maP_TK;
    }

    public void setMaP_TK(int maP_TK) {
        this.maP_TK = maP_TK;
    }

    public Timestamp getNgayBaoCao() {
        return ngayBaoCao;
    }

    public void setNgayBaoCao(Timestamp ngayBaoCao) {
        this.ngayBaoCao = ngayBaoCao;
    }

}
