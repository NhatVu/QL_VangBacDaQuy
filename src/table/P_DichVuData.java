/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class P_DichVuData extends TableDataAdapter{
    private ArrayList<String> data;

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
    

    public P_DichVuData(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public String getDataAt(int index) {
        return this.data.get(index);
    }

    @Override
    public void setDataAt(int index, String s) {
        this.data.set(index, s);
    }

    
    
    
}
