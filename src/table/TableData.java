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
public class TableData{
    private ArrayList<String> data;

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
    

    public TableData(ArrayList<String> data) {
        this.data = data;
    }

    
    public String getDataAt(int index) {
        return this.data.get(index);
    }

    
    public void setDataAt(int index, String s) {
        this.data.set(index, s);
    }

    
    
    
}
