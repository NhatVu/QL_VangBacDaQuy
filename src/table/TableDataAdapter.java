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
public abstract class TableDataAdapter {
    public abstract String getDataAt(int index);
    public abstract void setDataAt(int index,String s);
}
