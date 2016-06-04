/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import DTO.*;
import java.util.ArrayList;

/**
 *
 * @author Minh Nhat
 */
public class CT_TonKhoTableModel extends AbstractTableModel {

    private List<CT_TonKhoDTO> lCT_TK = null;
    // Because the model should hold data ( in this case, the data is: instance of class Employee ), 
    // so we declare an instance variable which holds a list of employees ( in this case, the instance variable is: employeeList )

    private final static String[] columnNames = new String[]{
        "Mã hàng", "Tồn đầu kỳ", "Số lượng bán", "Số lượng mua", "Tồn cuối kỳ"
    };
    private final static Class[] columnClass = new Class[]{
        String.class, Integer.class, Integer.class, Integer.class, Integer.class
    };

    public CT_TonKhoTableModel() {
        super();
        lCT_TK =  new ArrayList<CT_TonKhoDTO>();
    }

//    public CT_TonKhoTableModel(List<CT_TonKhoDTO> lCT_TK) {
//        this.lCT_TK = lCT_TK;
//    }

    public List<CT_TonKhoDTO> getCT_TonKhoDTOList() {
        return lCT_TK;
    }

    public void setCT_TonKhoDTOList(List<CT_TonKhoDTO> l) {
        this.lCT_TK = l;
    }

    public void addRow(CT_TonKhoDTO ct_tk) {
        lCT_TK.add(ct_tk);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return lCT_TK.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CT_TonKhoDTO row = lCT_TK.get(rowIndex);
        if (0 == columnIndex) {
            return row.getMaHang();
        } else if (1 == columnIndex) {
            return row.getTonDauKy();
        } else if (2 == columnIndex) {
            return row.getSoLuongBan();
        } else if (3 == columnIndex) {
            return row.getSoLuongMua();
        } else if(4 == columnIndex){
            return row.getTonCuoiKy();
        }
        return null;
    }

   @Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	// TODO Auto-generated method stub
	   CT_TonKhoDTO row = lCT_TK.get(rowIndex);
       if (0 == columnIndex) {
           row.setMaHang((String) aValue);
       } else if (1 == columnIndex) {
           row.setTonDauKy((int) aValue);
       } else if (2 == columnIndex) {
           row.setSoLuongBan((int) aValue);
       } else if (3 == columnIndex) {
           row.setSoLuongMua((int) aValue);
       } else if(4 == columnIndex){
           row.setTonCuoiKy((int) aValue);
       }
}
}
